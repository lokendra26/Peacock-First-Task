package com.example.peacock_firsttask.UtilsClasses;

public class User_Form {

    String name_text;
    String contact_text;
    String email_text;
    String address_text;

    public User_Form(String name_text, String contact_text, String email_text, String address_text) {
        this.name_text=name_text;
        this.contact_text=contact_text;
        this.email_text=email_text;
        this.address_text=address_text;
    }

    public String getName_text (){
        return name_text;
    }

    public void setName_text(String name_text){
        this.name_text=name_text;
    }

    public String getContact_text (){
        return contact_text;
    }

    public void setContact_text(String contact_text){
        this.contact_text=contact_text;
    }

    public String getEmail_text (){
        return email_text;
    }

    public void setEmail_text(String email_text){
        this.email_text=email_text;
    }

    public String getAddress_text (){
        return address_text;
    }

    public void setAddress_text(String address_text){
        this.address_text=address_text;
    }



}
