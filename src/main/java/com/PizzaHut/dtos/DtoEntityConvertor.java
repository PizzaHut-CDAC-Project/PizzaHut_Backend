package com.PizzaHut.dtos;

import org.springframework.stereotype.Component;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.Cart;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Item;
import com.PizzaHut.entities.ItemImage;
import com.PizzaHut.entities.ItemSize;
import com.PizzaHut.entities.Payment;
import com.PizzaHut.entities.Topping;
import com.PizzaHut.entities.User;
 

@Component
public class DtoEntityConvertor {
	
 
	
	public DeliveryStatus toDelivery(DeliveryDto dto)
	{
		System.out.println("In convertor");
		DeliveryStatus convertDelivery=new DeliveryStatus();
		Payment convertPay=new Payment();
		User user = new User();
		Address address = new Address();
		address.setAddressId(dto.getAddressid());
		user.setUserId(dto.getUserId());
		convertDelivery.setPayment(convertPay);
		convertDelivery.setDeliveryStatus(dto.getDeliveryStatus());
		convertDelivery.setUser(user);
		convertDelivery.setAddress(address);
		return convertDelivery;
	}
	
	public Cart tocartEntity(CartDto cartDto) {
		System.out.println("In convertor");
		Cart convertedcart = new Cart();
		User user= new User();
		user.setUserId(cartDto.getUserId());
		ItemSize itemSize = new ItemSize();
		itemSize.setSizeId(cartDto.getSizeId());
		Topping topping = new Topping();
		topping.setToppingId(cartDto.getToppingId());
		convertedcart.setUser(user);
		convertedcart.setItemsize(itemSize);
		convertedcart.setTopping(topping);
		convertedcart.setQuantity(cartDto.getQuantity());
		convertedcart.setPrice(cartDto.getPrice());
		convertedcart.setCartstatus(1);
		return convertedcart;
	}
}






