/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.spliterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinkedListSpliteratorExample {

  public List<Integer> multiplyValuesSequentially(LinkedList<Integer> list, int multiply) {

    Stream<Integer> stream = list.stream();

    List<Integer> result = stream.map(integer -> multiply * integer).collect(Collectors.toList());

    return result;
  }

  public List<Integer> multiplyValuesParallel(LinkedList<Integer> list, int multiply, boolean isParallel) {

    Stream<Integer> stream = list.stream();

    if (isParallel) {
      stream.parallel();
    }

    List<Integer> result = stream.map(integer -> multiply * integer).collect(Collectors.toList());

    return result;
  }
}
