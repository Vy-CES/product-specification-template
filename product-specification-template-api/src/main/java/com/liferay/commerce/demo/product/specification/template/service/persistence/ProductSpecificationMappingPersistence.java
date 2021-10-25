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

import com.liferay.commerce.demo.product.specification.template.exception.NoSuchProductSpecificationMappingException;
import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product specification mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingUtil
 * @generated
 */
@ProviderType
public interface ProductSpecificationMappingPersistence
	extends BasePersistence<ProductSpecificationMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductSpecificationMappingUtil} to access the product specification mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specification mappings
	 */
	public java.util.List<ProductSpecificationMapping> findByUuid(String uuid);

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
	public java.util.List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

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
	public java.util.List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

	/**
	 * Returns the product specification mappings before and after the current product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecificationMappingId the primary key of the current product specification mapping
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public ProductSpecificationMapping[] findByUuid_PrevAndNext(
			long productSpecificationMappingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Removes all the product specification mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specification mappings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specification mappings
	 */
	public java.util.List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

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
	public java.util.List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

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
	public ProductSpecificationMapping[] findByUuid_C_PrevAndNext(
			long productSpecificationMappingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Removes all the product specification mappings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specification mappings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the matching product specification mappings
	 */
	public java.util.List<ProductSpecificationMapping> findByProductType(
		String productType);

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
	public java.util.List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end);

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
	public java.util.List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

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
	public java.util.List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByProductType_First(
			String productType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByProductType_First(
		String productType,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping findByProductType_Last(
			String productType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	public ProductSpecificationMapping fetchByProductType_Last(
		String productType,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

	/**
	 * Returns the product specification mappings before and after the current product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productSpecificationMappingId the primary key of the current product specification mapping
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public ProductSpecificationMapping[] findByProductType_PrevAndNext(
			long productSpecificationMappingId, String productType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Removes all the product specification mappings where productType = &#63; from the database.
	 *
	 * @param productType the product type
	 */
	public void removeByProductType(String productType);

	/**
	 * Returns the number of product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the number of matching product specification mappings
	 */
	public int countByProductType(String productType);

	/**
	 * Caches the product specification mapping in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMapping the product specification mapping
	 */
	public void cacheResult(
		ProductSpecificationMapping productSpecificationMapping);

	/**
	 * Caches the product specification mappings in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMappings the product specification mappings
	 */
	public void cacheResult(
		java.util.List<ProductSpecificationMapping>
			productSpecificationMappings);

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	public ProductSpecificationMapping create(
		long productSpecificationMappingId);

	/**
	 * Removes the product specification mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping that was removed
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public ProductSpecificationMapping remove(
			long productSpecificationMappingId)
		throws NoSuchProductSpecificationMappingException;

	public ProductSpecificationMapping updateImpl(
		ProductSpecificationMapping productSpecificationMapping);

	/**
	 * Returns the product specification mapping with the primary key or throws a <code>NoSuchProductSpecificationMappingException</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	public ProductSpecificationMapping findByPrimaryKey(
			long productSpecificationMappingId)
		throws NoSuchProductSpecificationMappingException;

	/**
	 * Returns the product specification mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping, or <code>null</code> if a product specification mapping with the primary key could not be found
	 */
	public ProductSpecificationMapping fetchByPrimaryKey(
		long productSpecificationMappingId);

	/**
	 * Returns all the product specification mappings.
	 *
	 * @return the product specification mappings
	 */
	public java.util.List<ProductSpecificationMapping> findAll();

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
	public java.util.List<ProductSpecificationMapping> findAll(
		int start, int end);

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
	public java.util.List<ProductSpecificationMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator);

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
	public java.util.List<ProductSpecificationMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product specification mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	public int countAll();

}