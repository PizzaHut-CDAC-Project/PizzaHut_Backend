package com.PizzaHut.daos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.User;

public interface AddressDao extends JpaRepository<Address, Integer> {
	List<Address> findByUser(User user);

<<<<<<< HEAD

=======
>>>>>>> f34ae09fa0f7acde3791b8b93ae92fc1654f027c
}