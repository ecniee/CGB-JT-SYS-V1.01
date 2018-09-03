package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.SysUserDeptResult;

public interface SysUserDao {
	  /**
	   * 禁用或启用状态信息
	   * @param id
	   * @param valid
	   * @return
	   */
	  int validById(@Param("id")Integer id,
			  @Param("valid")Byte valid);
	  /**
	   * 查询当前页数据
	   * 1)用户信息
	   * 2)部门信息
	   * 一行记录封装为一个SysUserDeptResult对象
	   * @param name
	   * @param startIndex
	   * @param pageSize
	   * @return
	   */
	  List<SysUserDeptResult> 
	  findPageObjects(
			  @Param("username")String username,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
      /**
       * 基于条件统计记录行数
       * @param name
       * @return
       */
	  int getRowCount(@Param("username")String username);
}







