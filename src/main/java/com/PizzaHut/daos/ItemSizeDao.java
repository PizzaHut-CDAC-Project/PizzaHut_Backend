package com.PizzaHut.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.ItemSize;

public interface ItemSizeDao extends JpaRepository<ItemSize, Integer> {

	@Modifying
	@Query(value="DELETE from itemsize WHERE itemId=:itemId",nativeQuery = true)
	void deleteAllByItemId(Integer itemId);

	
}
