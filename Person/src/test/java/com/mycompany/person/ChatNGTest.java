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
public class ChatNGTest {
    
    public ChatNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Chat.main(args);
        fail("The test case is a prototype.");
    }
    
}
