package com.liferay.commerce.demo.product.specification.template.display;

import com.liferay.commerce.product.display.context.util.CPRequestHelper;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class ProductTypeSpecificationDisplayContext {

    public ProductTypeSpecificationDisplayContext(HttpServletRequest httpServletRequest) {

        cpRequestHelper = new CPRequestHelper(httpServletRequest);

    }

    public CreationMenu getCreationMenu() throws Exception {
        CreationMenu creationMenu = new CreationMenu();

//        creationMenu.addDropdownItem(
//                    dropdownItem -> {
//                        dropdownItem.setHref(getAddCommerceCatalogRenderURL());
//                        dropdownItem.setLabel(
//                                LanguageUtil.get(
//                                        cpRequestHelper.getRequest(), "add-catalog"));
//                        dropdownItem.setTarget("modal-lg");
//                    });


        return creationMenu;
    }

    public PortletURL getPortletURL() {
        LiferayPortletResponse liferayPortletResponse =
                cpRequestHelper.getLiferayPortletResponse();

        PortletURL portletURL = liferayPortletResponse.createRenderURL();

        String redirect = ParamUtil.getString(
                cpRequestHelper.getRequest(), "redirect");

        if (Validator.isNotNull(redirect)) {
            portletURL.setParameter("redirect", redirect);
        }

        String filterFields = ParamUtil.getString(
                cpRequestHelper.getRequest(), "filterFields");

        if (Validator.isNotNull(filterFields)) {
            portletURL.setParameter("filterFields", filterFields);
        }

        String filtersLabels = ParamUtil.getString(
                cpRequestHelper.getRequest(), "filtersLabels");

        if (Validator.isNotNull(filtersLabels)) {
            portletURL.setParameter("filtersLabels", filtersLabels);
        }

        String filtersValues = ParamUtil.getString(
                cpRequestHelper.getRequest(), "filtersValues");

        if (Validator.isNotNull(filtersValues)) {
            portletURL.setParameter("filtersValues", filtersValues);
        }

        return portletURL;
    }

    protected final CPRequestHelper cpRequestHelper;

}
