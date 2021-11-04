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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductSpecificationMappingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingLocalService
 * @generated
 */
public class ProductSpecificationMappingLocalServiceWrapper
	implements ProductSpecificationMappingLocalService,
			   ServiceWrapper<ProductSpecificationMappingLocalService> {

	public ProductSpecificationMappingLocalServiceWrapper(
		ProductSpecificationMappingLocalService
			productSpecificationMappingLocalService) {

		_productSpecificationMappingLocalService =
			productSpecificationMappingLocalService;
	}

	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping addProductSpecificationMapping(
				long userId, long companyId, String productType,
				long cpSpecificationOptionId, long cpOptionCategoryId,
				double priority,
				java.util.Map<java.util.Locale, String> defaultValueMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.
			addProductSpecificationMapping(
				userId, companyId, productType, cpSpecificationOptionId,
				cpOptionCategoryId, priority, defaultValueMap, serviceContext);
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
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping addProductSpecificationMapping(
			com.liferay.commerce.demo.product.specification.template.model.
				ProductSpecificationMapping productSpecificationMapping) {

		return _productSpecificationMappingLocalService.
			addProductSpecificationMapping(productSpecificationMapping);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping createProductSpecificationMapping(
			long productSpecificationMappingId) {

		return _productSpecificationMappingLocalService.
			createProductSpecificationMapping(productSpecificationMappingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping deleteProductSpecificationMapping(
				long productSpecificationMappingId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.
			deleteProductSpecificationMapping(productSpecificationMappingId);
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
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping deleteProductSpecificationMapping(
			com.liferay.commerce.demo.product.specification.template.model.
				ProductSpecificationMapping productSpecificationMapping) {

		return _productSpecificationMappingLocalService.
			deleteProductSpecificationMapping(productSpecificationMapping);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productSpecificationMappingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productSpecificationMappingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSpecificationMappingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productSpecificationMappingLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productSpecificationMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productSpecificationMappingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productSpecificationMappingLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productSpecificationMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping fetchProductSpecificationMapping(
			long productSpecificationMappingId) {

		return _productSpecificationMappingLocalService.
			fetchProductSpecificationMapping(productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping
			fetchProductSpecificationMappingByUuidAndCompanyId(
				String uuid, long companyId) {

		return _productSpecificationMappingLocalService.
			fetchProductSpecificationMappingByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productSpecificationMappingLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productSpecificationMappingLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productSpecificationMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productSpecificationMappingLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product specification mapping with the primary key.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws PortalException if a product specification mapping with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping getProductSpecificationMapping(
				long productSpecificationMappingId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMapping(productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the matching UUID and company.
	 *
	 * @param uuid the product specification mapping's UUID
	 * @param companyId the primary key of the company
	 * @return the matching product specification mapping
	 * @throws PortalException if a matching product specification mapping could not be found
	 */
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping
				getProductSpecificationMappingByUuidAndCompanyId(
					String uuid, long companyId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMappingByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.liferay.commerce.demo.product.specification.template.model.
			ProductSpecificationMapping> getProductSpecificationMappings(
				int start, int end) {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMappings(start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.demo.product.specification.template.model.
			ProductSpecificationMapping> getProductSpecificationMappings(
				String productType) {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMappings(productType);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.demo.product.specification.template.model.
			ProductSpecificationMapping> getProductSpecificationMappings(
				String productType, int start, int end) {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMappings(productType, start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.demo.product.specification.template.model.
			ProductSpecificationMapping> getProductSpecificationMappings(
				String productType, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.commerce.demo.product.specification.template.
						model.ProductSpecificationMapping> obc) {

		return _productSpecificationMappingLocalService.
			getProductSpecificationMappings(productType, start, end, obc);
	}

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	@Override
	public int getProductSpecificationMappingsCount() {
		return _productSpecificationMappingLocalService.
			getProductSpecificationMappingsCount();
	}

	@Override
	public int getProductSpecificationMappingsCount(String productType) {
		return _productSpecificationMappingLocalService.
			getProductSpecificationMappingsCount(productType);
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
	@Override
	public com.liferay.commerce.demo.product.specification.template.model.
		ProductSpecificationMapping updateProductSpecificationMapping(
			com.liferay.commerce.demo.product.specification.template.model.
				ProductSpecificationMapping productSpecificationMapping) {

		return _productSpecificationMappingLocalService.
			updateProductSpecificationMapping(productSpecificationMapping);
	}

	@Override
	public ProductSpecificationMappingLocalService getWrappedService() {
		return _productSpecificationMappingLocalService;
	}

	@Override
	public void setWrappedService(
		ProductSpecificationMappingLocalService
			productSpecificationMappingLocalService) {

		_productSpecificationMappingLocalService =
			productSpecificationMappingLocalService;
	}

	private ProductSpecificationMappingLocalService
		_productSpecificationMappingLocalService;

}