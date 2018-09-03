package com.jt.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.jt.sys.entity.SysRole;
public interface SysRoleDao {
	
	/**
	 * 基于id更新角色信息
	 */
	int updateObject(SysRole entity);
	
	 /**
	  * 基于角色Id查找角色信息
	  * @param id
	  * @return
	  */
	 SysRole findObjectById(Integer id);
	
	 /**
	  * 将角色信息保存到数据库
	  * @param entity
	  * @return
	  */
	 int insertObject(SysRole entity);
	 
	 /**
	  * 基于角色Id删除角色自身信息
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 List<SysRole> findPageObjects(
			 @Param("name")String name,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
    
	 int getRowCount(@Param("name")String name);
}
