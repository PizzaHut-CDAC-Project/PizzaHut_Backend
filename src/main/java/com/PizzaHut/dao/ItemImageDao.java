package com.PizzaHut.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Item;
import com.PizzaHut.entities.ItemImage;

public interface ItemImageDao extends JpaRepository<ItemImage, Integer>{
	@Modifying
	@Query(value="DELETE from itemimage WHERE itemId=:itemId",nativeQuery = true)
	void deleteAllByItemId(Integer itemId);
	@Query(value="SELECT * from itemimage WHERE itemId=:itemId order by itemImgId desc limit 1;",nativeQuery = true)
	ItemImage findByItemId(Integer itemId);
}
