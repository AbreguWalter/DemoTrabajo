package com.abregudemo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abregudemo.model.OperationResult;
import com.abregudemo.model.Operation;
import com.abregudemo.service.CalculatorService;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculatorController {

	List<Operation> operations = new ArrayList<>();
    
    public CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}


	@PostMapping("/**")
    public ResponseEntity<OperationResult> calculate(HttpServletRequest request) {
		
        System.out.println("URL: " + request.getRequestURI());

        String[] pathVariables = request.getRequestURI().split("/");
        
        List<Integer> listaNumeros = new ArrayList<>();
        
        String operation = "";
        Integer resultado = 0;
        
        for (int i = 1; i < pathVariables.length; i++) {
        	if(i==1) {
        		operation = pathVariables[i];
        	}else {
        		listaNumeros.add(Integer.parseInt(pathVariables[i]));
        	}	 
		}
        
        switch (operation) {
			case "sum":
				resultado = calculatorService.sum(listaNumeros);
				break;
			case "sub":
				resultado = calculatorService.sub(listaNumeros);
				break;
			case "mul":
				resultado = calculatorService.mul(listaNumeros);
				break;
			default:
				break;
		}
        
        operations.add(new Operation(resultado,operation,listaNumeros));
        
        return new ResponseEntity<>(new OperationResult(resultado), HttpStatus.OK);
    }


    @GetMapping("/history")
    public ResponseEntity<List<Operation>> history() {
    	
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

}
