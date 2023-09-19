/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.service;

import com.learnjava.domain.ProductInfo;
import lombok.Getter;

public class ProductInfoRunnable implements Runnable{

  private ProductInfoService productInfoService = new ProductInfoService();

  @Getter
  private ProductInfo productInfo;
  private String productId;
  public ProductInfoRunnable(String productId) {
    this.productId = productId;
  }

  @Override
  public void run() {
    productInfo = productInfoService.retrieveProductInfo(productId);
  }
}
