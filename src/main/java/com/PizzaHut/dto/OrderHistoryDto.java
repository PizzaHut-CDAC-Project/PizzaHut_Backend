package com.PizzaHut.dto;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.ItemSize;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.entities.Toppings;
import com.PizzaHut.entities.Users;

public class OrderHistoryDto {
	private int userId;
	private int sizeId;
	private int toppingId;
	private int quantity;
	private double totalPrice;
	private int payId;
	private int deliveryId;
	private int addressId;
	private Users user;
	private Address addresses;
	private Payments pays;
	private ItemSize sizes;
	private Toppings topps;
	
	public OrderHistoryDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderHistoryDto(int userId, int sizeId, int toppingId, int quantity, double totalPrice, int payId,
			int deliveryId, int addressId, Users user, Address addresses, Payments pays, ItemSize sizes,
			Toppings topps) {
		super();
		this.userId = userId;
		this.sizeId = sizeId;
		this.toppingId = toppingId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.payId = payId;
		this.deliveryId = deliveryId;
		this.addressId = addressId;
		this.user = user;
		this.addresses = addresses;
		this.pays = pays;
		this.sizes = sizes;
		this.topps = topps;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	public Payments getPays() {
		return pays;
	}

	public void setPays(Payments pays) {
		this.pays = pays;
	}

	public ItemSize getSizes() {
		return sizes;
	}

	public void setSizes(ItemSize sizes) {
		this.sizes = sizes;
	}

	public Toppings getTopps() {
		return topps;
	}

	public void setTopps(Toppings topps) {
		this.topps = topps;
	}

	@Override
	public String toString() {
		return String.format(
				"OrderHistoryDto [userId=%s, sizeId=%s, toppingId=%s, quantity=%s, totalPrice=%s, payId=%s, deliveryId=%s, addressId=%s, user=%s, addresses=%s, pays=%s, sizes=%s, topps=%s]",
				userId, sizeId, toppingId, quantity, totalPrice, payId, deliveryId, addressId, user, addresses, pays,
				sizes, topps);
	}

	
}
