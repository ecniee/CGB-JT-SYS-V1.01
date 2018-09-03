package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
/***
 * 业务层对象:
 * 1)核心业务的处理
 * 2)扩展业务的处理(日志处理,事务处理,....)
 */
public interface SysConfigService {
	

	/***
	 * 保存配置信息
	 * @param entity
	 * @return 保存数据的行数
	 */
	int saveObject(SysConfig entity);
	
	/**
	 * 基于id执行删除操作
	 * @param ids 空值层传递的要删除的数据id
	 * @return 删除的记录行数
	 */
	int deleteObjects(Integer... ids);
	 /**
	  * 基于提交执行分页查询操作
	  * @param name 查询时参数名
	  * @param pageCurrent 当前页码值
	  * @return
	  */
	 PageObject<SysConfig> 
	 findPageObjects(String name,
			 Integer pageCurrent);
}



