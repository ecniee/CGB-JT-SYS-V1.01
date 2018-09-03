package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigDao {
	/**
	 * 保存配置信息
	 * @param entity (封装了配置信息的实体对象)
	 * @return 插入数据的行数
	 * mybatis-->sqlsession-->Executor
	 */
	int insertObject(SysConfig entity);

	int deleteObjectById(
	@Param("ids")Integer... ids);
	
	/**
	 * 查询当前页数据
	 * @param name 查询操作时客户端输入的参数名
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页的页面大小
	 * @return 当前页查询到的数据
	 */
	List<SysConfig> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 依据条件统计记录总数
	 * @param name 查询操作时客户端输入的参数名
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
}



