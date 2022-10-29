package com.manish.demo1.entities;

public class Errors {

	public Errors(String error) {
		super();
		this.error = error;
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Errors() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Errors [error=" + error + "]";
	}
}
