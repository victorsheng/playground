package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.cglib.util.ParallelSorter;

public class SorterTest {

  @Test
  public void testParallelSorter() throws Exception {
    Integer[][] value = {
        {4, 3, 9, 0},
        {2, 1, 6, 0}
    };
    ParallelSorter.create(value).mergeSort(0);
    for (Integer[] row : value) {
      int former = -1;
      for (int val : row) {
        assertTrue(former < val);
        former = val;
      }
    }
  }

}
