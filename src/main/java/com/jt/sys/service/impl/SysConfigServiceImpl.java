package com.jt.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Service
public class SysConfigServiceImpl 
      implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	
	@Override
	public int saveObject(SysConfig entity) {
		//1.对参数进行合法校验
		if(entity==null)
		throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new IllegalArgumentException("保存参数不能为空");
		//2.保存对象到数据库
		int rows=sysConfigDao.insertObject(entity);
		//3.对结果进行验证
		if(rows!=1)
		throw new ServiceException("save error");
		//4.返回结果
		return rows;
	}
	
	@Override
	public int deleteObjects(Integer... ids) {
		//1.对参数进行合法校验
		if(ids==null||ids.length==0)
		throw new IllegalArgumentException("请选择删除的元素");
		//2.执行删除操作
	    int rows=sysConfigDao.deleteObjectById(ids);
		//3.判定删除结果
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//4.返回数据
		return rows;
	}
	
	@Override
	public PageObject<SysConfig> 
	findPageObjects(String name,Integer pageCurrent) {
		//1.对参数进行合法验证
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确,pageCurrent="+pageCurrent);
		//2.基于条件查询总记录数
		int rowCount=sysConfigDao.getRowCount(name);
		//3.对查询总记录数的结果进行校验
		if(rowCount==0)
		throw new ServiceException("没有查询到记录");
		//4.依据条件查询当前页数据
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysConfig> records=
		sysConfigDao.findPageObjects(
				name!=null?name.trim():name,
				startIndex, pageSize);
		System.out.println(records);
		//5.封装数据(两次查询结果)
		PageObject<SysConfig> po=new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		//6.返回数据
		return po;
	}

}




