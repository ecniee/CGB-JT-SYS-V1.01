package com.jt.common.vo;

import java.io.Serializable;
/**主要用户封装控制层数据*/
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 583312263212167841L;
	private static final int SUCCESS=1;
    private static final int ERROR=0;
	/**状态码*/
    private int state=SUCCESS;//1表示OK,0表示Error
	/**状态码对应的消息*/
    private String message="OK";
	/**具体数据(当前系统此名字规定必须使用data)*/
    private Object data;
    public JsonResult(){}
	public JsonResult(String message) {
	    this.message=message;
	}
	public JsonResult(Object data){
		this.data=data;
	}
	public JsonResult(Throwable e){
		this.state=ERROR;
		this.message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
