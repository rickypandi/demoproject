package com.app.full;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Getempdetailstest {
	Getempdetails get=new Getempdetails();
@After
public void Aftertest(){
	
}
	@Test(timeout=1)
	public void test_userinput(){
		String actual_input=null;
		String Expected_input=get.input;
		assertEquals(Expected_input,actual_input);
		}
	
@Test
public void test_output() {
	String actual_output=null;
	String Expected_output=get.printProperties;
	assertEquals(Expected_output,actual_output);
}
	

}
