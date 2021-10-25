<%@ include file="./init.jsp" %>

<%
    List<CPType> cpTypes = (List<CPType>) request.getAttribute("cpTypes");
    ProductSpecificationMappingLocalService productSpecificationMappingLocalService =
            (ProductSpecificationMappingLocalService)request.getAttribute("productSpecificationMappingLocalService");
%>

<h1>Product Type Mapping</h1>

<liferay-ui:search-container total="<%=cpTypes.size()%>">
    <liferay-ui:search-container-results
            results="<%= cpTypes%>" />

    <liferay-ui:search-container-row className="com.liferay.commerce.product.type.CPType" modelVar="entry">

        <liferay-ui:search-container-column-text name="name" value="${entry.getLabel(locale)}" />

        <liferay-ui:search-container-column-text name="mappings"
                 value="<%=Integer.toString(productSpecificationMappingLocalService.getProductSpecificationMappingsCount(entry.getName()))%>" />

                <liferay-ui:search-container-column-jsp
                align="right"
                path="/entry_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

