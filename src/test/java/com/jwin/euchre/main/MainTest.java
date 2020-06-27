package com.jwin.euchre.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {
  public static Stream<Arguments> testHelloParams() {
    return Stream.of(Arguments.of("hello world"), Arguments.of("hello world"), Arguments.of("hello world"),
        Arguments.of("hello world"), Arguments.of("hello world"));
  }
  
  @ParameterizedTest(name = "input = {0}")
  @MethodSource("testHelloParams")
  public void testHello(String input) {
    assertEquals("hello world", input);
  }
}
