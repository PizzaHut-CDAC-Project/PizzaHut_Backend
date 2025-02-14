	package com.PizzaHut.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cartId;
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "sizeId")
	private ItemSize itemsize;
	@ManyToOne
	@JoinColumn(name = "toppingId")
	private Toppings toppings;
	private int quantity;
	private double price;
	private int cartstatus;
	@OneToOne
	@JoinColumn(name = "deliveryId")
	private DeliveryStatus deliveryId;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, Users user, ItemSize itemsize, Toppings toppings, int quantity, double price,
			int cartstatus, DeliveryStatus deliveryId) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.itemsize = itemsize;
		this.toppings = toppings;
		this.quantity = quantity;
		this.price = price;
		this.cartstatus = cartstatus;
		this.deliveryId = deliveryId;
	}

	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ItemSize getItemsize() {
		return itemsize;
	}

	public void setItemsize(ItemSize itemsize) {
		this.itemsize = itemsize;
	}

	public Toppings getToppings() {
		return toppings;
	}

	public void setToppings(Toppings toppings) {
		this.toppings = toppings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCartstatus() {
		return cartstatus;
	}

	public void setCartstatus(int cartstatus) {
		this.cartstatus = cartstatus;
	}

	public DeliveryStatus getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(DeliveryStatus deliveryId) {
		this.deliveryId = deliveryId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", itemsize=" + itemsize + ", toppings=" + toppings
				+ ", quantity=" + quantity + ", price=" + price + ", cartstatus=" + cartstatus + ", deliveryId="
				+ deliveryId + "]";
	}
}