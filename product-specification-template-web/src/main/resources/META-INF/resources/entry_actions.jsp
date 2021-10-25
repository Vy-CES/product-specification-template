<%@ include file="./init.jsp" %>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    CPType entry = (CPType)row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editMappingURL">
        <portlet:param name="productTypeName"
                       value="<%= String.valueOf(entry.getName()) %>" />
        <portlet:param name="productTypeLabel"
                       value="<%= String.valueOf(entry.getLabel(locale)) %>" />
        <portlet:param name="mvcPath" value="/edit_entry.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editMappingURL.toString() %>" />

    <portlet:actionURL name="deleteMapping" var="deleteMappingUrl">
        <portlet:param name="entryId"
                       value="<%= String.valueOf(entry.getName()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteMappingUrl.toString() %>" />

</liferay-ui:icon-menu>