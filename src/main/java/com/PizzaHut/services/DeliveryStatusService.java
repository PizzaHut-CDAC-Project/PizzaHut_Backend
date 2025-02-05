package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.PizzaHut.daos.DeliveryStatusDao;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.User;

@Service
@Transactional
public class DeliveryStatusService {

	@Autowired
	private DeliveryStatusDao statusDao;
	 

	//get list of delivery by userid
	public List<DeliveryStatus> findByUserId(int userId) {
		User getDeliveries = new User();
		getDeliveries.setUserId(userId);
		List<DeliveryStatus> deliveryList = statusDao.findByUser(getDeliveries);
		return deliveryList;
	}

 
	
 

}
