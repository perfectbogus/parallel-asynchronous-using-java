/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CartItem;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;

import java.util.List;
import java.util.stream.Collectors;

import static com.learnjava.util.LoggerUtil.log;
import static java.util.stream.Collectors.summingDouble;

public class CheckoutService {

  private PriceValidatorService priceValidatorService;

  public CheckoutService(PriceValidatorService priceValidatorService) {
    this.priceValidatorService = priceValidatorService;
  }
  public CheckoutResponse checkout(Cart cart) {

    List<CartItem> priceValidationList = cart.getCartItemList().parallelStream().map(cartItem -> {
      boolean isPriceInvalid = priceValidatorService.isCartItemInvalid(cartItem);
      cartItem.setExpired(isPriceInvalid);
      return cartItem;
    }).filter(CartItem::isExpired).collect(Collectors.toList());

    if (priceValidationList.size() > 0) {
      return new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList);
    }

    double finalPrice = calculateFinalPrice(cart);
    log("Final Price:" + finalPrice);
    return new CheckoutResponse(CheckoutStatus.SUCCESS, finalPrice);
  }

  private double calculateFinalPrice(Cart cart) {
    return cart.getCartItemList().parallelStream()
        .map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
        .mapToDouble(Double::doubleValue).sum();
  }

  private double calculateFinalPriceReduced(Cart cart) {
    return cart.getCartItemList().parallelStream()
        .map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
        .reduce(0.0, (x, y) -> x+y);
  }

}
