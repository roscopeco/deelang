package com.roscopeco.deelang;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  com.roscopeco.deelang.parser.UnitTests.class,
  com.roscopeco.deelang.compiler.dex.UnitTests.class,
  com.roscopeco.deelang.vm.compiler.UnitTests.class,
  com.roscopeco.deelang.runtime.UnitTests.class,
  com.roscopeco.deelang.vm.UnitTests.class
})
public class UnitTests { }
