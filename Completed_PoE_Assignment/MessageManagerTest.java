/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;

import static com.mycompany.poe_part2.Main.sentMessages;
import static com.mycompany.poe_part2.Main.storedMessages;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 *
 * @author RC_Student_lab
 */
public class MessageManagerTest {
    public static void testSentMessagesArrayPopulated(){
        Main.populateArrays();
        assertEquals(2,
                Main.sentMessages.size());
        assertEquals("Did you get the food?",
                Main.sentMessages.get(1).getMessage());
    }
    public void testFindLongestMessage(){
        Main.populateArrays();
        String longest = Main.findLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.",
                longest);
    }
    public void testSearchByMessageID(){
        Main.populateArrays();
        Message found = Main.getMessageByID(Main.sentMessages.get(1).getMessageID());
        assertNotNull(found);
        assertEquals("It is dinner time!",found.getMessage());
    }
    public static Message getMessageByID(String id){
        for (Message msg : sentMessages){
            if (msg.getMessageID().equals(id)){
                return msg;
            }
        }
        return null;
    }
    public void testSearchByRecipient(){
        Main.populateArrays();
        List<String> results = Main.getMessageByRecipient("+27838884567");
        assertEquals(2,results.size());
        
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok,I am leaving without you"));
        
        
    }
    public static List<String>getMessagesByrecipient(String recipient){
        List<String> results = new ArrayList<>();
        for (Message msg : storedMessages){
            if (msg.getRecipient().equals(recipient)){
                results.add(msg.getMessage());
            }
        }
        return results;
    }
}