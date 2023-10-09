package com.learnjava.spliterator;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSpliteratorExampleTest {

  LinkedListSpliteratorExample service = new LinkedListSpliteratorExample();

  @RepeatedTest(5)
  void multiplySequentially() {
    System.out.println("Sequentially");
    int size = 1000000;
    LinkedList<Integer> list = DataSet.generateIntegerLinkedList(size);

    CommonUtil.startTimer();
    List<Integer> results = service.multiplyValuesSequentially(list, 2);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();

  }

  @RepeatedTest(5)
  void multiplyParallel() {
    System.out.println("Parallel");
    int size = 1000000;
    LinkedList<Integer> list = DataSet.generateIntegerLinkedList(size);

    CommonUtil.startTimer();
    List<Integer> results = service.multiplyValuesParallel(list, 2, true);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();


  }

}