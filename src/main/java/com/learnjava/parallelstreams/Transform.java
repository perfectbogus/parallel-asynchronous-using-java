/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2023 Oracle Ⓡ and/or its affiliates. All rights reserved.
 *
 * ====================================================================================
 */

package com.learnjava.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transform {

  public List<String> toLowerCaseParallel(List<String> names) {
    return names.parallelStream().map(String::toLowerCase).collect(Collectors.toList());
  }

  public List<String> toLowerCaseSequential(List<String> names) {
    return names.stream().map(String::toLowerCase).collect(Collectors.toList());
  }

  public List<String> toLowerCase(List<String> names, boolean isParallel) {
    Stream<String> stream = names.stream();

    if (isParallel) {
      stream.parallel();
    }

    return stream.map(String::toLowerCase).collect(Collectors.toList());
  }

}
