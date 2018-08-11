package com.example.demo.powermock;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivatePartialMockingExample.class)
public class PrivatePartialMockingExampleTest {

  @Test
  public void demoPrivateMethodMocking() throws Exception {
    final String expected = "TEST VALUE";
    final String nameOfMethodToMock = "methodToMock";
    final String input = "input";

    PrivatePartialMockingExample underTest = spy(new PrivatePartialMockingExample());

    //定制
    when(underTest, nameOfMethodToMock, input).thenReturn(expected);

    assertEquals(expected, underTest.methodToTest());

    // Optionally verify that the private method was actually called
    verifyPrivate(underTest).invoke(nameOfMethodToMock, input);
  }


  @Test
  public void whenCreateMock_thenCreated() {
    List mockedList = Mockito.mock(ArrayList.class);

    mockedList.add("one");
    Mockito.verify(mockedList).add("one");

    assertEquals(0, mockedList.size());
  }


  @Test
  public void whenCreateSpy_thenCreate() {
    List spyList = Mockito.spy(new ArrayList());

    spyList.add("one");
    Mockito.verify(spyList).add("one");

    assertEquals(1, spyList.size());
  }
}