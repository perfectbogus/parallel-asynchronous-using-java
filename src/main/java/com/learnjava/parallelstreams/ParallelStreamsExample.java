/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.delay;
import static com.learnjava.util.CommonUtil.getTimeTimer;
import static com.learnjava.util.CommonUtil.resetTimer;
import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.stopTimer;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamsExample {

  public List<String> stringTransform(List<String> nameesList, boolean isParallel) {
    Stream<String> namesStream = nameesList.stream();

    if (isParallel) {
      namesStream.parallel();
    }

    return namesStream.map(this::addNameLengthTransform).collect(Collectors.toList());
  }

  public List<String> stringTransformSequential(List<String> namesList) {
    return namesList.stream().map(this::addNameLengthTransform).collect(Collectors.toList());
  }

  public List<String> stringTransformParallel(List<String> namesList) {
    return namesList.parallelStream().map(this::addNameLengthTransform).collect(Collectors.toList());
  }
  public static void main(String[] args) {

    List<String> namesList = DataSet.namesList();
    ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();
    startTimer();
    List<String> resultList = parallelStreamsExample.stringTransformSequential(namesList);
    log("resultList: " + resultList);
    stopTimer();
    getTimeTimer();

    resetTimer();

    List<String> namesListParallel = DataSet.namesList();
    ParallelStreamsExample parallelStreamsExampleParallel = new ParallelStreamsExample();
    startTimer();
    List<String> resultListParallel = parallelStreamsExampleParallel.stringTransformParallel(namesListParallel);
    log("resultList: " + resultListParallel);
    stopTimer();
    getTimeTimer();

  }

  private String addNameLengthTransform(String name) {
    delay(500);
    return name.length() + " - " + name;
  }

}
