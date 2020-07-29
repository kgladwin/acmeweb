package com.acmeweb.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeweb.dao.AcmeDAO;
import com.acmeweb.models.Product;
import com.acmeweb.models.Products;

@Service
public class AcmeService {

	@Autowired
	private AcmeDAO acmeDAO;

	public void create(Product request) throws Exception {

		try {

			acmeDAO.create(request);

		} catch (Exception ex) {
			throw ex;
		}

	}

	public List<Product> getList() throws Exception {

		try {
			
			List<Product> products = acmeDAO.getList();
			
			if(products != null) {
				Collections.sort(products, new ScheduleComparator());
			}
			
			return products;
			
		} catch (Exception ex) {
			throw ex;
		}

		
	}
	
	private class ScheduleComparator implements Comparator<Product> {

	    public int compare(Product o1, Product o2) {
	        return o1.getStartDateAsDate().compareTo(o2.getStartDateAsDate());
	    }

	}

}
