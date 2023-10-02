/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformTest {

  Transform transform = new Transform();

  @Test
  public void sequential() {
    List<String> names = DataSet.namesList();

    CommonUtil.startTimer();
    List<String> result = transform.toLowerCaseSequential(names);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();
    System.out.println(result);
    assertEquals(names.size(), result.size());
  }

  @Test
  public void parallel() {
    List<String> names = DataSet.namesList();

    CommonUtil.startTimer();
    List<String> result = transform.toLowerCaseParallel(names);
    CommonUtil.stopTimer();
    CommonUtil.getTimeTimer();
    CommonUtil.resetTimer();
    System.out.println(result);
    assertEquals(names.size(), result.size());
  }
}
