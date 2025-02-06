package com.PizzaHut.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.ToppingImageDao;
import com.PizzaHut.entities.ToppingImage;
import com.app.custom_exceptions.ResourceNotFoundException;


@Service
@Transactional
public class ImageHandlerService {

	@Value("${pizza.upload.folder}")
	private String pizzaImageFolder;
	@Value("${topping.upload.folder}")
	private String toppingImageFolder;
	
	
	@Autowired
	private ToppingImageDao toppingImgDao;
	

	
	public byte[] getToppingImage(int toppingId) throws IOException {
		ToppingImage toppingimg = toppingImgDao.findById(toppingId)
				.orElseThrow(() -> new ResourceNotFoundException("InValid topping Id !!!!!"));
		String path = toppingimg.getData();
		if (path == null) {
			throw new ResourceNotFoundException("Image does Not Exists !!!!");
		}
		return Files.readAllBytes(Paths.get(path));
	}

}
