package com.example.peacock_firsttask;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void validateEmail(){
        String input = "lokendramalav1999@gmail.com";
        boolean output;
        boolean expected = true;

        MainActivity mActivity = new MainActivity();
        output = mActivity.validateEmail(input);

        assertEquals(expected,output);
    }
}
