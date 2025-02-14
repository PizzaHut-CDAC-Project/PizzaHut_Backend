package com.PizzaHut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.ItemSize;

public interface ItemSizeDao extends JpaRepository<ItemSize, Integer>{
	@Query(value="SELECT * from itemsize WHERE itemId=:itemId",nativeQuery = true)
	List<ItemSize> getSizeOfPizza(Integer itemId);
	
//	List<ItemSize> findByItemItemid(Integer size,Integer itemid);
	
	@Modifying
	@Query(value="DELETE from itemsize WHERE itemId=:itemId",nativeQuery = true)
	void deleteAllByItemId(Integer itemId);
}
