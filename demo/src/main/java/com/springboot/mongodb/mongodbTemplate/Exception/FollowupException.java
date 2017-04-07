package com.springboot.mongodb.mongodbTemplate.Exception;

/**
 * 系统业务错误，code为错误编号，message为错误信息。
 * 
 * @author WangWei
 */
@SuppressWarnings("serial")
public class FollowupException extends RuntimeException{
	private static final int DEFAULT_CODE = 1001;
	private int code;
	
	public FollowupException(String message){
		this(DEFAULT_CODE, message);
	}
	
	public FollowupException(int code, String message){
		super(message);
		this.code = code;
	}
	
	public int getCode(){
		return code;
	}

	@Override
	public String toString() {
		return "FollowupException [code=" + code + ", getMessage()=" + getMessage() + "]";
	}
}
