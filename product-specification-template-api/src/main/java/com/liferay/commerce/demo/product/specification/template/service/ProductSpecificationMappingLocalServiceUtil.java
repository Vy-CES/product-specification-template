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
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductSpecificationMapping. This utility wraps
 * <code>com.liferay.commerce.demo.product.specification.template.service.impl.ProductSpecificationMappingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingLocalService
 * @generated
 */
public class ProductSpecificationMappingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.demo.product.specification.template.service.impl.ProductSpecificationMappingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ProductSpecificationMapping addProductSpecificationMapping(
			long userId, long companyId, String productType,
			long cpSpecificationOptionId, long cpOptionCategoryId,
			double priority, String defaultValue,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addProductSpecificationMapping(
			userId, companyId, productType, cpSpecificationOptionId,
			cpOptionCategoryId, priority, defaultValue, serviceContext);
	}

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
	public static ProductSpecificationMapping addProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping) {

		return getService().addProductSpecificationMapping(
			productSpecificationMapping);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	public static ProductSpecificationMapping createProductSpecificationMapping(
		long productSpecificationMappingId) {

		return getService().createProductSpecificationMapping(
			productSpecificationMappingId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

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
	public static ProductSpecificationMapping deleteProductSpecificationMapping(
			long productSpecificationMappingId)
		throws PortalException {

		return getService().deleteProductSpecificationMapping(
			productSpecificationMappingId);
	}

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
	public static ProductSpecificationMapping deleteProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping) {

		return getService().deleteProductSpecificationMapping(
			productSpecificationMapping);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProductSpecificationMapping fetchProductSpecificationMapping(
		long productSpecificationMappingId) {

		return getService().fetchProductSpecificationMapping(
			productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping
		fetchProductSpecificationMappingByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchProductSpecificationMappingByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product specification mapping with the primary key.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws PortalException if a product specification mapping with the primary key could not be found
	 */
	public static ProductSpecificationMapping getProductSpecificationMapping(
			long productSpecificationMappingId)
		throws PortalException {

		return getService().getProductSpecificationMapping(
			productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping
	 * @throws PortalException if a matching product specification mapping could not be found
	 */
	public static ProductSpecificationMapping
			getProductSpecificationMappingByUuidAndCompanyId(
				String uuid, long companyId)
		throws PortalException {

		return getService().getProductSpecificationMappingByUuidAndCompanyId(
			uuid, companyId);
	}

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
	public static List<ProductSpecificationMapping>
		getProductSpecificationMappings(int start, int end) {

		return getService().getProductSpecificationMappings(start, end);
	}

	public static List<ProductSpecificationMapping>
		getProductSpecificationMappings(String productType) {

		return getService().getProductSpecificationMappings(productType);
	}

	public static List<ProductSpecificationMapping>
		getProductSpecificationMappings(
			String productType, int start, int end) {

		return getService().getProductSpecificationMappings(
			productType, start, end);
	}

	public static List<ProductSpecificationMapping>
		getProductSpecificationMappings(
			String productType, int start, int end,
			OrderByComparator<ProductSpecificationMapping> obc) {

		return getService().getProductSpecificationMappings(
			productType, start, end, obc);
	}

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	public static int getProductSpecificationMappingsCount() {
		return getService().getProductSpecificationMappingsCount();
	}

	public static int getProductSpecificationMappingsCount(String productType) {
		return getService().getProductSpecificationMappingsCount(productType);
	}

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
	public static ProductSpecificationMapping updateProductSpecificationMapping(
		ProductSpecificationMapping productSpecificationMapping) {

		return getService().updateProductSpecificationMapping(
			productSpecificationMapping);
	}

	public static ProductSpecificationMappingLocalService getService() {
		return _service;
	}

	private static volatile ProductSpecificationMappingLocalService _service;

}