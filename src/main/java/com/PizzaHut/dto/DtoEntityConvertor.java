package com.PizzaHut.dto;

import org.springframework.stereotype.Component;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.Cart;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Item;
import com.PizzaHut.entities.ItemImage;
import com.PizzaHut.entities.ItemSize;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.entities.Toppings;
import com.PizzaHut.entities.Users;

@Component
public class DtoEntityConvertor {
	
	//addressDto to Address
	public Address toAddressEntity(AddressDto addressDto) {
		Address convertedAddress = new Address();
		Users useraddress = new Users();
		useraddress.setUserId(addressDto.getUserId());
		convertedAddress.setUser(useraddress);
		convertedAddress.setPlotNo(addressDto.getPlotNo());
		convertedAddress.setStreetName(addressDto.getStreetName());
		convertedAddress.setCity(addressDto.getCity());
		convertedAddress.setDistrict(addressDto.getDistrict());
		convertedAddress.setState(addressDto.getState());
		convertedAddress.setPincode(addressDto.getPincode());
		return convertedAddress;
	}
	
	public Users toUserEntity(UserDto dto) {
		Users entity = new Users();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setPhoneNo(dto.getPhoneNo());
		return entity;		
	}
	
	//Address to addressDto
	
	/* Don't know where to use but may be used in future for fast perfoemance */
//	public AddressDto toAddressDtoEntity(Address address) {
//		System.out.println("In convertor");
//		AddressDto convertedAddressDto = new AddressDto();
//		convertedAddressDto.setUserId(address.getUser().getUserId());
//		convertedAddressDto.setPlotNo(address.getPlotNo());
//		convertedAddressDto.setStreetName(address.getStreetName());
//		convertedAddressDto.setCity(address.getCity());
//		convertedAddressDto.setState(address.getState());
//		convertedAddressDto.setPincode(address.getPincode());
//		return convertedAddressDto;
//	}
	
	//cartdto to cart
	public Cart tocartEntityNoTopping(CartDtoWithoutTopping cartWithoutTopping) {
		System.out.println("In convertor");
		Cart convertedcart = new Cart();
		Users user= new Users();
		user.setUserId(cartWithoutTopping.getUserId());
		ItemSize itemSize = new ItemSize();
		itemSize.setSizeId(cartWithoutTopping.getSizeId());
		convertedcart.setUser(user);
		convertedcart.setItemsize(itemSize);
		convertedcart.setQuantity(cartWithoutTopping.getQuantity());
		convertedcart.setPrice(cartWithoutTopping.getPrice());
		convertedcart.setCartstatus(1);
		return convertedcart;
	}
	
	public Cart tocartEntity(CartDto cartDto) {
		System.out.println("In convertor");
		Cart convertedcart = new Cart();
		Users user= new Users();
		user.setUserId(cartDto.getUserId());
		ItemSize itemSize = new ItemSize();
		itemSize.setSizeId(cartDto.getSizeId());
		Toppings topping = new Toppings();
		topping.setToppingId(cartDto.getToppingId());
		convertedcart.setUser(user);
		convertedcart.setItemsize(itemSize);
		convertedcart.setToppings(topping);
		convertedcart.setQuantity(cartDto.getQuantity());
		convertedcart.setPrice(cartDto.getPrice());
		convertedcart.setCartstatus(1);
		return convertedcart;
	}
	
	//for inserting image
	public ItemImage toItemEntity(ItemImgFormDto itemDto, int itemId) {
		System.out.println("in convertor before");
		if(itemDto == null)
			return null;
		ItemImage itemImg = new ItemImage();
		Item item = new Item();
		item.setItemid(itemId);
		itemImg.setItem(item);
		itemImg.setTime(itemDto.getTime());
		System.out.println(itemDto.getTime());
//		try {
//			itemImg.setData(itemDto.getData().getBytes());
//		} catch (Exception e) {
//			throw new MultipartException("Can't convert MultipartFile to bytes : " + itemDto.getData(), e);
//		}
		return itemImg;
	}
	
	//insert image of toppings
//	public ToppingImages toToppingImageEntity(ToppingImageDto toppingImageDto,int toppingId) {
//		System.out.println("In convertor");
//		if(toppingImageDto==null)
//			return null;
//		ToppingImages toppingImg=new ToppingImages();
//		Toppings topping=new Toppings();
//		topping.setToppingId(toppingId);
//		toppingImg.setToppings(topping);
//		System.out.println("time ==>"+toppingImageDto.getTopTime());
//		
//		return toppingImg;
//	}
	
	public ItemDto toItemDto(Item itemList){
		ItemDto itemDto= new ItemDto();
		itemDto.setItemName(itemList.getItemName());
		itemDto.setItemid(itemList.getItemid());
		itemDto.setDescription(itemList.getDescription());
		itemDto.setType(itemList.getType());
		return itemDto;
	}
	
	public Payments toPaymentEntity(PaymentDto paymentDto, Double totalamount)
	{
		Payments convertPayment=new Payments();
		Users user=new Users();
		user.setUserId(paymentDto.getUserId());
		convertPayment.setPayStatus(paymentDto.getPayStatus());
		convertPayment.setUsers(user);
		convertPayment.setMode(paymentDto.getMode());
		convertPayment.setTotalAmount(totalamount);
		return convertPayment;	
	}
	
	public DeliveryStatus toDelivery(DeliveryDto dto)
	{
		System.out.println("In convertor");
		DeliveryStatus convertDelivery=new DeliveryStatus();
		Payments convertPay=new Payments();
		Users user = new Users();
		Address address = new Address();
		address.setAddressId(dto.getAddressid());
		user.setUserId(dto.getUserId());
		convertDelivery.setPayments(convertPay);
		convertDelivery.setDeliveryStatus(dto.getDeliveryStatus());
		convertDelivery.setUsers(user);
		convertDelivery.setAddress(address);
		return convertDelivery;
	}
}






