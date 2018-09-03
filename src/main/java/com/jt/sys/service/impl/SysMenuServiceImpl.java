package com.jt.sys.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.Node;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
	private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Override
    public int updateObject(SysMenu entity){
    	//1.合法验证
    	if(entity==null)
    	throw new IllegalArgumentException("保存对象不能为空");
    	if(StringUtils.isEmpty(entity.getName()))
        throw new IllegalArgumentException("名字不能为空");
    	//....
    	//2.更新数据
    	entity.setModifiedTime(new Date());
    	entity.setModifiedUser("admin");
    	int rows=sysMenuDao.updateObject(entity);
    	if(rows==0)
    	throw new ServiceException("记录可能已经不存在了");
    	//3.返回结果
    	return rows;
    }
    @Override
    public int saveObject(SysMenu entity) {
    	//1.合法验证
    	if(entity==null)
    	throw new IllegalArgumentException("保存对象不能为空");
    	if(StringUtils.isEmpty(entity.getName()))
    	throw new IllegalArgumentException("菜单名字不能为空");
    	//2.保存数据
    	Date date=new Date();
    	entity.setCreatedTime(date);
    	entity.setModifiedTime(date);
    	entity.setCreatedUser("admin");//系统登陆的用户
    	entity.setModifiedUser("admin");
    	int rows=sysMenuDao.insertObject(entity);
    	//3.返回结果
    	return rows;
    }
    
    @Override
    public List<Node> findZtreeMenuNodes() {
    	return sysMenuDao.findZtreeMenuNodes();
    }
    
    @Override
    public int deleteObject(Integer id) {
    	//1.参数合法性校验
    	if(id==null||id<1)
    	throw new IllegalArgumentException("id值不正确");
    	//2.基于菜单id统计子菜单,并进行验证
    	int count=sysMenuDao.getChildCount(id);
    	if(count>0)
    	throw new ServiceException("请先删除子菜单");
    	//3.删除当前菜单信息
    	int rows=sysMenuDao.deleteObject(id);
    	//4.删除角色菜单的关系数据
    	sysRoleMenuDao.deleteObjectsByMenuId(id);
    	//5.返回结果
    	return rows;
    }
	@Override
	public List<Map<String, Object>> 
	       findObjects() {
		return sysMenuDao.findObjects();
	}
}






