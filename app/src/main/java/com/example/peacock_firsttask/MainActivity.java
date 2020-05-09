package com.example.peacock_firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText contact;
    EditText email;
    EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.User_Name);
        contact=findViewById(R.id.User_Contact);
        email=findViewById(R.id.User_Email);
        address=findViewById(R.id.User_Address);
    }
    private boolean validateName( EditText name){
        String nameInput;
        nameInput = name.getText().toString().trim();

        if(nameInput.isEmpty()){
            name.setError("Field can't be empty");
            return false;
        }
        else if(nameInput.length()<3)
        {
            name.setError("Name is too short");
            return false;
        }
        else if(nameInput.length()>20)
        {
            name.setError("Name is too long");
            return false;
        }
        else {
            name.setError(null);
            return true;
        }
    }
    private boolean validateContact( EditText contact){
        String contactInput;
        contactInput = contact.getText().toString().trim();

        if(contactInput.isEmpty()){
            contact.setError("Field can't be empty");
            return false;
        }
        else if(contactInput.length()!=10) {
            contact.setError("Please enter valid mobile no.");
            return false;
        }
        else
        {
            contact.setError(null);
            return true;
        }
    }

    private boolean validateEmail( EditText email){
        String emailInput;
        emailInput = email.getText().toString().trim();

        if(emailInput.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError("Please enter a valid email address");
            return false;
        }
        else
        {
            email.setError(null);
            return true;
        }
    }
    private boolean validateAddress( EditText address){
        String addressInput;
        addressInput = address.getText().toString().trim();

        if(addressInput.isEmpty()){
            address.setError("Field can't be empty");
            return false;
        }
        else if(addressInput.length()<3)
        {
            address.setError("Address is too short");
            return false;
        }
        else {
            address.setError(null);
            return true;
        }
    }

    public void onclick(View view) {

        if(!validateName(name)  | !validateContact(contact) | !validateEmail(email) | !validateAddress(address))
        {
            return;
        }
        Toast.makeText(MainActivity.this,"Form is Submitted",Toast.LENGTH_SHORT).show();
    }

}
