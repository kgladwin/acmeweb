package com.acmeweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acmeweb.models.Product;
import com.acmeweb.models.Products;
import com.acmeweb.models.Response;
import com.acmeweb.services.AcmeService;

@RestController
public class AcmeController {
	
	@Autowired
	private AcmeService acmeService;

	@CrossOrigin
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody Product product) {

		try {

			acmeService.create(product);
			
			Response response = new Response();
			response.setStatus("success");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<Response>(new Response("Exception adding details" + ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/list")
	ResponseEntity<List<Product>> list() {

		try {

			List<Product> products = acmeService.getList();
						
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<List<Product>>(null);
		}
	}
	
}
