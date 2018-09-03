package com.jt.sys.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
	private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    
    @Override
    public int updateObject(SysRole entity, Integer[] menuIds) {
    	//1.验证合法性
    	if(entity==null)
    	throw new IllegalArgumentException("更新对象不能为空");
    	//...
    	if(menuIds==null||menuIds.length==0)
    	throw new IllegalArgumentException("必须为角色指定权限");
    	//2.更新数据
    	//2.1 更新自身信息
    	entity.setModifiedTime(new Date());
    	int rows=sysRoleDao.updateObject(entity);
    	if(rows==0)
    	throw new ServiceException("此记录可能已经不存在");
    	//2.2 基于角色id删除角色与菜单的关系数据
    	sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
    	//2.3 重新插入新的关系数据.
    	sysRoleMenuDao.insertObject(entity.getId(),
    			menuIds);
    	//3.返回结果
    	return rows;
    }
    
    
    
    @Override
    public Map<String, Object> findObjectById(Integer id) {
    	//1.验证参数的合法性
    	if(id==null||id<1)
    	throw new IllegalArgumentException("参数id的值不合法");
    	//2.基于id执行查询操作
    	SysRole sysRole=sysRoleDao.findObjectById(id);
    	if(sysRole==null)
    	throw new ServiceException("此对象可能已经不存在");
    	List<Integer> menuIds=
    	sysRoleMenuDao.findMenuIdsByRoleId(id);
    	//3.封装查询结果并返回
    	Map<String,Object> map=new HashMap<>();
    	map.put("role", sysRole);
    	map.put("menuIds", menuIds);
    	return map;
    }
    @Override
    public int saveObject(SysRole entity,
    		Integer[] menuIds) {
    	//1.参数有效性验证
    	if(entity==null)
    	throw new IllegalArgumentException("保存对象不能为空");
    	//....
    	if(menuIds==null||menuIds.length==0)
    	throw new IllegalArgumentException("必须为角色赋于权限");
    	//2.保存数据
    	Date date=new Date();
    	entity.setCreatedTime(date);
    	entity.setModifiedTime(date);
    	entity.setCreatedUser("admin");
    	entity.setModifiedUser("admin");
    	int rows=sysRoleDao.insertObject(entity);
    	sysRoleMenuDao.insertObject(
    			entity.getId(),//mybatis映射文件必须配置
    			menuIds);
    	//3.返回结果
    	return rows;
    }
    
    
    
    @Override
    public int deleteObject(Integer id) {
    	//1.参数合法性校验
    	if(id==null||id<1)
    	throw new IllegalArgumentException("参数id值无效");
    	//2.基于id执行删除操作
    	int rows=sysRoleDao.deleteObject(id);
    	if(rows==0)
    	throw new ServiceException("此记录可能已经不存在");
    	sysRoleMenuDao.deleteObjectsByRoleId(id);
    	sysUserRoleDao.deleteObjectsByRoleId(id);
    	//4.返回结果
    	return rows;
    }
    
	@Override
	public PageObject<SysRole> findPageObjects(
			String name, Integer pageCurrent) {
		//1.参数有效性验证
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码值无效");
		//2.基于条件查询总记录数
		int rowCount=sysRoleDao.getRowCount(name);
		//3.对总记录数进行验证
		if(rowCount==0)
		throw new ServiceException("没有查询到对应的记录");
		//4.基于条件查询当前页记录
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
		sysRoleDao.findPageObjects(name,
				startIndex, pageSize);
		//5.封装查询结果
		PageObject<SysRole> po=new PageObject<SysRole>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		//6.返回结果
		return po;
	}

}
