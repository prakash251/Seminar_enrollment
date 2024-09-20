package com.mybackend.controller;

@SuppressWarnings("serial")
public class DuplicateStudentException extends Exception {
	public DuplicateStudentException(String message) {
        super(message);
    }

}
