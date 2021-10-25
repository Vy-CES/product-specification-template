create table PT_ProductSpecificationMapping (
	uuid_ VARCHAR(75) null,
	productSpecificationMappingId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productType VARCHAR(75) null,
	cpSpecificationOptionId LONG,
	cpOptionCategoryId LONG,
	priority DOUBLE,
	defaultValue VARCHAR(75) null
);