package com.liferay.commerce.demo.product.specification.template.portlet;

import com.liferay.commerce.demo.product.specification.template.constants.ProductSpecificationTemplatePortletKeys;

import com.liferay.commerce.demo.product.specification.template.display.ProductTypeSpecificationDisplayContext;
import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.commerce.demo.product.specification.template.service.ProductSpecificationMappingLocalService;
import com.liferay.commerce.demo.product.specification.template.service.ProductSpecificationMappingService;
import com.liferay.commerce.product.model.CPSpecificationOption;
import com.liferay.commerce.product.service.CPSpecificationOptionLocalService;
import com.liferay.commerce.product.type.CPType;
import com.liferay.commerce.product.type.CPTypeServicesTracker;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeffrey Handa
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=ProductSpecificationTemplate",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProductSpecificationTemplatePortletKeys.PRODUCTSPECIFICATIONTEMPLATE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductSpecificationTemplatePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<CPType> cpTypes =  _cpTypeServicesTracker.getCPTypes();
		renderRequest.setAttribute("cpTypes", cpTypes);
		renderRequest.setAttribute("productSpecificationMappingLocalService", _productSpecificationMappingLocalService);
		renderRequest.setAttribute("cpSpecificationOptionLocalService", _cpSpecificationOptionLocalService);
		super.render(renderRequest, renderResponse);
	}


	@ProcessAction(name = "processForm")
	public void processForm(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductSpecificationMapping.class.getName(), request);

		String productType = ParamUtil.getString(request, "productType");

		List<ProductSpecificationMapping> oldProductSpecificationMappings = _productSpecificationMappingLocalService.getProductSpecificationMappings(productType);

		for(ProductSpecificationMapping productSpecificationMapping:oldProductSpecificationMappings){
			_productSpecificationMappingLocalService.deleteProductSpecificationMapping(productSpecificationMapping.getProductSpecificationMappingId());
		}

		int numRows = ParamUtil.getInteger(request, "numRows");
		for (int i = 0; i < numRows; i++){
			long cpSpecificationOptionId = ParamUtil.getLong(request, "cpSpecificationOptionId_" + i);
			CPSpecificationOption cpSpecificationOption = _cpSpecificationOptionLocalService.getCPSpecificationOption(cpSpecificationOptionId);
			long cpOptionCategoryId = cpSpecificationOption.getCPOptionCategory().getCPOptionCategoryId();
			double priority = ParamUtil.getDouble(request, "priority_" + i);
			Map<Locale, String> defaultValueMap = LocalizationUtil.getLocalizationMap(request, "defaultValue_" + i);

			_productSpecificationMappingLocalService.addProductSpecificationMapping(serviceContext.getUserId(),
					serviceContext.getCompanyId(), productType, cpSpecificationOptionId, cpOptionCategoryId,
					priority, defaultValueMap, serviceContext);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
			ProductSpecificationTemplatePortlet.class);

	@Reference
	private CPTypeServicesTracker _cpTypeServicesTracker;

	@Reference
	private ProductSpecificationMappingLocalService _productSpecificationMappingLocalService;

	@Reference
	private CPSpecificationOptionLocalService _cpSpecificationOptionLocalService;


}