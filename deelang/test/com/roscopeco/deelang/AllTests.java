package com.roscopeco.deelang;

import org.junit.runners.Suite;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  UnitTests.class,
  FunctionalTests.class,
})
public class AllTests { }
