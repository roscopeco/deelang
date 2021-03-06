package com.roscopeco.deelang;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  com.roscopeco.deelang.parser.UnitTests.class,
  com.roscopeco.deelang.compiler.dex.UnitTests.class,
  com.roscopeco.deelang.compiler.deevm.UnitTests.class,
  com.roscopeco.deelang.runtime.dex.UnitTests.class,
  com.roscopeco.deelang.runtime.deevm.UnitTests.class
})
public class UnitTests { }
