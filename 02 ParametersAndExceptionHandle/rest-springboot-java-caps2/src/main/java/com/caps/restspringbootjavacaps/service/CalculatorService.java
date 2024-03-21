package com.caps.restspringbootjavacaps.service;

public interface CalculatorService {
	
	Double sum(String numberOne, String numberTwo);
	Double subtraction(String numberOne, String numberTwo);
	Double multiplication(String numberOne, String numberTwo);
	Double division(String numberOne, String numberTwo);
	Double average(String numberOne, String numberTwo);
	Double square(String number);

}
