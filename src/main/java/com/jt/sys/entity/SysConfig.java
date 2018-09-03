package com.jt.sys.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**借助此对象封装配置信息
 * 1)属性与sys_configs表中字段对应
 * 2)实现序列化接口并添加序列化ID
 * 3)添加set/get/toString方法
 */
public class SysConfig implements Serializable{
	 private static final long serialVersionUID = -4540155590976156840L;
	 private Integer id;
	 private String name;
	 private String value;
	 private String note;
	 private Date createdTime;
	 private Date modifiedTime;
	 private String createdUser;
	 private String modifiedUser;
	 public Integer getId() {
		return id;
	 }
	 public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "SysConfig [id=" + id + ", name=" + name + ", value=" + value + ", note=" + note + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser="
				+ modifiedUser + "]";
	}
	 
	 
}
