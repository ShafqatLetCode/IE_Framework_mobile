package com.crestech.common.utilities;


public class HandleException extends Exception {
    private String code;

    public HandleException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public HandleException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public void throwHandleException(String code, String message, HandleException e) throws HandleException
    {
    	//System.out.println("Inside throwhandleexception kywprd");
		if(e.getCode()==null)
		{
			throw new HandleException(code, message,e);
		}
		else
		{
			throw new HandleException(e.getCode(), e.getMessage(),e.getCause());
			
		}
    }
    public void throwException(String code, String message, Exception e) throws HandleException
    {
    	//System.out.println("Inside throwexception keyword");
		throw new HandleException(code, message,e);
    }
    
}
