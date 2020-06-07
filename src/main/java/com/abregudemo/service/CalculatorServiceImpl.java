package com.abregudemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	@Override
	public int sum(List<Integer> numeros) {
		Integer suma = 0;
		for (Integer elemento: numeros) {
			suma += elemento;
		}
		return suma;
	}

	@Override
	public int sub(List<Integer> numeros) {
		Integer resta = 0;
		int i = 0;
		for (Integer elemento: numeros) {
			if(i==0) {
				resta = elemento;
			}
			i++;
			resta -= elemento;
		}
		return resta;
	}

	@Override
	public int mul(List<Integer> numeros) {
		Integer multiplicacion = 1;
		for (Integer elemento: numeros) {
			multiplicacion *= elemento;
		}
		return multiplicacion;
	}

}
