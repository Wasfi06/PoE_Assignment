/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.person;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Login instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Login instance = null;
        instance.setUsername(username);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckUsernameName() {
        System.out.println("checkUsernameName");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.checkUsernameName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Login instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisplayFullName() {
        System.out.println("displayFullName");
        Login instance = null;
        instance.displayFullName();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPasswordComplex() {
        System.out.println("checkPasswordComplex");
        String password = "";
        boolean expResult = false;
        boolean result = Login.checkPasswordComplex(password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = Login.checkCellPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
