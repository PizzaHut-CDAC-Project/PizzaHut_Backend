package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.AddressDao;
import com.PizzaHut.dao.CartDao;
import com.PizzaHut.dao.DeliveryStatusDao;
import com.PizzaHut.dto.DeliveryDto;
import com.PizzaHut.dto.DeliveryStatUpdateDto;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.PaymentDto;
import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.entities.Users;
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
	private AddressDao addrDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private DeliveryStatusDao deliveryStatusDao;

	//get list of delivery by userid
	public List<DeliveryStatus> findByUserId(int userId) {
		Users getDeliveries = new Users();
		getDeliveries.setUserId(userId);
		List<DeliveryStatus> deliveryList = statusDao.findByUsers(getDeliveries);
		return deliveryList;
	}

	// get all delivery
//	public List<DeliveryStatus> fetchAllDelivery() {
//		List<DeliveryStatus> deliveryList = statusDao.findAll();
//		return deliveryList;
//	}

	public DeliveryStatus addForDelivery(DeliveryDto deliveryDto) {
		DeliveryStatus add = convertor.toDelivery(deliveryDto);
		statusDao.save(add);
		cartService.addForeignKey(add.getDeliveryId(), deliveryDto.getUserId());
		return add;
	}
	
	public DeliveryStatus addDeliveryStatus(PaymentDto paymentDto,Payments payment) {
		Address addr = addrDao.findById(paymentDto.getAddresspayId()).orElseThrow(()->new ResourceNotFoundException("invalid address id"));
		DeliveryStatus deliveryStatus = new DeliveryStatus();
		deliveryStatus.setUsers(addr.getUser());
		deliveryStatus.setAddress(addr);
		deliveryStatus.setDeliveryStatus("Order Received");
		deliveryStatus.setPayments(payment);
		deliveryStatusDao.save(deliveryStatus);
		return deliveryStatus;
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
	
//	public List<DeliveryStatusDto> getAllDeliveryStatus() {
//		List<DeliveryStatus> deliveryStatus = statusDao.findAllDeliveryStatusWithDetails();
//		List<DeliveryStatusDto> deliveryStatusDTOList = new ArrayList<DeliveryStatusDto>();
//		for(DeliveryStatus ds: deliveryStatus) {
//			DeliveryStatusDto dsdto=new DeliveryStatusDto();
//			dsdto.setDeliveryId(ds.getDeliveryId());
//			dsdto.setFirstName(ds.getUsers().getFirstName());
//			dsdto.setLastName(ds.getUsers().getLastName());
//			dsdto.setEmail(ds.getUsers().getEmail());
//			dsdto.setPlotNo(ds.getAddress().getPlotNo());
//			dsdto.setStreetName(ds.getAddress().getStreetName());
//			dsdto.setCity(ds.getAddress().getCity());
//			dsdto.setPincode(ds.getAddress().getPincode());
//			dsdto.setTotalAmount(ds.getPayments().getTotalAmount());
//			dsdto.setPayStatus(ds.getPayments().getPayStatus());
//			deliveryStatusDTOList.add(dsdto);
//		}
//		return deliveryStatusDTOList;
//	}
	
	public List<DeliveryStatus> getAllDeliveryStatus() {
		return deliveryStatusDao.findAllDeliveryStatus();
	}

}
