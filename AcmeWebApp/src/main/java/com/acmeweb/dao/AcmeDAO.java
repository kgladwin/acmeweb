package com.acmeweb.dao;

import java.util.List;

import com.acmeweb.models.Product;
import com.acmeweb.models.Products;

public interface AcmeDAO {
	public void create(Product request) throws Exception;

	public List<Product> getList() throws Exception;
	
}
