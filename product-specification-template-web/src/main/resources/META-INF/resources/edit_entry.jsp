<%@ taglib prefix="portal" uri="http://java.sun.com/portlet" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ include file="./init.jsp" %>

<%
    String productTypeName = ParamUtil.getString(request, "productTypeName");
    String productTypeLabel = ParamUtil.getString(request, "productTypeLabel");

    CPSpecificationOptionLocalService cpSpecificationOptionLocalService =
            (CPSpecificationOptionLocalService)request.getAttribute("cpSpecificationOptionLocalService");

    ProductSpecificationMappingLocalService productSpecificationMappingLocalService =
            (ProductSpecificationMappingLocalService)request.getAttribute("productSpecificationMappingLocalService");

    List<ProductSpecificationMapping> productSpecificationMappings =
            productSpecificationMappingLocalService.getProductSpecificationMappings(productTypeName);

    int currentNumOfMappings = productSpecificationMappings.size();


    List<CPSpecificationOption> cpSpecificationOptions =
            cpSpecificationOptionLocalService.getCPSpecificationOptions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<portal:renderURL var="backUrl" />
<portlet:actionURL name="processForm" var="processFormUrl" />
<aui:form action="<%= processFormUrl %>" method="post" name="fm" class="needs-validation">

    <%--    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (commerceAddress == null) ? Constants.ADD : Constants.UPDATE %>" />--%>
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <aui:input name="backURL" type="hidden" value="<%= backUrl %>" />
    <aui:input name="numRows" type="hidden" value="<%= currentNumOfMappings > 0 ? currentNumOfMappings : 1%>" />
    <aui:input name="productType" type="hidden" value="<%= productTypeName %>"/>

    <div class="container-fluid-1280 mt-4 sheet">
        <div class="container">
            <div class="row">
                <div class="col-md-12 order-md-1">
                    <h4 class="mb-3">
                        <liferay-ui:message key="x-product-type-mapping" arguments="<%= productTypeLabel %>" />
                    </h4>
                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <p class="table-list-title"><liferay-ui:message key="specification" /></p>
                        </div>
                        <div class="col-md-2 mb-3">
                            <p class="table-list-title"><liferay-ui:message key="priority" /></p>
                        </div>
                        <div class="col-md-5 mb-3">
                            <p class="table-list-title"><liferay-ui:message key="default-value" /></p>
                        </div>
                    </div>
                    <div id="specRows">
                        <c:choose>
                            <c:when test = "<%= currentNumOfMappings > 0%>">
                                <c:forEach var="productSpecificationMapping" items="<%= productSpecificationMappings%>" varStatus="mapStatus">
                                    <c:set var="counter" value="0"/>
                                    <div class="row" id="${mapStatus.index}">
                                        <div class="col-md-5 mb-3">
                                            <aui:select label="" name="cpSpecificationOptionId_${mapStatus.index}" showEmptyOption="<%= true %>">
                                                <option value="" disabled selected><liferay-ui:message key="select-a-specification" /></option>
                                                <c:forEach items="<%= cpSpecificationOptions %>" var="cpSpecificationOption" >
                                                    <c:set var="isSelected" value="${cpSpecificationOption.getCPSpecificationOptionId() == productSpecificationMapping.getCpSpecificationOptionId()}" />
                                                    <aui:option label="${cpSpecificationOption.getTitle(locale)}"
                                                                selected="${isSelected}"
                                                                value="${cpSpecificationOption.getCPSpecificationOptionId()}" />
                                                </c:forEach>
                                            </aui:select>
                                        </div>
                                        <div class="col-md-2 mb-3">
                                            <aui:input label="" name="priority_${mapStatus.index}" placeholder="priority"
                                                       type="text" value ="${productSpecificationMapping.priority}" />
                                        </div>
                                        <div class="col-md-4 mb-3">
                                            <aui:input label="" name="defaultValue_${mapStatus.index}"
                                                       placeholder="default-value" type="text"
                                                       value="${productSpecificationMapping.defaultValue}" />
                                        </div>
                                        <div class="col-md-1 mb-3">
                                            <button class="btn btn-monospaced btn-secondary" onclick="delIt(${mapStatus.index})">-</button>
                                        </div>
                                    </div>
                                    <c:set var="counter" value="${counter + 1}"/>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="row" id="<%= currentNumOfMappings%>">
                                    <div class="col-md-5 mb-3">
                                        <aui:select label="" name="<%="cpSpecificationOptionId_" + currentNumOfMappings%>" showEmptyOption="<%= true %>">
                                            <option value="" disabled selected><liferay-ui:message key="select-a-specification" /></option>
                                            <c:forEach items="<%= cpSpecificationOptions %>" var="cpSpecificationOption" >
                                                <aui:option label="${cpSpecificationOption.getTitle(locale)}" selected="false" value="${cpSpecificationOption.getCPSpecificationOptionId()}" />
                                            </c:forEach>
                                        </aui:select>
                                    </div>
                                    <div class="col-md-2 mb-3">
                                        <aui:input label="" name="<%="priority_" + currentNumOfMappings%>" placeholder="priority" type="text" />
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <aui:input label="" name="<%="defaultValue_" + currentNumOfMappings%>"
                                                   placeholder="default-value" type="text" />
                                    </div>
                                    <div class="col-md-1 mb-3">
                                        <button class="btn btn-monospaced btn-secondary" onclick="delIt(<%=currentNumOfMappings%>)">-</button>
                                    </div>
                                </div>
                                <%
                                    currentNumOfMappings = 1;
                                %>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="form-group-autofit">
                        <a href="javascript:;" onclick="new_row();return false;" disabled="true">
                            <liferay-ui:message key="add-another-mapping" />
                        </a>
                    </div>

                    <aui:fieldset>
                        <aui:button-row>
                            <aui:button cssClass="btn-lg" type="submit" value="save" />

                            <aui:button cssClass="btn-lg" href="<%= backUrl %>" type="cancel" />
                        </aui:button-row>
                    </aui:fieldset>
                </div>
            </div>
        </div>
    </div>
