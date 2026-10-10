package com.hospital.hospital_management.exception;

public class PatientNotFoundException extends RuntimeException{
	public PatientNotFoundException(String messege) {
		super(messege);
	}

}
