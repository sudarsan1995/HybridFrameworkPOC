package com.hybrid.runner;

import org.junit.runner.RunWith;

import com.hybrid.baseclass.Base;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/com/hybrid/features" ,
		glue="com/hybrid/stepdefinition")
public class TestRunner extends Base
{
	

}
