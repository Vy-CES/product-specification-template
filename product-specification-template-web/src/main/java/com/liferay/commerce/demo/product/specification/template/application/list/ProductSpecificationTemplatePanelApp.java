package com.liferay.commerce.demo.product.specification.template.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.commerce.application.list.constants.CommercePanelCategoryKeys;
import com.liferay.commerce.demo.product.specification.template.constants.ProductSpecificationTemplatePortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Jeffrey Handa
 */
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=225",
                "panel.category.key=" + CommercePanelCategoryKeys.COMMERCE_PRODUCT_MANAGEMENT
        },
        service = PanelApp.class
)
public class ProductSpecificationTemplatePanelApp extends BasePanelApp {

        @Override
        public String getLabel(Locale locale) {

                ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                        "content.Language", locale, getClass());

                return LanguageUtil.get(resourceBundle, "product-templates");
        }

        @Override
        public String getPortletId() {
                return ProductSpecificationTemplatePortletKeys.PRODUCTSPECIFICATIONTEMPLATE;
        }

        @Override
        @Reference(
                target = "(javax.portlet.name=" + ProductSpecificationTemplatePortletKeys.PRODUCTSPECIFICATIONTEMPLATE + ")",
                unbind = "-"
        )
        public void setPortlet(Portlet portlet) {
                super.setPortlet(portlet);
        }
}
