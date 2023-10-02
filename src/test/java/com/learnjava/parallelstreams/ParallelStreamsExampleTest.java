package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.crypto.Data;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamsExampleTest {

  ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

  @Test
  void stringTransformParallel() {
    //given
    List<String> inputList = DataSet.namesList();


    //when
    List<String> resultList = parallelStreamsExample.stringTransformParallel(inputList);

    //then
    assertEquals(inputList.size(), resultList.size());

  }

  @Test
  void stringTransformParallelHyphenExists() {
    //given
    List<String> inputList = DataSet.namesList();


    //when
    List<String> resultList = parallelStreamsExample.stringTransformParallel(inputList);

    //then
    resultList.forEach(name -> assertTrue(name.contains("-")));

  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void stringTransformOptions(boolean isParallel) {
    //given
    List<String> inputList = DataSet.namesList();

    //when
    CommonUtil.startTimer();
    List<String> resultList = parallelStreamsExample.stringTransform(inputList, isParallel);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();

    //then
    assertEquals(inputList.size(), resultList.size());
  }


}
