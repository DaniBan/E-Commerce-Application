package com.online_store.dto;

import com.online_store.entity.*;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Integer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
