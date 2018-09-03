package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {
	/**
	 * 基于角色ID查找菜单id
	 * @param roleId
	 * @return
	 */
	List<Integer> findMenuIdsByRoleId(
			Integer roleId);
	
	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
    /**
     * 基于菜单id删除角色和菜单关系表中对应的记录
     * @param menuId
     * @return
     */
	int deleteObjectsByMenuId(Integer menuId);
	int deleteObjectsByRoleId(Integer roleId);
}
