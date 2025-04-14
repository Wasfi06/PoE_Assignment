/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.person;

import static org.testng.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginNGTest {
    
    public LoginNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Login instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Login instance = null;
        instance.setUsername(username);
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testCheckUsernameName() {
        System.out.println("checkUsernameName");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.checkUsernameName();
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Login instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testDisplayFullName() {
        System.out.println("displayFullName");
        Login instance = null;
        instance.displayFullName();
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testCheckPasswordComplex() {
        System.out.println("checkPasswordComplex");
        String password = "";
        boolean expResult = false;
        boolean result = Login.checkPasswordComplex(password);
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    @org.testng.annotations.Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = Login.checkCellPhoneNumber(phoneNumber);
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }
    
}
