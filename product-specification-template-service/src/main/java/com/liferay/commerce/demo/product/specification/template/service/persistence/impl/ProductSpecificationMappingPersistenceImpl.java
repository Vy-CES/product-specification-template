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

package com.liferay.commerce.demo.product.specification.template.service.persistence.impl;

import com.liferay.commerce.demo.product.specification.template.exception.NoSuchProductSpecificationMappingException;
import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.commerce.demo.product.specification.template.model.impl.ProductSpecificationMappingImpl;
import com.liferay.commerce.demo.product.specification.template.model.impl.ProductSpecificationMappingModelImpl;
import com.liferay.commerce.demo.product.specification.template.service.persistence.ProductSpecificationMappingPersistence;
import com.liferay.commerce.demo.product.specification.template.service.persistence.impl.constants.PTPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the product specification mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductSpecificationMappingPersistence.class)
public class ProductSpecificationMappingPersistenceImpl
	extends BasePersistenceImpl<ProductSpecificationMapping>
	implements ProductSpecificationMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductSpecificationMappingUtil</code> to access the product specification mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductSpecificationMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specification mappings
	 */
	@Override
	public List<ProductSpecificationMapping> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ProductSpecificationMapping> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecificationMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecificationMapping productSpecificationMapping :
						list) {

					if (!uuid.equals(productSpecificationMapping.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ProductSpecificationMapping>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByUuid_First(uuid, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		List<ProductSpecificationMapping> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByUuid_Last(uuid, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductSpecificationMapping> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProductSpecificationMapping[] findByUuid_PrevAndNext(
			long productSpecificationMappingId, String uuid,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		uuid = Objects.toString(uuid, "");

		ProductSpecificationMapping productSpecificationMapping =
			findByPrimaryKey(productSpecificationMappingId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecificationMapping[] array =
				new ProductSpecificationMappingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productSpecificationMapping, uuid, orderByComparator,
				true);

			array[1] = productSpecificationMapping;

			array[2] = getByUuid_PrevAndNext(
				session, productSpecificationMapping, uuid, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecificationMapping getByUuid_PrevAndNext(
		Session session,
		ProductSpecificationMapping productSpecificationMapping, String uuid,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productSpecificationMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecificationMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specification mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductSpecificationMapping productSpecificationMapping :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSpecificationMapping);
		}
	}

	/**
	 * Returns the number of product specification mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specification mappings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"productSpecificationMapping.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productSpecificationMapping.uuid IS NULL OR productSpecificationMapping.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specification mappings
	 */
	@Override
	public List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ProductSpecificationMapping> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ProductSpecificationMapping> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecificationMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecificationMapping productSpecificationMapping :
						list) {

					if (!uuid.equals(productSpecificationMapping.getUuid()) ||
						(companyId !=
							productSpecificationMapping.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ProductSpecificationMapping>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ProductSpecificationMapping findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the first product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		List<ProductSpecificationMapping> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProductSpecificationMapping findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the last product specification mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductSpecificationMapping> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProductSpecificationMapping[] findByUuid_C_PrevAndNext(
			long productSpecificationMappingId, String uuid, long companyId,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		uuid = Objects.toString(uuid, "");

		ProductSpecificationMapping productSpecificationMapping =
			findByPrimaryKey(productSpecificationMappingId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecificationMapping[] array =
				new ProductSpecificationMappingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productSpecificationMapping, uuid, companyId,
				orderByComparator, true);

			array[1] = productSpecificationMapping;

			array[2] = getByUuid_C_PrevAndNext(
				session, productSpecificationMapping, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecificationMapping getByUuid_C_PrevAndNext(
		Session session,
		ProductSpecificationMapping productSpecificationMapping, String uuid,
		long companyId,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productSpecificationMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecificationMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specification mappings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductSpecificationMapping productSpecificationMapping :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSpecificationMapping);
		}
	}

	/**
	 * Returns the number of product specification mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specification mappings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"productSpecificationMapping.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productSpecificationMapping.uuid IS NULL OR productSpecificationMapping.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productSpecificationMapping.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProductType;
	private FinderPath _finderPathWithoutPaginationFindByProductType;
	private FinderPath _finderPathCountByProductType;

	/**
	 * Returns all the product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the matching product specification mappings
	 */
	@Override
	public List<ProductSpecificationMapping> findByProductType(
		String productType) {

		return findByProductType(
			productType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end) {

		return findByProductType(productType, start, end, null);
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
	@Override
	public List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return findByProductType(
			productType, start, end, orderByComparator, true);
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
	@Override
	public List<ProductSpecificationMapping> findByProductType(
		String productType, int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		productType = Objects.toString(productType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProductType;
				finderArgs = new Object[] {productType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProductType;
			finderArgs = new Object[] {
				productType, start, end, orderByComparator
			};
		}

		List<ProductSpecificationMapping> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecificationMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecificationMapping productSpecificationMapping :
						list) {

					if (!productType.equals(
							productSpecificationMapping.getProductType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindProductType = false;

			if (productType.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_3);
			}
			else {
				bindProductType = true;

				sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductType) {
					queryPos.add(productType);
				}

				list = (List<ProductSpecificationMapping>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping findByProductType_First(
			String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByProductType_First(productType, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productType=");
		sb.append(productType);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the first product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByProductType_First(
		String productType,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		List<ProductSpecificationMapping> list = findByProductType(
			productType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping findByProductType_Last(
			String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByProductType_Last(productType, orderByComparator);

		if (productSpecificationMapping != null) {
			return productSpecificationMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productType=");
		sb.append(productType);

		sb.append("}");

		throw new NoSuchProductSpecificationMappingException(sb.toString());
	}

	/**
	 * Returns the last product specification mapping in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification mapping, or <code>null</code> if a matching product specification mapping could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByProductType_Last(
		String productType,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		int count = countByProductType(productType);

		if (count == 0) {
			return null;
		}

		List<ProductSpecificationMapping> list = findByProductType(
			productType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProductSpecificationMapping[] findByProductType_PrevAndNext(
			long productSpecificationMappingId, String productType,
			OrderByComparator<ProductSpecificationMapping> orderByComparator)
		throws NoSuchProductSpecificationMappingException {

		productType = Objects.toString(productType, "");

		ProductSpecificationMapping productSpecificationMapping =
			findByPrimaryKey(productSpecificationMappingId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecificationMapping[] array =
				new ProductSpecificationMappingImpl[3];

			array[0] = getByProductType_PrevAndNext(
				session, productSpecificationMapping, productType,
				orderByComparator, true);

			array[1] = productSpecificationMapping;

			array[2] = getByProductType_PrevAndNext(
				session, productSpecificationMapping, productType,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecificationMapping getByProductType_PrevAndNext(
		Session session,
		ProductSpecificationMapping productSpecificationMapping,
		String productType,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE);

		boolean bindProductType = false;

		if (productType.isEmpty()) {
			sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_3);
		}
		else {
			bindProductType = true;

			sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProductType) {
			queryPos.add(productType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productSpecificationMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecificationMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specification mappings where productType = &#63; from the database.
	 *
	 * @param productType the product type
	 */
	@Override
	public void removeByProductType(String productType) {
		for (ProductSpecificationMapping productSpecificationMapping :
				findByProductType(
					productType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSpecificationMapping);
		}
	}

	/**
	 * Returns the number of product specification mappings where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the number of matching product specification mappings
	 */
	@Override
	public int countByProductType(String productType) {
		productType = Objects.toString(productType, "");

		FinderPath finderPath = _finderPathCountByProductType;

		Object[] finderArgs = new Object[] {productType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATIONMAPPING_WHERE);

			boolean bindProductType = false;

			if (productType.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_3);
			}
			else {
				bindProductType = true;

				sb.append(_FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductType) {
					queryPos.add(productType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_2 =
		"productSpecificationMapping.productType = ?";

	private static final String _FINDER_COLUMN_PRODUCTTYPE_PRODUCTTYPE_3 =
		"(productSpecificationMapping.productType IS NULL OR productSpecificationMapping.productType = '')";

	public ProductSpecificationMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductSpecificationMapping.class);

		setModelImplClass(ProductSpecificationMappingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the product specification mapping in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMapping the product specification mapping
	 */
	@Override
	public void cacheResult(
		ProductSpecificationMapping productSpecificationMapping) {

		entityCache.putResult(
			ProductSpecificationMappingImpl.class,
			productSpecificationMapping.getPrimaryKey(),
			productSpecificationMapping);
	}

	/**
	 * Caches the product specification mappings in the entity cache if it is enabled.
	 *
	 * @param productSpecificationMappings the product specification mappings
	 */
	@Override
	public void cacheResult(
		List<ProductSpecificationMapping> productSpecificationMappings) {

		for (ProductSpecificationMapping productSpecificationMapping :
				productSpecificationMappings) {

			if (entityCache.getResult(
					ProductSpecificationMappingImpl.class,
					productSpecificationMapping.getPrimaryKey()) == null) {

				cacheResult(productSpecificationMapping);
			}
		}
	}

	/**
	 * Clears the cache for all product specification mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductSpecificationMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product specification mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProductSpecificationMapping productSpecificationMapping) {

		entityCache.removeResult(
			ProductSpecificationMappingImpl.class, productSpecificationMapping);
	}

	@Override
	public void clearCache(
		List<ProductSpecificationMapping> productSpecificationMappings) {

		for (ProductSpecificationMapping productSpecificationMapping :
				productSpecificationMappings) {

			entityCache.removeResult(
				ProductSpecificationMappingImpl.class,
				productSpecificationMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductSpecificationMappingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new product specification mapping with the primary key. Does not add the product specification mapping to the database.
	 *
	 * @param productSpecificationMappingId the primary key for the new product specification mapping
	 * @return the new product specification mapping
	 */
	@Override
	public ProductSpecificationMapping create(
		long productSpecificationMappingId) {

		ProductSpecificationMapping productSpecificationMapping =
			new ProductSpecificationMappingImpl();

		productSpecificationMapping.setNew(true);
		productSpecificationMapping.setPrimaryKey(
			productSpecificationMappingId);

		String uuid = PortalUUIDUtil.generate();

		productSpecificationMapping.setUuid(uuid);

		productSpecificationMapping.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return productSpecificationMapping;
	}

	/**
	 * Removes the product specification mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping that was removed
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	@Override
	public ProductSpecificationMapping remove(
			long productSpecificationMappingId)
		throws NoSuchProductSpecificationMappingException {

		return remove((Serializable)productSpecificationMappingId);
	}

	/**
	 * Removes the product specification mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product specification mapping
	 * @return the product specification mapping that was removed
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	@Override
	public ProductSpecificationMapping remove(Serializable primaryKey)
		throws NoSuchProductSpecificationMappingException {

		Session session = null;

		try {
			session = openSession();

			ProductSpecificationMapping productSpecificationMapping =
				(ProductSpecificationMapping)session.get(
					ProductSpecificationMappingImpl.class, primaryKey);

			if (productSpecificationMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSpecificationMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productSpecificationMapping);
		}
		catch (NoSuchProductSpecificationMappingException
					noSuchEntityException) {

			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProductSpecificationMapping removeImpl(
		ProductSpecificationMapping productSpecificationMapping) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSpecificationMapping)) {
				productSpecificationMapping =
					(ProductSpecificationMapping)session.get(
						ProductSpecificationMappingImpl.class,
						productSpecificationMapping.getPrimaryKeyObj());
			}

			if (productSpecificationMapping != null) {
				session.delete(productSpecificationMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productSpecificationMapping != null) {
			clearCache(productSpecificationMapping);
		}

		return productSpecificationMapping;
	}

	@Override
	public ProductSpecificationMapping updateImpl(
		ProductSpecificationMapping productSpecificationMapping) {

		boolean isNew = productSpecificationMapping.isNew();

		if (!(productSpecificationMapping instanceof
				ProductSpecificationMappingModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					productSpecificationMapping.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					productSpecificationMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productSpecificationMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductSpecificationMapping implementation " +
					productSpecificationMapping.getClass());
		}

		ProductSpecificationMappingModelImpl
			productSpecificationMappingModelImpl =
				(ProductSpecificationMappingModelImpl)
					productSpecificationMapping;

		if (Validator.isNull(productSpecificationMapping.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			productSpecificationMapping.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (productSpecificationMapping.getCreateDate() == null)) {
			if (serviceContext == null) {
				productSpecificationMapping.setCreateDate(now);
			}
			else {
				productSpecificationMapping.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!productSpecificationMappingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productSpecificationMapping.setModifiedDate(now);
			}
			else {
				productSpecificationMapping.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productSpecificationMapping);
			}
			else {
				productSpecificationMapping =
					(ProductSpecificationMapping)session.merge(
						productSpecificationMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductSpecificationMappingImpl.class,
			productSpecificationMappingModelImpl, false, true);

		if (isNew) {
			productSpecificationMapping.setNew(false);
		}

		productSpecificationMapping.resetOriginalValues();

		return productSpecificationMapping;
	}

	/**
	 * Returns the product specification mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	@Override
	public ProductSpecificationMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSpecificationMappingException {

		ProductSpecificationMapping productSpecificationMapping =
			fetchByPrimaryKey(primaryKey);

		if (productSpecificationMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSpecificationMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productSpecificationMapping;
	}

	/**
	 * Returns the product specification mapping with the primary key or throws a <code>NoSuchProductSpecificationMappingException</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping
	 * @throws NoSuchProductSpecificationMappingException if a product specification mapping with the primary key could not be found
	 */
	@Override
	public ProductSpecificationMapping findByPrimaryKey(
			long productSpecificationMappingId)
		throws NoSuchProductSpecificationMappingException {

		return findByPrimaryKey((Serializable)productSpecificationMappingId);
	}

	/**
	 * Returns the product specification mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationMappingId the primary key of the product specification mapping
	 * @return the product specification mapping, or <code>null</code> if a product specification mapping with the primary key could not be found
	 */
	@Override
	public ProductSpecificationMapping fetchByPrimaryKey(
		long productSpecificationMappingId) {

		return fetchByPrimaryKey((Serializable)productSpecificationMappingId);
	}

	/**
	 * Returns all the product specification mappings.
	 *
	 * @return the product specification mappings
	 */
	@Override
	public List<ProductSpecificationMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProductSpecificationMapping> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ProductSpecificationMapping> findAll(
		int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ProductSpecificationMapping> findAll(
		int start, int end,
		OrderByComparator<ProductSpecificationMapping> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProductSpecificationMapping> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecificationMapping>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTSPECIFICATIONMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSPECIFICATIONMAPPING;

				sql = sql.concat(
					ProductSpecificationMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductSpecificationMapping>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the product specification mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductSpecificationMapping productSpecificationMapping :
				findAll()) {

			remove(productSpecificationMapping);
		}
	}

	/**
	 * Returns the number of product specification mappings.
	 *
	 * @return the number of product specification mappings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PRODUCTSPECIFICATIONMAPPING);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "productSpecificationMappingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTSPECIFICATIONMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductSpecificationMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product specification mapping persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ProductSpecificationMappingModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				ProductSpecificationMapping.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByProductType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productType"}, true);

		_finderPathWithoutPaginationFindByProductType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductType",
			new String[] {String.class.getName()}, new String[] {"productType"},
			true);

		_finderPathCountByProductType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductType",
			new String[] {String.class.getName()}, new String[] {"productType"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(
			ProductSpecificationMappingImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = PTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTSPECIFICATIONMAPPING =
		"SELECT productSpecificationMapping FROM ProductSpecificationMapping productSpecificationMapping";

	private static final String _SQL_SELECT_PRODUCTSPECIFICATIONMAPPING_WHERE =
		"SELECT productSpecificationMapping FROM ProductSpecificationMapping productSpecificationMapping WHERE ";

	private static final String _SQL_COUNT_PRODUCTSPECIFICATIONMAPPING =
		"SELECT COUNT(productSpecificationMapping) FROM ProductSpecificationMapping productSpecificationMapping";

	private static final String _SQL_COUNT_PRODUCTSPECIFICATIONMAPPING_WHERE =
		"SELECT COUNT(productSpecificationMapping) FROM ProductSpecificationMapping productSpecificationMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productSpecificationMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductSpecificationMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductSpecificationMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSpecificationMappingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ProductSpecificationMappingModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ProductSpecificationMappingModelImpl
				productSpecificationMappingModelImpl =
					(ProductSpecificationMappingModelImpl)baseModel;

			long columnBitmask =
				productSpecificationMappingModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					productSpecificationMappingModelImpl, columnNames,
					original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						productSpecificationMappingModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					productSpecificationMappingModelImpl, columnNames,
					original);
			}

			return null;
		}

		private Object[] _getValue(
			ProductSpecificationMappingModelImpl
				productSpecificationMappingModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						productSpecificationMappingModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						productSpecificationMappingModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}