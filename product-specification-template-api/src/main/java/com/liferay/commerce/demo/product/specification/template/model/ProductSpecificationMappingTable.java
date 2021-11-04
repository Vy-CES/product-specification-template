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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;PT_ProductSpecificationMapping&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMapping
 * @generated
 */
public class ProductSpecificationMappingTable
	extends BaseTable<ProductSpecificationMappingTable> {

	public static final ProductSpecificationMappingTable INSTANCE =
		new ProductSpecificationMappingTable();

	public final Column<ProductSpecificationMappingTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Long>
		productSpecificationMappingId = createColumn(
			"productSpecificationMappingId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProductSpecificationMappingTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, String> productType =
		createColumn(
			"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Long>
		cpSpecificationOptionId = createColumn(
			"cpSpecificationOptionId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Long>
		cpOptionCategoryId = createColumn(
			"cpOptionCategoryId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, Double> priority =
		createColumn(
			"priority", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationMappingTable, String> defaultValue =
		createColumn(
			"defaultValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductSpecificationMappingTable() {
		super(
			"PT_ProductSpecificationMapping",
			ProductSpecificationMappingTable::new);
	}

}