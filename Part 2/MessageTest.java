/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    @Test
    public void testMessagesLength_Success(){
        Message msg = new Message(1,"27718693002","Hi john, how are you today?");
        
        assertTrue(msg.getMessage().length()<=250, "Message should be within 250 characters.");
    }
    @Test
    public void testMessageLength_Failure(){
        String longMessage= "A".repeat(260);
        Message msg = new Message(2,"+27718693002",longMessage);
        int overLimit = msg.getMessage().length()-250;
        assertTrue(overLimit>0,"Message exceeds 250 characters by"+overLimit);
    }
    @Test
    public void testPhoneNumberFormat_Success(){
        Message msg = new Message(1,"+27718693002","Test");
        
        assertTrue(msg.checkRecipientCell(),"Cell phone number successfully captured.");
    }
    @Test
    public void testPhoneNumberFormat_Failure(){
        Message msg = new Message(1,"08575975889","Test");
        
        assertFalse(msg.checkRecipientCell(),"Phone number should start with an international code.");
    }
    @Test
    public void testMessageHashFormat(){
        Message msg = new Message(1, "+27718693002","Hi john, how are you today?");
        String hash = msg.createMessageHash();
        
        assertTrue(hash.matches("\\d{2}:\\d+:\\w+\\w+"),"Message hash format should be correct, e.g. 00:1:HITONIGHT");
    }
    @Test
    public void testSendMessageOption_Send(){
        Message msg = new Message(1,"+27718693002","Test");
        String result = msg.sendMessage("1");
        assertEquals("Message successfully sent.",result);
    }
    @Test
    public void testSendMessageOption_Disregard(){
        Message msg = new Message(1,"_+27718693002","Test");
        String result = msg.sendMessage("2");
        assertEquals("Press 0 to delete message.",result);
    }
    @Test
    public void testSendMessageOption_Store(){
        Message msg = new Message (1,"+27718693002","Test");
        String result = msg.sendMessage("3");
        assertEquals("Message successfully stored",result);
    }
}

