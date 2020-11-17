package com.kodilla.ecommercee.exceptions;

public class CartNotFoundException extends Exception {

    private final static String message = "The Id of this cart does not exist";

    public CartNotFoundException() {
        super(message);
    }
}