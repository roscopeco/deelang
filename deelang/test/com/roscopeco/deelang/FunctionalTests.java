package com.roscopeco.deelang;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  com.roscopeco.deelang.parser.FunctionalTests.class,
  com.roscopeco.deelang.compiler.FunctionalTests.class
})
public class FunctionalTests { }
