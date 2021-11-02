package com.test.trees.controller.exception;

public class StorageNotFound extends RuntimeException{
    public StorageNotFound() {
        super("Storage doesn't exist");
    }
}
