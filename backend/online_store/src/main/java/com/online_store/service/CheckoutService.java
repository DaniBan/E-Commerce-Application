package com.online_store.service;

import com.online_store.dto.Purchase;
import com.online_store.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
