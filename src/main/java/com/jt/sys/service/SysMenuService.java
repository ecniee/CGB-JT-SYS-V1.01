package com.jt.sys.service;
import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
public interface SysMenuService {
	  /**
	   * 更新菜单信息
	   * @param entity
	   * @return
	   */
	  int updateObject(SysMenu entity);           
	   /**
	    * 保存新的菜单信息
	    * @param entity
	    * @return
	    */
	   int saveObject(SysMenu entity);           
	   
	   /**查询菜单节点节点信息*/
	   List<Node>  findZtreeMenuNodes();
       /**
        * 查询所有菜单信息以及上级菜单信息
        * @return
        */
	   List<Map<String,Object>>
	       findObjects();
	   /**
	    * 基于菜单id执行删除操作
	    * @param id
	    * @return
	    */
	   int deleteObject(Integer id);
}






