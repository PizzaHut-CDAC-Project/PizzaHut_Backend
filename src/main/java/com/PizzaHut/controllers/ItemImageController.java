package com.PizzaHut.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.PizzaHut.services.ImageHandlerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class ItemImageController {

	@Autowired
	private ImageHandlerService fileService;

	@GetMapping(value = "/getpizzathumbnail/{itemId}", produces = { MediaType.IMAGE_GIF_VALUE,
			MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> getPizzaImage(@PathVariable Integer itemId) throws IOException {
		return new ResponseEntity<>(fileService.getPizzaImage(itemId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/add/{itemId}", consumes = "multipart/form-data")
	public ResponseEntity<?> addItemImage(@RequestBody MultipartFile imageFile, @PathVariable Integer itemId)
			throws IOException {
		return new ResponseEntity<>(fileService.uploadPizzaImage(itemId, imageFile), HttpStatus.OK);
	}
}
