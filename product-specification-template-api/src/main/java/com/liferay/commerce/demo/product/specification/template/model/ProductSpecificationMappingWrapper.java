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

package com.liferay.commerce.demo.product.specification.template.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductSpecificationMapping}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMapping
 * @generated
 */
public class ProductSpecificationMappingWrapper
	extends BaseModelWrapper<ProductSpecificationMapping>
	implements ModelWrapper<ProductSpecificationMapping>,
			   ProductSpecificationMapping {

	public ProductSpecificationMappingWrapper(
		ProductSpecificationMapping productSpecificationMapping) {

		super(productSpecificationMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"productSpecificationMappingId",
			getProductSpecificationMappingId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productType", getProductType());
		attributes.put("cpSpecificationOptionId", getCpSpecificationOptionId());
		attributes.put("cpOptionCategoryId", getCpOptionCategoryId());
		attributes.put("priority", getPriority());
		attributes.put("defaultValue", getDefaultValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productSpecificationMappingId = (Long)attributes.get(
			"productSpecificationMappingId");

		if (productSpecificationMappingId != null) {
			setProductSpecificationMappingId(productSpecificationMappingId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}

		Long cpSpecificationOptionId = (Long)attributes.get(
			"cpSpecificationOptionId");

		if (cpSpecificationOptionId != null) {
			setCpSpecificationOptionId(cpSpecificationOptionId);
		}

		Long cpOptionCategoryId = (Long)attributes.get("cpOptionCategoryId");

		if (cpOptionCategoryId != null) {
			setCpOptionCategoryId(cpOptionCategoryId);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this product specification mapping.
	 *
	 * @return the company ID of this product specification mapping
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cp option category ID of this product specification mapping.
	 *
	 * @return the cp option category ID of this product specification mapping
	 */
	@Override
	public long getCpOptionCategoryId() {
		return model.getCpOptionCategoryId();
	}

	/**
	 * Returns the cp specification option ID of this product specification mapping.
	 *
	 * @return the cp specification option ID of this product specification mapping
	 */
	@Override
	public long getCpSpecificationOptionId() {
		return model.getCpSpecificationOptionId();
	}

	/**
	 * Returns the create date of this product specification mapping.
	 *
	 * @return the create date of this product specification mapping
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the default value of this product specification mapping.
	 *
	 * @return the default value of this product specification mapping
	 */
	@Override
	public String getDefaultValue() {
		return model.getDefaultValue();
	}

	/**
	 * Returns the localized default value of this product specification mapping in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized default value of this product specification mapping
	 */
	@Override
	public String getDefaultValue(java.util.Locale locale) {
		return model.getDefaultValue(locale);
	}

	/**
	 * Returns the localized default value of this product specification mapping in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default value of this product specification mapping. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDefaultValue(java.util.Locale locale, boolean useDefault) {
		return model.getDefaultValue(locale, useDefault);
	}

	/**
	 * Returns the localized default value of this product specification mapping in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized default value of this product specification mapping
	 */
	@Override
	public String getDefaultValue(String languageId) {
		return model.getDefaultValue(languageId);
	}

	/**
	 * Returns the localized default value of this product specification mapping in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default value of this product specification mapping
	 */
	@Override
	public String getDefaultValue(String languageId, boolean useDefault) {
		return model.getDefaultValue(languageId, useDefault);
	}

	@Override
	public String getDefaultValueCurrentLanguageId() {
		return model.getDefaultValueCurrentLanguageId();
	}

	@Override
	public String getDefaultValueCurrentValue() {
		return model.getDefaultValueCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized default values of this product specification mapping.
	 *
	 * @return the locales and localized default values of this product specification mapping
	 */
	@Override
	public Map<java.util.Locale, String> getDefaultValueMap() {
		return model.getDefaultValueMap();
	}

	/**
	 * Returns the modified date of this product specification mapping.
	 *
	 * @return the modified date of this product specification mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product specification mapping.
	 *
	 * @return the primary key of this product specification mapping
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this product specification mapping.
	 *
	 * @return the priority of this product specification mapping
	 */
	@Override
	public double getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the product specification mapping ID of this product specification mapping.
	 *
	 * @return the product specification mapping ID of this product specification mapping
	 */
	@Override
	public long getProductSpecificationMappingId() {
		return model.getProductSpecificationMappingId();
	}

	/**
	 * Returns the product type of this product specification mapping.
	 *
	 * @return the product type of this product specification mapping
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the user ID of this product specification mapping.
	 *
	 * @return the user ID of this product specification mapping
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product specification mapping.
	 *
	 * @return the user name of this product specification mapping
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product specification mapping.
	 *
	 * @return the user uuid of this product specification mapping
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product specification mapping.
	 *
	 * @return the uuid of this product specification mapping
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this product specification mapping.
	 *
	 * @param companyId the company ID of this product specification mapping
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cp option category ID of this product specification mapping.
	 *
	 * @param cpOptionCategoryId the cp option category ID of this product specification mapping
	 */
	@Override
	public void setCpOptionCategoryId(long cpOptionCategoryId) {
		model.setCpOptionCategoryId(cpOptionCategoryId);
	}

	/**
	 * Sets the cp specification option ID of this product specification mapping.
	 *
	 * @param cpSpecificationOptionId the cp specification option ID of this product specification mapping
	 */
	@Override
	public void setCpSpecificationOptionId(long cpSpecificationOptionId) {
		model.setCpSpecificationOptionId(cpSpecificationOptionId);
	}

	/**
	 * Sets the create date of this product specification mapping.
	 *
	 * @param createDate the create date of this product specification mapping
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default value of this product specification mapping.
	 *
	 * @param defaultValue the default value of this product specification mapping
	 */
	@Override
	public void setDefaultValue(String defaultValue) {
		model.setDefaultValue(defaultValue);
	}

	/**
	 * Sets the localized default value of this product specification mapping in the language.
	 *
	 * @param defaultValue the localized default value of this product specification mapping
	 * @param locale the locale of the language
	 */
	@Override
	public void setDefaultValue(String defaultValue, java.util.Locale locale) {
		model.setDefaultValue(defaultValue, locale);
	}

	/**
	 * Sets the localized default value of this product specification mapping in the language, and sets the default locale.
	 *
	 * @param defaultValue the localized default value of this product specification mapping
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefaultValue(
		String defaultValue, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDefaultValue(defaultValue, locale, defaultLocale);
	}

	@Override
	public void setDefaultValueCurrentLanguageId(String languageId) {
		model.setDefaultValueCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized default values of this product specification mapping from the map of locales and localized default values.
	 *
	 * @param defaultValueMap the locales and localized default values of this product specification mapping
	 */
	@Override
	public void setDefaultValueMap(
		Map<java.util.Locale, String> defaultValueMap) {

		model.setDefaultValueMap(defaultValueMap);
	}

	/**
	 * Sets the localized default values of this product specification mapping from the map of locales and localized default values, and sets the default locale.
	 *
	 * @param defaultValueMap the locales and localized default values of this product specification mapping
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefaultValueMap(
		Map<java.util.Locale, String> defaultValueMap,
		java.util.Locale defaultLocale) {

		model.setDefaultValueMap(defaultValueMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this product specification mapping.
	 *
	 * @param modifiedDate the modified date of this product specification mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product specification mapping.
	 *
	 * @param primaryKey the primary key of this product specification mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this product specification mapping.
	 *
	 * @param priority the priority of this product specification mapping
	 */
	@Override
	public void setPriority(double priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the product specification mapping ID of this product specification mapping.
	 *
	 * @param productSpecificationMappingId the product specification mapping ID of this product specification mapping
	 */
	@Override
	public void setProductSpecificationMappingId(
		long productSpecificationMappingId) {

		model.setProductSpecificationMappingId(productSpecificationMappingId);
	}

	/**
	 * Sets the product type of this product specification mapping.
	 *
	 * @param productType the product type of this product specification mapping
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the user ID of this product specification mapping.
	 *
	 * @param userId the user ID of this product specification mapping
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product specification mapping.
	 *
	 * @param userName the user name of this product specification mapping
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product specification mapping.
	 *
	 * @param userUuid the user uuid of this product specification mapping
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product specification mapping.
	 *
	 * @param uuid the uuid of this product specification mapping
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProductSpecificationMappingWrapper wrap(
		ProductSpecificationMapping productSpecificationMapping) {

		return new ProductSpecificationMappingWrapper(
			productSpecificationMapping);
	}

}