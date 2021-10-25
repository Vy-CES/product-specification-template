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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.commerce.demo.product.specification.template.service.http.ProductSpecificationMappingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProductSpecificationMappingSoap implements Serializable {

	public static ProductSpecificationMappingSoap toSoapModel(
		ProductSpecificationMapping model) {

		ProductSpecificationMappingSoap soapModel =
			new ProductSpecificationMappingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProductSpecificationMappingId(
			model.getProductSpecificationMappingId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProductType(model.getProductType());
		soapModel.setCpSpecificationOptionId(
			model.getCpSpecificationOptionId());
		soapModel.setCpOptionCategoryId(model.getCpOptionCategoryId());
		soapModel.setPriority(model.getPriority());
		soapModel.setDefaultValue(model.getDefaultValue());

		return soapModel;
	}

	public static ProductSpecificationMappingSoap[] toSoapModels(
		ProductSpecificationMapping[] models) {

		ProductSpecificationMappingSoap[] soapModels =
			new ProductSpecificationMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSpecificationMappingSoap[][] toSoapModels(
		ProductSpecificationMapping[][] models) {

		ProductSpecificationMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSpecificationMappingSoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSpecificationMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSpecificationMappingSoap[] toSoapModels(
		List<ProductSpecificationMapping> models) {

		List<ProductSpecificationMappingSoap> soapModels =
			new ArrayList<ProductSpecificationMappingSoap>(models.size());

		for (ProductSpecificationMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProductSpecificationMappingSoap[soapModels.size()]);
	}

	public ProductSpecificationMappingSoap() {
	}

	public long getPrimaryKey() {
		return _productSpecificationMappingId;
	}

	public void setPrimaryKey(long pk) {
		setProductSpecificationMappingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProductSpecificationMappingId() {
		return _productSpecificationMappingId;
	}

	public void setProductSpecificationMappingId(
		long productSpecificationMappingId) {

		_productSpecificationMappingId = productSpecificationMappingId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getProductType() {
		return _productType;
	}

	public void setProductType(String productType) {
		_productType = productType;
	}

	public long getCpSpecificationOptionId() {
		return _cpSpecificationOptionId;
	}

	public void setCpSpecificationOptionId(long cpSpecificationOptionId) {
		_cpSpecificationOptionId = cpSpecificationOptionId;
	}

	public long getCpOptionCategoryId() {
		return _cpOptionCategoryId;
	}

	public void setCpOptionCategoryId(long cpOptionCategoryId) {
		_cpOptionCategoryId = cpOptionCategoryId;
	}

	public double getPriority() {
		return _priority;
	}

	public void setPriority(double priority) {
		_priority = priority;
	}

	public String getDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	private String _uuid;
	private long _productSpecificationMappingId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _productType;
	private long _cpSpecificationOptionId;
	private long _cpOptionCategoryId;
	private double _priority;
	private String _defaultValue;

}