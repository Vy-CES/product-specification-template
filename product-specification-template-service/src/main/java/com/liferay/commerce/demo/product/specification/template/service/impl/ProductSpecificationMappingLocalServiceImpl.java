/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.demo.product.specification.template.service.impl;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.commerce.demo.product.specification.template.service.base.ProductSpecificationMappingLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;


import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the product specification mapping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.demo.product.specification.template.service.ProductSpecificationMappingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping",
	service = AopService.class
)
public class ProductSpecificationMappingLocalServiceImpl
	extends ProductSpecificationMappingLocalServiceBaseImpl {

	public ProductSpecificationMapping addProductSpecificationMapping(long userId, long companyId,
																	  String productType, long cpSpecificationOptionId,
																	  long cpOptionCategoryId, double priority,
																	  Map<Locale, String> defaultValueMap,
																	  ServiceContext serviceContext) throws PortalException {

		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		long entryId = counterLocalService.increment();
		long productSpecificationMappingId = counterLocalService.increment();

		ProductSpecificationMapping productSpecificationMapping = productSpecificationMappingPersistence.create(productSpecificationMappingId);
		productSpecificationMapping.setUuid(serviceContext.getUuid());
		productSpecificationMapping.setUserId(userId);
		productSpecificationMapping.setCompanyId(companyId);
		productSpecificationMapping.setUserName(user.getFullName());
		productSpecificationMapping.setCreateDate(now);
		productSpecificationMapping.setModifiedDate(now);
		productSpecificationMapping.setProductType(productType);
		productSpecificationMapping.setCpSpecificationOptionId(cpSpecificationOptionId);
		productSpecificationMapping.setCpOptionCategoryId(cpOptionCategoryId);
		productSpecificationMapping.setPriority(priority);
		productSpecificationMapping.setDefaultValueMap(defaultValueMap);
		productSpecificationMappingPersistence.updateImpl(productSpecificationMapping);

		return productSpecificationMapping;
	}

	public List<ProductSpecificationMapping> getProductSpecificationMappings(String productType) {
		return productSpecificationMappingPersistence.findByProductType(productType);
	}

	public List<ProductSpecificationMapping> getProductSpecificationMappings(String productType, int start, int end) {
		return productSpecificationMappingPersistence.findByProductType(productType, start, end);
	}

	public List<ProductSpecificationMapping> getProductSpecificationMappings(String productType, int start,
																			 int end, OrderByComparator<ProductSpecificationMapping> obc) {
		return productSpecificationMappingPersistence.findByProductType(productType, start, end, obc);
	}

	public ProductSpecificationMapping getProductSpecificationMapping(long entryId) throws PortalException {
		return productSpecificationMappingPersistence.findByPrimaryKey(entryId);
	}

	public int getProductSpecificationMappingsCount(String productType) {
		return productSpecificationMappingPersistence.countByProductType(productType);
	}
}