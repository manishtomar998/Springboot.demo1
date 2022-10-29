package com.manish.demo1.entities;

public class Notfound {

	public String error;

	@Override
	public String toString() {
		return "Notfound [error=" + error + "]";
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Notfound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notfound(String error) {
		super();
		this.error = error;
	}
}
