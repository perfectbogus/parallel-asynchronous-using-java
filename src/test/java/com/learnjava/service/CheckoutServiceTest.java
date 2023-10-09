package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

  PriceValidatorService priceValidatorService = new PriceValidatorService();
  CheckoutService checkoutService = new CheckoutService(priceValidatorService);


  @Test
  void testSum() {
    //given
    Cart cart = DataSet.createCart(6);

    //when
    CheckoutResponse checkout = checkoutService.checkout(cart);

    //then
    assertEquals(CheckoutStatus.SUCCESS, checkout.getCheckoutStatus());
    assertTrue(checkout.getFinalRate() > 0);
  }
  @Test
  void checkout() {
    //given
    Cart cart = DataSet.createCart(6);

    //when
    CheckoutResponse checkout = checkoutService.checkout(cart);

    //then
    assertEquals(CheckoutStatus.SUCCESS, checkout.getCheckoutStatus());
  }

  @Test
  void checkout13() {
    //given
    Cart cart = DataSet.createCart(13);

    //when
    CheckoutResponse checkout = checkoutService.checkout(cart);

    //then
    assertEquals(CheckoutStatus.FAILURE, checkout.getCheckoutStatus());
  }

  @Test
  void checkout25() {
    //given
    Cart cart = DataSet.createCart(25);

    //when
    CheckoutResponse checkout = checkoutService.checkout(cart);

    //then
    assertEquals(CheckoutStatus.FAILURE, checkout.getCheckoutStatus());

    //8 cores - takes 4 times approx 2000 ms

  }
  @Test
  void cores() {
    System.out.println("no of cores:" + Runtime.getRuntime().availableProcessors());
  }

}