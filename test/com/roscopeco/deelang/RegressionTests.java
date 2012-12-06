package com.roscopeco.deelang;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  com.roscopeco.deelang.runtime.deevm.RegressionTests.class,
  com.roscopeco.deelang.compiler.dex.RegressionTests.class
})
public class RegressionTests { }
