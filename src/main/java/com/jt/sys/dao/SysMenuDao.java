package com.jt.sys.dao;
import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
public interface SysMenuDao {
	/**
	 * 基于条件更新菜单信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	/**
	 * 将菜单对象持久化到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	/**
	 * 查询菜单的树节点信息
	 * 1)id
	 * 2)parentId
	 * 3)name
	 * 一个Node对象对应一行记录
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	/***
	 * 基于菜单id统计子菜单的个数
	 * @param id 当前菜单id
	 * @return
	 */
	int getChildCount(Integer id);
	
	/**
	 * 基于菜单id执行删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	
	
	/**
	 * 查询菜单以及上一级菜单信息
	 * 一个map: 封装一行记录
	 * 1)key:为字段名或列别名
	 * 2)value: 对应表中字段对应的值.
	 * @return
	 */
	List<Map<String,Object>> findObjects();
}
