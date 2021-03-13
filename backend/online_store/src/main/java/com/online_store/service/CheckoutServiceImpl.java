package com.online_store.service;

import com.online_store.dao.OrderRepository;
import com.online_store.dao.UserRepository;
import com.online_store.dto.Purchase;
import com.online_store.dto.PurchaseResponse;
import com.online_store.entity.Order;
import com.online_store.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public CheckoutServiceImpl(UserRepository userRepository, OrderRepository orderRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {


        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with addresses
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate user with order
        int customer = purchase.getCustomer();
        order.setUser(userRepository.findUserById(customer));

        // save to the database
        orderRepository.save(order);

        // return a response
        return  new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)

         return UUID.randomUUID().toString();
    }
}
