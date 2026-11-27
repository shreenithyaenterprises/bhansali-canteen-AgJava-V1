package com.abc.exceptionHandler;

public class ServiceException extends Exception 
{

	private static final long serialVersionUID = -470180507998010368L;

	public ServiceException() {
		super();
	}

	public ServiceException(final String message) {
		super(message);
	}
}
