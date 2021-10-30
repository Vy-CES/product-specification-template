package com.liferay.commerce.demo.product.specification.template.listener;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.commerce.demo.product.specification.template.service.ProductSpecificationMappingLocalService;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionSpecificationOptionValueLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeff Handa
 */
@Component(
        immediate = true,
        service = ModelListener.class
)
public class ProductSpecificationTemplateCPDefinitionListener extends BaseModelListener<CPDefinition> {

    @Override
    public void onAfterCreate(CPDefinition cpDefinition) throws ModelListenerException {
        _log.debug("Creating CPDefinition: " + cpDefinition.getName() + " -- " + cpDefinition.getCPDefinitionId()
                +"with " + cpDefinition.getProductTypeName() + " product type");

        String productType = cpDefinition.getProductTypeName();

        List<ProductSpecificationMapping> productSpecificationMappingList =
                _productSpecificationMappingLocalService.getProductSpecificationMappings(productType);

        if (productSpecificationMappingList.size() > 0){
            _companyId = cpDefinition.getCompanyId();
            _groupId = cpDefinition.getGroupId();
            _userId = cpDefinition.getUserId();
            _cpDefinitionId = cpDefinition.getCPDefinitionId();

            for (ProductSpecificationMapping productSpecificationMapping : productSpecificationMappingList) {
                try {
                    addSpecifications(productSpecificationMapping);

                } catch (PortalException e) {
                    _log.error(e.getMessage());
                }
            }
            _log.debug("Processing " + productSpecificationMappingList.size() + " mapping(s)." );
        }
        super.onAfterCreate(cpDefinition);
    }

    private static final Log _log = LogFactoryUtil.getLog(
            ProductSpecificationTemplateCPDefinitionListener.class);

    private void addSpecifications(ProductSpecificationMapping productSpecificationMapping) throws PortalException {


        long cpSpecificationOptionId = productSpecificationMapping.getCpSpecificationOptionId();
        double priority = productSpecificationMapping.getPriority();
        long cpOptionCategoryId = productSpecificationMapping.getCpOptionCategoryId();
        Map<Locale, String> valueMap = productSpecificationMapping.getDefaultValueMap();
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(_companyId);
        serviceContext.setScopeGroupId(_groupId);
        serviceContext.setUserId(_userId);

        _cpDefinitionSpecificationOptionValueLocalService.addCPDefinitionSpecificationOptionValue(_cpDefinitionId,
                cpSpecificationOptionId, cpOptionCategoryId,valueMap, priority, serviceContext);

    }

    private long _companyId;
    private long _groupId;
    private long _userId;
    private long _cpDefinitionId;

    @Reference
    private CPDefinitionSpecificationOptionValueLocalService _cpDefinitionSpecificationOptionValueLocalService;

    @Reference
    private ProductSpecificationMappingLocalService _productSpecificationMappingLocalService;

}
