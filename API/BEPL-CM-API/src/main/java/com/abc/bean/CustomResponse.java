package com.abc.bean;

public class CustomResponse 
{
	  private String message;
	  private Object status;

	  public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getStatus() {
		return status;
	}
	public void setStatus(Object status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CustomResponse [message=" + message + ", status=" + status + "]";
	}	  
	  
}
