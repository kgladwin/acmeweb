package com.acmeweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.acmeweb.models.Product;
import com.acmeweb.models.Products;

@Component
public class AcmeDAOImpl implements AcmeDAO {
	
	private List<Product> savedProducts = null;
	
	public void create(Product request) throws Exception {
		if(request != null) {
			List<Product> tempProducts = cache();
			
			boolean exists = false;
			
			for(Product product : tempProducts) {
				if(product.getCustomerId().equals(request.getCustomerId())) {
					exists = true;
					break;
				}
			}
			
			if(!exists) {
				tempProducts.add(request);
			}
			
			// put it back in cache
			evictCache();
			
			savedProducts = tempProducts;
			
			cache();
		}
	}
	
	public List<Product> getList() throws Exception {
		
		return savedProducts;
		
	}
	
	@Cacheable("listOfProducts")
	public List<Product> cache() throws Exception {
		if(savedProducts == null) {
			savedProducts = new ArrayList<Product>();
		}
		
		return savedProducts;
	}
	
	@CacheEvict(value = { "listOfProducts"}, allEntries = true)
	public void evictCache() {
	}
}
