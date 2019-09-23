package com.app.full;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class Createemptest {
	Createemp emp=new Createemp();

  @Test
  public void first_name() throws IOException{
	  String fnameactual=null;
	  String fnameExpected = emp.fname;
           assertEquals(fnameExpected,fnameactual);
  }
  @Test
  public void last_name(){
	  
	  String lnameactual=null;
	  String lnameExpected=emp.lname;
	  assertEquals(lnameExpected,lnameactual);
  }
  @Test
 public void email_id() {
	  String email_idactual=null;
	  String email_idExpected=emp.emailid;
	  assertEquals(email_idExpected,email_idactual);
  }
  @Test
  public void UUID() {
	  java.util.UUID uuid_actual=emp.uuid;
	  String uuid_expected=emp.pkey;
	  assertEquals(uuid_expected,uuid_actual);
  }
  @Test
  public void create_entity() {
	  String Entity_actual=null;
	  Entity Entity_expected=emp.user;
	  assertEquals(Entity_expected,Entity_actual);
  }
  @Test
  public void create_key(){
	  Key actual_key=null;
	  Key Expected_key=emp.key;
	  assertEquals(Expected_key,actual_key);
  }
	  
}
