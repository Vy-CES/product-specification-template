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

package com.liferay.commerce.demo.product.specification.template.service;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProductSpecificationMapping. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProductSpecificationMappingLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.commerce.demo.product.specification.template.service.impl.ProductSpecificationMappingLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the product specification mapping local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProductSpecificationMappingLocalServiceUtil} if injection and service tracking are not available.
	 */
	public ProductSpecificationMapping addProductSpecificationMapping(
			long userId, long companyId, String productType,
			long cpSpecificationOptionId, long cpOptionCategoryId,
			double priority, String defaultValue, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the product specification mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecificationMapping the product specification mapping
	 * @return the product specification mapping that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProductSpecificationMapping addProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	@Transactional(enabled = false)
	public ProductSpecificationMapping createProductSpecificationMapping(
		long productSpecificationMappingId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the product specification mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping that was removed
	 * @throws PortalException if a product specification mapping with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProductSpecificationMapping deleteProductSpecificationMapping(
			long productSpecificationMappingId)
		throws PortalException;

	/**
	 * Deletes the product specification mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecificationMapping the product specification mapping
	 * @return the product specification mapping that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProductSpecificationMapping deleteProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.demo.product.specification.template.model.impl.ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.demo.product.specification.template.model.impl.ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductSpecificationMapping fetchProductSpecificationMapping(
		long productSpecificationMappingId);

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductSpecificationMapping
		fetchProductSpecificationMappingByUuidAndCompanyId(
			String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the product specification mapping with the primary key.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws PortalException if a product specification mapping with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductSpecificationMapping getProductSpecificationMapping(
			long productSpecificationMappingId)
		throws PortalException;

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping
	 * @throws PortalException if a matching product specification mapping could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductSpecificationMapping
			getProductSpecificationMappingByUuidAndCompanyId(
				String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the product specification mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.demo.product.specification.template.model.impl.ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @return the range of product specification mappings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductSpecificationMapping> getProductSpecificationMappings(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductSpecificationMapping> getProductSpecificationMappings(
		String productType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductSpecificationMapping> getProductSpecificationMappings(
		String productType, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductSpecificationMapping> getProductSpecificationMappings(
		String productType, int start, int end,
		OrderByComparator<ProductSpecificationMapping> obc);

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProductSpecificationMappingsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProductSpecificationMappingsCount(String productType);

	/**
	 * Updates the product specification mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecificationMapping the product specification mapping
	 * @return the product specification mapping that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProductSpecificationMapping updateProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping);

}