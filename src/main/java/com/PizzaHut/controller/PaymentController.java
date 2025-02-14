package com.PizzaHut.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.Payment.OrderRequest;
import com.PizzaHut.Payment.OrderResponse;
import com.PizzaHut.Payment.PaymentVerificationRequest;
import com.PizzaHut.Payment.PaymentVerificationResponse;
import com.PizzaHut.dto.PaymentDto;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.services.DeliveryStatusService;
import com.PizzaHut.services.PaymentService;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	  @Autowired
			private PaymentService payService;
			@Autowired
			private DeliveryStatusService deliveryService;

			
	
	 @Autowired
	  private RazorpayClient razorpayClient;

	  @PostMapping("/create-order")
	  public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
	    try {
	      // Create a Razorpay order
	      Order order = razorpayClient.Orders.create(orderRequest.toJsonObject());
	      return ResponseEntity.ok(new OrderResponse(order.get("id")));
	    } catch (RazorpayException e) {
	      return ResponseEntity.badRequest().body(e.getMessage());
	    }
	  }


	  @PostMapping("/verify-payment")
	  public ResponseEntity<?> verifyPayment(@RequestBody PaymentVerificationRequest paymentRequest) {
	      // For testing purposes only, skipping signature verification
	      return ResponseEntity.ok(new PaymentVerificationResponse(true)); 
	  }
	  
	  
	
		
		//add Payment
		@PostMapping("/addPayment")
		public ResponseEntity<?> addPayments(@RequestBody PaymentDto paymentDto)
		{
			try {
				System.out.println(paymentDto);
				Payments newPayment=payService.addPayments(paymentDto);
				System.out.println("Inserted in payments table");
				DeliveryStatus added = deliveryService.addDeliveryStatus(paymentDto,newPayment);
				return Response.success(added);
			}catch(ResourceNotFoundException e) {
				return Response.error(e.getMessage());
			}
			catch (Exception e) {
				return Response.error(e.getMessage());
			}
		}
		@GetMapping("/showCurrent/{payId}")
		public ResponseEntity<?> showCurrentPayment(@PathVariable("payId")int payId)
		{
			try {
				Payments curPayment=payService.findPayments(payId);
				System.out.println(curPayment);
				if(curPayment==null)
					return Response.error("No result found");
				return Response.success(curPayment);
			} catch (Exception e) {
				return Response.error(e.getMessage());
			}
		}
	
}
