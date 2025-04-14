/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.person;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private String cellNumber;
    
    public Login(String firstName,String lastName,String username,String password,String cellNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.userName=username;
        this.cellNumber=cellNumber;
    }
    public String getUsername(){
        return userName;
    }
    public void setUsername(String username){
        this.userName= username;
    }
    public boolean checkUsernameName(){
        return userName.contains("_")&& 
                userName.length()<=5;
    }
        public String getPassword() {
        return password;
    }
    public void displayFullName(){
      System.out.println(firstName+" "+lastName);
    }
    public static boolean checkPasswordComplex(String password){
        return password.length() >=8&&
                password.matches(".*[A-Z].*")&&
                password.matches(".*[a-z].*")&&
                password.matches(".*[0-9].*")&&
                password.matches(".*[!@#$%^&*()].*");
        
    }
    public static boolean checkCellPhoneNumber(String phoneNumber){//ChatGPT assisted
        return phoneNumber.length() == 12 &&
               phoneNumber.startsWith("27") &&
               phoneNumber.matches("\\d+");
            }
        }

