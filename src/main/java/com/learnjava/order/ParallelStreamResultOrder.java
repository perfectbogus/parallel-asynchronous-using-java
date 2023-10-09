/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.order;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParallelStreamResultOrder {

  public List<Integer> listOrder(List<Integer> inputList) {
    return inputList.parallelStream().map(integer -> integer * 2).collect(Collectors.toList());
  }

  public Set<Integer> setOrder(Set<Integer> inputSet) {
    return inputSet.parallelStream().map(integer -> integer * 2).collect(Collectors.toSet());
  }

}
