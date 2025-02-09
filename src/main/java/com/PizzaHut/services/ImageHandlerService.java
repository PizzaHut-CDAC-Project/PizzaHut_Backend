package com.PizzaHut.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.PizzaHut.daos.ItemDao;
import com.PizzaHut.daos.ItemImageDao;
import com.PizzaHut.daos.ToppingDao;
import com.PizzaHut.daos.ToppingImageDao;
import com.PizzaHut.dtos.ApiResponse;

import com.PizzaHut.entities.Item;


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
	
	@Autowired 
	private ItemDao itemDao;

	
	@PostConstruct
	public void myInit() {
		// checks if folder exists and  if doesnt exist it creates one
		File pizzaImagePath = new File(pizzaImageFolder);
		File toppingImagePath=new File(toppingImageFolder);
		if (!pizzaImagePath.exists()) {
			pizzaImagePath.mkdirs();
		}
		if(!toppingImagePath.exists()) {
			toppingImagePath.mkdirs();
		}
		else {
			System.out.println("folders alrdy exists....");
		}

	}

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

	public ApiResponse uploadPizzaImage(int Id, MultipartFile imageFile) throws IOException {
		Item pizza = itemDao.findByItemid(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Pizza Id !!!!!"));
		String targetPath = pizzaImageFolder + File.separator + "pizza" + pizza.getItemid()+ "."
				+ imageFile.getOriginalFilename().split("\\.")[1];
		System.out.println("Pizza Image Path : " + targetPath);
		ItemImage img=new ItemImage();
		Files.copy(imageFile.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
		img.setData(targetPath);
		img.setItem(pizza);
		itemImgDao.save(img);
		
		return new ApiResponse("Pizza Image Uploaded Sucessfully !!!");
	}

	
}
