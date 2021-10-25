<%@ include file="./init.jsp" %>

<%
    List<CPType> cpTypes = (List<CPType>) request.getAttribute("cpTypes");
    ProductSpecificationMappingLocalService productSpecificationMappingLocalService =
            (ProductSpecificationMappingLocalService)request.getAttribute("productSpecificationMappingLocalService");
%>

<div class="container-fluid-1280 mt-4 sheet">
    <div class="data-set-display data-set-display-stacked">
        <div class="data-set-display-content-wrapper">
            <div class="table-style-stacked">
                <div class="table-responsive">
                    <table class="table table-autofit">
                    <thead>
                        <tr>
                            <th class="table-cell-expand-smaller">
                                <p class="table-list-title">Product Type</p>
                            </th>
                            <th class="table-cell-expand-smaller">
                                <p class="table-list-title">Mapped Specifications</p>
                            </th>
                            <th class="table-cell-expand-smaller">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="<%= cpTypes %>" var="cpType">
                        <portlet:renderURL var="editMappingURL">
                            <portlet:param name="productTypeName"
                                           value="${cpType.getName()}" />
                            <portlet:param name="productTypeLabel"
                                           value="${cpType.getLabel(locale)}" />
                            <portlet:param name="mvcPath" value="/edit_entry.jsp" />
                        </portlet:renderURL>
                        <tr>
                            <td>${cpType.getLabel(locale)}</td>
                            <td>${Integer.toString(productSpecificationMappingLocalService.getProductSpecificationMappingsCount(cpType.getName()))}</td>
                            <td><a class="btn btn-secondary btn-sm float-right" href="<%= editMappingURL.toString()%>">View</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </div>
            </div>
        </div>
    </div>
</div>