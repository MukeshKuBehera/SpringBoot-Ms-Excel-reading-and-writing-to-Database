package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.Product;
import com.test.helper.Helper;
import com.test.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public void save(MultipartFile file) {
		try {
			
			List<Product> products=Helper.convertExcelToListOfProduct(file.getInputStream());
			
			this.repo.saveAll(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of save method
	
	public List<Product> getAllProducts(){
		
		
		
		return this.repo.findAll();
	}
}
