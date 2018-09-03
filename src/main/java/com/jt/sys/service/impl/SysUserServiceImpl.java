package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.SysUserDeptResult;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
	private SysUserDao sysUserDao;
    
    @Override
    public int validById(Integer id,
    		Byte valid) {
    	if(id==null||id<1)
    	throw new IllegalArgumentException("id值无效");
    	if(valid==null||(valid!=1&&valid!=0))
    	throw new IllegalArgumentException("状态值无效");
    	int rows=sysUserDao.validById(id, valid);
    	if(rows==0)
    	throw new ServiceException("记录可能已经不存在");
    	return rows;
    }
	@Override
	public PageObject<SysUserDeptResult> 
	findPageObjects(String username, 
			Integer pageCurrent) {
		//1.合法验证
	    if(pageCurrent==null||pageCurrent<1)
	    throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数
	    int rowCount=sysUserDao.getRowCount(username);
		//3.对记录数进行验证
	    if(rowCount==0)
	    throw new ServiceException("没有记录");
		//4.查询当前页数据
	    int pageSize=5;
	    int startIndex=(pageCurrent-1)*pageSize;
	    List<SysUserDeptResult> records=
	    sysUserDao.findPageObjects(username,
	    		startIndex, pageSize);
		//5.对数据进行封装
	    PageObject<SysUserDeptResult> po=new PageObject<>();
	    po.setRowCount(rowCount);
	    po.setRecords(records);
	    po.setPageSize(pageSize);
	    po.setPageCurrent(pageCurrent);
		//6.返回结果
		return po;
	}

}





