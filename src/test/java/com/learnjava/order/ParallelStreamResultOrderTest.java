package com.learnjava.order;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.learnjava.util.LoggerUtil.log;

class ParallelStreamResultOrderTest {

  ParallelStreamResultOrder service = new ParallelStreamResultOrder();

  @Test
  void order() {
    List<Integer> inputList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    log("Input List:" + inputList);
    List<Integer> result = service.listOrder(inputList);
    log("Result: " + result);
  }

  @Test
  void setOrder() {
    Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7, 8);
    log("Input Set: " + set);
    Set<Integer> resultSet = service.setOrder(set);
    log("Result: " + resultSet);

  }

}