package com.PizzaHut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Users;

public interface DeliveryStatusDao extends JpaRepository<DeliveryStatus	,Integer>{
	List<DeliveryStatus> findByUsers(Users user);
	
	@Query("SELECT ds FROM DeliveryStatus ds " +
            "LEFT JOIN FETCH ds.payments " +
            "LEFT JOIN FETCH ds.users " +
            "LEFT JOIN FETCH ds.address")
    List<DeliveryStatus> findAllDeliveryStatusWithDetails();
	@Query(value="select * from DeliveryStatus where deliveryStatus != 'Delivered'",nativeQuery = true )
	List<DeliveryStatus> findAllDeliveryStatus();
}