</aui:form>



<script>
    var counter = <%= currentNumOfMappings %>;

    function new_row()
    {

        var newRow = document.createElement('div');
        newRow.id = counter;
        newRow.className = 'row';

        var rowContents = '<div class="col-md-5 mb-3">';
        rowContents += '<select class="custom-select d-block w-100" name="<portal:namespace/>cpSpecificationOptionId_' + counter + '" required>';
        rowContents += '<option value="" disabled selected><liferay-ui:message key="select-a-specification" /></option>';
        <c:forEach items="<%= cpSpecificationOptions %>" var="cpSpecificationOption" >
        rowContents += '<option value="${cpSpecificationOption.getCPSpecificationOptionId()}">${cpSpecificationOption.getTitle(locale)} </option>'
        </c:forEach>
        rowContents += '</select>';

        rowContents += '</div>';
        rowContents += '<div class="col-md-2 mb-3">';
        rowContents += `<aui:input label="" name="<%="priority_" + currentNumOfMappings%>" placeholder="priority" type="text" />`;
        rowContents += '</div>';
        rowContents += '<div class="col-md-4 mb-3">';
        rowContents += `<aui:input label="" name="<%="defaultValue_" + currentNumOfMappings%>" placeholder="default-value"  type="text" />`;
        rowContents += '</div>';
        rowContents += '<div class="col-md-1 mb-3">';
        rowContents += '<button class="btn btn-monospaced btn-secondary h-100" onclick="delIt('+ counter +')">-</button>';
        rowContents += '</div>';
        newRow.innerHTML = rowContents;

        document.getElementById('specRows').appendChild(newRow);
        counter++;
        document.getElementById('<portlet:namespace/>numRows').value = counter;
    }
    // function to delete the newly added set of elements
    function delIt(eleId)
    {
        d = document;
        var ele = d.getElementById(eleId);
        var parentEle = d.getElementById('specRows');
        parentEle.removeChild(ele);
    }
</script>