package com.jt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.SysUserDeptResult;
import com.jt.sys.service.SysUserService;
@RequestMapping("/user/")
@Controller
public class SysUserController {
	   @Autowired
	   private SysUserService sysUserService;
       @RequestMapping("doUserListUI")
	   public String doUserListUI(){
		   return "sys/user_list";
	   }
       @RequestMapping("doUserEditUI")
       public String doUserEditUI(){
    	   return "sys/user_edit";
       }
       @RequestMapping("doValidById")
       @ResponseBody
       public JsonResult doValidById(
    		   Integer id,Byte valid){
    	   sysUserService.validById(id,
    			   valid);
    	   return new JsonResult("update ok");
       }
       @RequestMapping("doFindPageObjects")
       @ResponseBody
       public JsonResult doFindPageObjects(
    		   String username,Integer pageCurrent){
    	   PageObject<SysUserDeptResult>
    	   pageObject=sysUserService.findPageObjects(username,
    					   pageCurrent);
    	   return new JsonResult(pageObject);
       }
}




