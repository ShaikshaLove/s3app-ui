package io.s3soft.proxyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.s3soft.proxyapp.locator.ProductRuleUtil;
import io.s3soft.proxyapp.model.Product;
import io.s3soft.proxyapp.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	
    @Autowired
    private ProductRuleUtil productRuleUtil;

	@Override
	public List<Product> getAllProducts() {
		return productRuleUtil.findAllProducts();
	}

}
