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

package com.liferay.commerce.demo.product.specification.template.model.impl;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductSpecificationMapping in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSpecificationMappingCacheModel
	implements CacheModel<ProductSpecificationMapping>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSpecificationMappingCacheModel)) {
			return false;
		}

		ProductSpecificationMappingCacheModel
			productSpecificationMappingCacheModel =
				(ProductSpecificationMappingCacheModel)object;

		if (productSpecificationMappingId ==
				productSpecificationMappingCacheModel.
					productSpecificationMappingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productSpecificationMappingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productSpecificationMappingId=");
		sb.append(productSpecificationMappingId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", productType=");
		sb.append(productType);
		sb.append(", cpSpecificationOptionId=");
		sb.append(cpSpecificationOptionId);
		sb.append(", cpOptionCategoryId=");
		sb.append(cpOptionCategoryId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductSpecificationMapping toEntityModel() {
		ProductSpecificationMappingImpl productSpecificationMappingImpl =
			new ProductSpecificationMappingImpl();

		if (uuid == null) {
			productSpecificationMappingImpl.setUuid("");
		}
		else {
			productSpecificationMappingImpl.setUuid(uuid);
		}

		productSpecificationMappingImpl.setProductSpecificationMappingId(
			productSpecificationMappingId);
		productSpecificationMappingImpl.setCompanyId(companyId);
		productSpecificationMappingImpl.setUserId(userId);

		if (userName == null) {
			productSpecificationMappingImpl.setUserName("");
		}
		else {
			productSpecificationMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productSpecificationMappingImpl.setCreateDate(null);
		}
		else {
			productSpecificationMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productSpecificationMappingImpl.setModifiedDate(null);
		}
		else {
			productSpecificationMappingImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (productType == null) {
			productSpecificationMappingImpl.setProductType("");
		}
		else {
			productSpecificationMappingImpl.setProductType(productType);
		}

		productSpecificationMappingImpl.setCpSpecificationOptionId(
			cpSpecificationOptionId);
		productSpecificationMappingImpl.setCpOptionCategoryId(
			cpOptionCategoryId);
		productSpecificationMappingImpl.setPriority(priority);

		if (defaultValue == null) {
			productSpecificationMappingImpl.setDefaultValue("");
		}
		else {
			productSpecificationMappingImpl.setDefaultValue(defaultValue);
		}

		productSpecificationMappingImpl.resetOriginalValues();

		return productSpecificationMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productSpecificationMappingId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		productType = objectInput.readUTF();

		cpSpecificationOptionId = objectInput.readLong();

		cpOptionCategoryId = objectInput.readLong();

		priority = objectInput.readDouble();
		defaultValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productSpecificationMappingId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}

		objectOutput.writeLong(cpSpecificationOptionId);

		objectOutput.writeLong(cpOptionCategoryId);

		objectOutput.writeDouble(priority);

		if (defaultValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultValue);
		}
	}

	public String uuid;
	public long productSpecificationMappingId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String productType;
	public long cpSpecificationOptionId;
	public long cpOptionCategoryId;
	public double priority;
	public String defaultValue;

}