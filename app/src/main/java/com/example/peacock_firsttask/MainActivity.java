package com.example.peacock_firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peacock_firsttask.UtilsClasses.User_Form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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



    private boolean validateName(String nameInput){


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
    private boolean validateContact(String contactInput){

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

    protected boolean validateEmail(String emailInput){


        String regex1 = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex1);
        if(emailInput.isEmpty())
        {
            email.setError("Field can't be empty");
            return false;
        }
        matcher = pattern.matcher(emailInput);
        if(matcher.matches())
        {
            return true;
        }
        else {
            email.setError("Please enter a valid email address");
            return false;
        }
        //return matcher.matches();

        /* if(emailInput.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        }
        else if(!Pattern.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError("Please enter a valid email address");
            return false;
        }
        else
        {
            email.setError(null);
            return true;
        } */
    }
    private boolean validateAddress(String addressInput){

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

        String nameInput = name.getText().toString().trim();
        String contactInput = contact.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String addressInput = address.getText().toString().trim();

        if(!validateName(nameInput)  | !validateContact(contactInput) | !validateEmail(emailInput) | !validateAddress(addressInput))
        {
            Toast.makeText(MainActivity.this,"Form is not Submitted",Toast.LENGTH_SHORT).show();
            return;
        }
        User_Form form = new User_Form(nameInput, contactInput, emailInput, addressInput);
        Toast.makeText(MainActivity.this,nameInput+"\n"+contactInput+"\n"+emailInput+"\n"+addressInput+"\n",Toast.LENGTH_SHORT).show();
    }

}
