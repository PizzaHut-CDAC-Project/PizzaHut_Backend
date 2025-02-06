package com.PizzaHut.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Cart;
 

public interface CartDao extends JpaRepository<Cart, Integer>{
	
	@Query(value = "update cart set cartstatus=0 where userId =?1", nativeQuery = true)
	@Modifying
	void changeStatus(Integer userId);
	@Modifying
	@Query(value = "update cart set deliveryId=?1 where userId =?2 and deliveryId is null", nativeQuery = true)
	Integer addForeign(Integer delid,Integer userid);
	@Query(value="DELETE from cart where deliveryId=?1",nativeQuery = true)
	@Modifying
	void deleteByDeliveryId(Integer deliveryid);
}
