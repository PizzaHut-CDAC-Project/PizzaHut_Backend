package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.CartDao;
import com.PizzaHut.daos.DeliveryStatusDao;
import com.PizzaHut.dtos.DeliveryDto;
import com.PizzaHut.dtos.DeliveryStatUpdateDto;
import com.PizzaHut.dtos.DtoEntityConvertor;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.User;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class DeliveryStatusService {

	@Autowired
	private DeliveryStatusDao statusDao;
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartDao cartDao;
	 

	//get list of delivery by userid
	public List<DeliveryStatus> findByUserId(int userId) {
		User getDeliveries = new User();
		getDeliveries.setUserId(userId);
		List<DeliveryStatus> deliveryList = statusDao.findByUser(getDeliveries);
		return deliveryList;
	}

	public DeliveryStatus addForDelivery(DeliveryDto deliveryDto) {
		DeliveryStatus add = convertor.toDelivery(deliveryDto);
		statusDao.save(add);
		cartService.addForeignKey(add.getDeliveryId(), deliveryDto.getUserId());
		return add;
	}
	
	public List<DeliveryStatus> getAllDeliveryStatus() {
		return statusDao.findAllDeliveryStatus();
	}
	
	public String updateDeliveryStatus(Integer deliveryId,DeliveryStatUpdateDto deliveryStatus) {
		DeliveryStatus delivery=statusDao.findById(deliveryId).orElseThrow(() -> new ResourceNotFoundException("InValid pizza Id !!!!!"));
		
		delivery.setDeliveryStatus(deliveryStatus.getDeliverystatus());
		if(deliveryStatus.getDeliverystatus().equals("Delivered")) {
			System.out.println("hello");
			cartDao.deleteByDeliveryId(deliveryId);
		}
		return "success";
}

}
