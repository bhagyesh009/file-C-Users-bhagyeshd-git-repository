package com.bitwise.data;

public class Output {
	
	private int data;
	@Override
	public String toString() {
		return "Ouput [data=" + data + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Output(int data, int errorCode, String errorMessage) {
		super();
		this.data = data;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	private int errorCode;
	private String errorMessage;
	
	
}
