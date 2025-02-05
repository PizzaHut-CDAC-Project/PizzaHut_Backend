package com.PizzaHut.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.User;

public interface DeliveryStatusDao extends JpaRepository<DeliveryStatus	,Integer>{
	List<DeliveryStatus> findByUser(User user);
	
	@Query(value="select * from DeliveryStatus where deliveryStatus != 'Delivered'",nativeQuery = true )
	List<DeliveryStatus> findAllDeliveryStatus();
}
