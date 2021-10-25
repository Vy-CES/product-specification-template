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

package com.liferay.commerce.demo.product.specification.template.service.persistence;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the product specification mapping service. This utility wraps <code>com.liferay.commerce.demo.product.specification.template.service.persistence.impl.ProductSpecificationMappingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingPersistence
 * @generated
 */
public class ProductSpecificationMappingUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		ProductSpecificationMapping productSpecificationMapping) {

		getPersistence().clearCache(productSpecificationMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProductSpecificationMapping>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductSpecificationMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSpecificationMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSpecificationMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductSpecificationMapping update(
		ProductSpecificationMapping productSpecificationMapping) {

		return getPersistence().update(productSpecificationMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductSpecificationMapping update(
		ProductSpecificationMapping productSpecificationMapping,
		ServiceContext serviceContext) {

		return getPersistence().update(
			productSpecificationMapping, serviceContext);
	}

	/**
	 * Returns all the product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product specification mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @return the range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product specification mappings before and after the current product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecificationMappingId the primary key of the current product specification mapping
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping[] findByUuid_PrevAndNext(
			long productSpecificationMappingId, String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_PrevAndNext(
			productSpecificationMappingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product specification mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specification mappings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @return the range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product specification mappings before and after the current product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecificationMappingId the primary key of the current product specification mapping
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping[] findByUuid_C_PrevAndNext(
			long productSpecificationMappingId, String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productSpecificationMappingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product specification mappings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specification mappings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByProductType(
		String productType) {

		return getPersistence().findByProductType(productType);
	}

	/**
	 * Returns a range of all the product specification mappings where productType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param productType the product type
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @return the range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end) {

		return getPersistence().findByProductType(productType, start, end);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where productType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param productType the product type
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().findByProductType(
			productType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specification mappings where productType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param productType the product type
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specification mappings
	 */
	public static List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProductType(
			productType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByProductType_First(
			String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByProductType_First(
			productType, orderByComparator);
	}

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByProductType_First(
		String productType,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByProductType_First(
			productType, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping findByProductType_Last(
			String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByProductType_Last(
			productType, orderByComparator);
	}

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping fetchByProductType_Last(
		String productType,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().fetchByProductType_Last(
			productType, orderByComparator);
	}

	/**
	 * Returns the product specification mappings before and after the current product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productSpecificationMappingId the primary key of the current product specification mapping
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping[] findByProductType_PrevAndNext(
			long productSpecificationMappingId, String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByProductType_PrevAndNext(
			productSpecificationMappingId, productType, orderByComparator);
	}

	/**
	 * Removes all the product specification mappings where productType = &#63; from the database.
	 *
	 * @param productType the product type
	 */
	public static void removeByProductType(String productType) {
		getPersistence().removeByProductType(productType);
	}

	/**
	 * Returns the number of product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the number of matching product specification mappings
	 */
	public static int countByProductType(String productType) {
		return getPersistence().countByProductType(productType);
	}

	/**
	 * Caches the product specification mapping in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMapping the product specification mapping
	 */
	public static void cacheResult(
		ProductSpecificationMapping productSpecificationMapping) {

		getPersistence().cacheResult(productSpecificationMapping);
	}

	/**
	 * Caches the product specification mappings in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMappings the product specification mappings
	 */
	public static void cacheResult(
		List<ProductSpecificationMapping> productSpecificationMappings) {

		getPersistence().cacheResult(productSpecificationMappings);
	}

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	public static ProductSpecificationMapping create(
		long productSpecificationMappingId) {

		return getPersistence().create(productSpecificationMappingId);
	}

	/**
	 * Removes the product specification mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping that was removed
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping remove(
			long productSpecificationMappingId)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().remove(productSpecificationMappingId);
	}

	public static ProductSpecificationMapping updateImpl(
		ProductSpecificationMapping productSpecificationMapping) {

		return getPersistence().updateImpl(productSpecificationMapping);
	}

	/**
	 * Returns the product specification mapping with the primary key or throws a <code>NoSuchProductSpecificationMappingException</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping findByPrimaryKey(
			long productSpecificationMappingId)
		throws com.liferay.commerce.demo.product.specification.template.
			exception.NoSuchProductSpecificationMappingException {

		return getPersistence().findByPrimaryKey(productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping, or <code>null</code> if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping fetchByPrimaryKey(
		long productSpecificationMappingId) {

		return getPersistence().fetchByPrimaryKey(
			productSpecificationMappingId);
	}

	/**
	 * Returns all the product specification mappings.
	 *
	 * @return the product specification mappings
	 */
	public static List<ProductSpecificationMapping> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product specification mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @return the range of product specification mappings
	 */
	public static List<ProductSpecificationMapping> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product specification mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product specification mappings
	 */
	public static List<ProductSpecificationMapping> findAll(
		int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specification mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specification mappings
	 * @param end the upper bound of the range of product specification mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product specification mappings
	 */
	public static List<ProductSpecificationMapping> findAll(
		int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product specification mappings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductSpecificationMappingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductSpecificationMappingPersistence,
		 ProductSpecificationMappingPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProductSpecificationMappingPersistence.class);

		ServiceTracker
			<ProductSpecificationMappingPersistence,
			 ProductSpecificationMappingPersistence> serviceTracker =
				new ServiceTracker
					<ProductSpecificationMappingPersistence,
					 ProductSpecificationMappingPersistence>(
						 bundle.getBundleContext(),
						 ProductSpecificationMappingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}