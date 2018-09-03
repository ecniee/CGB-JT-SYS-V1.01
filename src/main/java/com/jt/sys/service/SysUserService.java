package com.jt.sys.service;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.SysUserDeptResult;

public interface SysUserService {
	  /**
	   * 禁用或启用状态信息
	   * @param id
	   * @param valid
	   * @return
	   */
	  int validById(Integer id,Byte valid);
      /**
       * 基于条件执行分页查询操作
       * @param name
       * @param pageCurrent
       * @return
       */
	  PageObject<SysUserDeptResult>
	  findPageObjects(String username,
			  Integer pageCurrent);
}




