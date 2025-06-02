/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class JSONHelper {
    private static final String FILE_PATH = "stored_messages.json";
    public static void storeMessage(Message message){
        try{
            File file=  new File(FILE_PATH);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ArrayList<Message>messages;
            
            if (file.exists()){
                FileReader reader = new FileReader(FILE_PATH);
                Type messageListType = new TypeToken<ArrayList<Message>>(){}.getType();
                messages = gson.fromJson(reader,messageListType);
                reader.close();
            }else{
                messages = new ArrayList<>();
            }
            messages.add(message);
            
            FileWriter writer = new FileWriter(FILE_PATH);
            gson.toJson(messages,writer);
            writer.flush();
            writer.close();
            
            System.out.println("Message successfully stored.");
        }catch (Exception e){
            System.out.println("Error storing message: "+ e.getMessage());
        }
    }
    public static ArrayList<Message> readMessagesFromJson(String filename){
        ArrayList<Message> messages = new ArrayList<>();
        try{
            Gson gson = new Gson();
            FileReader reader = new FileReader(filename);
            Type messageListType = new TypeToken<ArrayList<Message>>()
            {}.getType();
            messages = gson.fromJson(reader,messageListType);
            reader.close();
        }catch (Exception e){
            System.out.println("Error reading from JSON file: "+ e.getMessage());    
        }
        return messages;
    }
}
