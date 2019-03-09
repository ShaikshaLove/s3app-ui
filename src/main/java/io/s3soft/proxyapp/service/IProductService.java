package io.s3soft.proxyapp.service;

import java.util.List;

import io.s3soft.proxyapp.model.Product;

/**
 * @author shaiksha
 *
 */
public interface IProductService {

	public List<Product> getAllProducts();
}
