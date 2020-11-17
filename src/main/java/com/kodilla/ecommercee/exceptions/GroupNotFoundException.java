package com.kodilla.ecommercee.exceptions;

public class GroupNotFoundException extends Exception {

    private final static String message = "The Id of this group does not exist";

    public GroupNotFoundException() {
        super(message);
    }
}