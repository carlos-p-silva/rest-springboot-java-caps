package com.caps.restspringbootjavacaps.service;

import org.springframework.stereotype.Service;

import com.caps.restspringbootjavacaps.exceptions.UnsupportedMathOperationException;
import com.caps.restspringbootjavacaps.utils.NumberUtils;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Double sum(String numberOne, String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico!");
		}
		return NumberUtils.convert(numberOne) + NumberUtils.convert(numberTwo);
	}

	@Override
	public Double subtraction(String numberOne, String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico");
		}
		return NumberUtils.convert(numberOne) - NumberUtils.convert(numberTwo);
	}

	@Override
	public Double multiplication(String numberOne, String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico");
		}
		return NumberUtils.convert(numberOne) * NumberUtils.convert(numberTwo);
	}

	@Override
	public Double division(String numberOne, String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico");
		}
		return NumberUtils.convert(numberOne) / NumberUtils.convert(numberTwo);
	}

	@Override
	public Double average(String numberOne, String numberTwo) {
		if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico");
		}
		return (NumberUtils.convert(numberOne) + NumberUtils.convert(numberTwo)) / 2;
	}

	@Override
	public Double square(String number) {
		if (!NumberUtils.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico");
		}
		return Math.sqrt(NumberUtils.convert(number));
	}

}
