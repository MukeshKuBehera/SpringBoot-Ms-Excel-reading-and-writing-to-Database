package com.test.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.Product;
import com.test.helper.Helper;
import com.test.service.ProductService;
@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file){
		
		System.out.println(">>>>>>>>>>"+file.getOriginalFilename());
		if(Helper.checkExcelFormat(file)) {
			//true
			this.productService.save(file);
			
			return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to database"));
			
		}//end if
		else {
		return ResponseEntity.badRequest().body("unable to upload Excel file");
		}
	}//end of fileUpload
	
	//get all products
	
	@GetMapping("/getProducts")
	public List<Product> getAllProducts(){
		
		return this.productService.getAllProducts();
	}
  	

	
}
