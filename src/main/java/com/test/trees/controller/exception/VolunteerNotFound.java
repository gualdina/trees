package com.test.trees.controller.exception;

public class VolunteerNotFound extends RuntimeException{
    public VolunteerNotFound(){
        super("Volunteer not register");
    }
}
