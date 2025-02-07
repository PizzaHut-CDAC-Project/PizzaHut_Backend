package com.PizzaHut.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Cart;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.User;
 

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
 
	@Query(value = "select * from cart where userid=?1 and cartstatus=?2 order by cartid desc;", nativeQuery = true)
	List<Cart> findByUserStatus(User user,Integer status);
	
	Cart findByDeliveryId(DeliveryStatus del);
 
	
	 
 
}
