package com.PizzaHut.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.PizzaHut.services.ImageHandlerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itemImage")
public class ItemImageController {
	
	@Autowired
	private ImageHandlerService fileService;
	

	// add image of a item
//	@PostMapping("/add/{itemid}")
//	public ResponseEntity<?> addItemImage(@PathVariable("itemid") int itemid, MultipartFile itemImg) {
//		try {
//			ApiResponse result = imgService.uploadPizzaImage(itemid, itemImg);
//			if(!result.isEmpty()) {
//				return Response.success(result);
//			}else {
//				return Response.error("No Item Found");
//			}
//		} catch (Exception e) {
//			return Response.error(e.getMessage());
//		}
//	}
	@PostMapping(value = "/add/{itemId}", consumes = "multipart/form-data")
	public ResponseEntity<?> addItemImage(@RequestBody MultipartFile imageFile, @PathVariable Integer itemId)
			throws IOException {
		return new ResponseEntity<>(fileService.uploadPizzaImage(itemId, imageFile), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getpizzathumbnail/{itemId}", produces = { MediaType.IMAGE_GIF_VALUE,
			MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> getPizzaImage(@PathVariable Integer itemId) throws IOException {
		return new ResponseEntity<>(fileService.getPizzaImage(itemId), HttpStatus.OK);
	}
}

	
