<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/commerce-ui" prefix="commerce-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.commerce.product.model.CPSpecificationOption" %>
<%@ page import="com.liferay.commerce.product.service.CPSpecificationOptionLocalService" %>
<%@ page import="com.liferay.commerce.product.type.CPType" %>

<%@ page import="com.liferay.taglib.search.ResultRow" %>

<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>


<%@ page import="com.liferay.commerce.demo.product.specification.template.service.ProductSpecificationMappingLocalService" %>
<%@ page import="com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping" %>

<%@ page import="java.util.List" %>

<liferay-frontend:defineObjects />
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
    String redirect = ParamUtil.getString(request, "redirect");

//    String backURL = ParamUtil.getString(request, "backURL", redirect);
%>