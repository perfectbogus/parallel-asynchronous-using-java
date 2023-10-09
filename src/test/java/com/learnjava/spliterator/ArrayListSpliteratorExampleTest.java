package com.learnjava.spliterator;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListSpliteratorExampleTest {

  ArrayListSpliteratorExample service = new ArrayListSpliteratorExample();

  @RepeatedTest(5)
  void arrayListSpliteratorExample() {
    //given
    int size = 1000000;
    ArrayList<Integer> integers = DataSet.generateArrayList(size);

    CommonUtil.startTimer();
    List<Integer> results = service.multiplyValuesSecuentially(integers, 2);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();

    assertEquals(size, results.size());

  }

  @RepeatedTest(5)
  void arrayListSpliteratorParallel() {
    //given
    int size = 1000000;
    ArrayList<Integer> integers = DataSet.generateArrayList(size);

    CommonUtil.startTimer();
    List<Integer> results = service.multiplyValuesParallel(integers, 2, true);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();

    assertEquals(size, results.size());

  }

}