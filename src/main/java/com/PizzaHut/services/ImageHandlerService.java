package com.PizzaHut.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.PizzaHut.daos.ItemImageDao;
import com.PizzaHut.daos.ToppingDao;
import com.PizzaHut.daos.ToppingImageDao;
import com.PizzaHut.dtos.ApiResponse;

import com.PizzaHut.entities.Item;

import com.PizzaHut.entities.ItemImage;
import com.PizzaHut.entities.Topping;
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

	@Autowired
	private ToppingDao toppingDao;


	@Autowired
	private ItemImageDao itemImgDao;


	public byte[] getToppingImage(int toppingId) throws IOException {
		ToppingImage toppingimg = toppingImgDao.findById(toppingId)
				.orElseThrow(() -> new ResourceNotFoundException("InValid topping Id !!!!!"));
		String path = toppingimg.getData();
		if (path == null) {
			throw new ResourceNotFoundException("Image does Not Exists !!!!");
		}
		return Files.readAllBytes(Paths.get(path));
	}

	public ApiResponse uploadToppingImage(int Id, MultipartFile imageFile) throws IOException {
		Topping topping = toppingDao.findByToppingId(Id)
				.orElseThrow(() -> new ResourceNotFoundException("InValid topping Id !!!!!"));
		String targetPath = toppingImageFolder + File.separator + "topping" + topping.getToppingId() + "."
				+ imageFile.getOriginalFilename().split("\\.")[1];
		System.out.println("Topping Image Path : " + targetPath);
		ToppingImage img = new ToppingImage();
		Files.copy(imageFile.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
		img.setData(targetPath);
		img.setToppings(topping);
		toppingImgDao.save(img);

		return new ApiResponse("Pizza Image Uploaded Sucessfully !!!");

	}



	public byte[] getPizzaImage(int itemId) throws IOException {

		ItemImage pizza = itemImgDao.findByItemId(itemId);


		String path = pizza.getData();
		if (path == null) {
			throw new ResourceNotFoundException("Image does Not Exists !!!!");
		}
		return Files.readAllBytes(Paths.get(path));
	}

	
}
