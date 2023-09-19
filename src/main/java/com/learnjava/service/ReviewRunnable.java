/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.service;

import com.learnjava.domain.Review;
import lombok.Getter;

public class ReviewRunnable implements Runnable {

  private ReviewService reviewService = new ReviewService();

  @Getter
  private Review review;
  private String productId;

  public ReviewRunnable(String productId) {
    this.productId = productId;
  }

  @Override
  public void run() {
    review = reviewService.retrieveReviews(productId);
  }
}
