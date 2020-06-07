package com.abregudemo.model;

import java.util.ArrayList;
import java.util.List;

public class Operation {
	
	Integer resultado;
	String operacion;
	List<Integer> params = new ArrayList<>();
	
	public Integer getResult() {
		return resultado;
	}
	public void setResult(Integer resultado) {
		this.resultado = resultado;
	}
	public String getOperation() {
		return operacion;
	}
	public void setOperation(String operacion) {
		this.operacion = operacion;
	}
	public List<Integer> getParams() {
		return params;
	}
	public void setParams(List<Integer> params) {
		this.params = params;
	}
	public Operation(Integer resultado, String operacion, List<Integer> params) {
		this.resultado = resultado;
		this.operacion = operacion;
		this.params = params;
	}
}
