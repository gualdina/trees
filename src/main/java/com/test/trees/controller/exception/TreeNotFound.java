package com.test.trees.controller.exception;

public class TreeNotFound extends RuntimeException{
    public TreeNotFound(){
        super("Tree Not Available");
    }
}
