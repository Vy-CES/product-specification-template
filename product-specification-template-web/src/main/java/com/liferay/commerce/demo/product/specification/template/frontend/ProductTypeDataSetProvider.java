package com.liferay.commerce.demo.product.specification.template.frontend;

import com.liferay.commerce.demo.product.specification.template.frontend.constants.ProductTypeSpecificationMappingDataSetConstants;
import com.liferay.commerce.product.type.CPType;
import com.liferay.commerce.product.type.CPTypeServicesTracker;
import com.liferay.frontend.taglib.clay.data.Filter;
import com.liferay.frontend.taglib.clay.data.Pagination;
import com.liferay.frontend.taglib.clay.data.set.provider.ClayDataSetDataProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Component(
        immediate = true,
        property = "clay.data.provider.key=" + ProductTypeSpecificationMappingDataSetConstants.COMMERCE_DATA_SET_KEY_PRODUCT_TYPE,
        service = ClayDataSetDataProvider.class
)
public class ProductTypeDataSetProvider implements ClayDataSetDataProvider<CPType> {

    @Override
    public List<CPType> getItems(HttpServletRequest httpServletRequest, Filter filter, Pagination pagination, Sort sort) throws PortalException {

        List<CPType> cpTypes =  _cpTypeServicesTracker.getCPTypes();
        return cpTypes;
    }

    @Override
    public int getItemsCount(HttpServletRequest httpServletRequest, Filter filter) throws PortalException {

        List<CPType> cpTypes =  _cpTypeServicesTracker.getCPTypes();
        return cpTypes.size();
    }

    @Reference
    private CPTypeServicesTracker _cpTypeServicesTracker;

}
