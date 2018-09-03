package com.jt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Controller
@RequestMapping("/config/")
public class SysConfigController {
	 @Autowired
	 private SysConfigService sysConfigService;
	 @RequestMapping("doConfigListUI")
     public String doConfigListUI(){
    	 return "sys/config_list";
     }
	 @RequestMapping("doConfigEditUI")
	 public String doConfigEditUI(){
		 return "sys/config_edit";
	 }
	 
	 @RequestMapping("doSaveObject")
	 @ResponseBody
	 public JsonResult doSaveObject(
			 SysConfig entity){
		  sysConfigService.saveObject(entity);
		  return new JsonResult("save ok");//state=1,message=save ok
	 }
	 @RequestMapping("doDeleteObjects")
	 @ResponseBody
	 public JsonResult doDeleteObjects(
			 Integer... ids){//5,6
		 sysConfigService.deleteObjects(ids);
		 return new JsonResult("delete ok");
	 }
	 /**
	  * 当方法上使用了@ResponseBody注解时底层
	  * 系统会调用HttpMessageConverter对象的
	  * 相关方法(例如write方法),将方法返回值
	  * 以指定形式进行输出.例如假如是字符串则直接
	  * 将字符串写到客户端,假如是一个对象,此时会
	  * 将对象转换为json串然后写到客户端.
	  * 
	  * FAQ?
	  * 1)谁将控制层方法返回的对象转换为json串?
	  * HttpMessageConverter接口的实现类对象,
	  * 例如jackson,fastjson,gson
	  * 2)底层将对象转化为json时是如何获取对象
	  * 内部数据的?
	  * 3)当方法上没有写responsebody时底层会
	  * 将返回值封装为ModelAndView对象,默认
	  * 指定的view为url
	  * 4)请求中参数是如何绑定到方法的参数上的
	  * SpringMVC 底层调用DataBinder对象中的
	  * 相关方法进行实现.
	  * 
	  * a)javabean:调用getXXXX方法
	  * b)map:调用get(key)方法
	  */
	 @RequestMapping("doFindPageObjects")
	 @ResponseBody
	 public JsonResult doFindPageObjects(
			 String name,//page-current
			@RequestParam(required=true)
			Integer pageCurrent){
		    System.out.println("name="+name);
		    PageObject<SysConfig> pageObject=
		    sysConfigService.findPageObjects(
			name, pageCurrent);
		 return new JsonResult(pageObject);
	 }
	 
}
