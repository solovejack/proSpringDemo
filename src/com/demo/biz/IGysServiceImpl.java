package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IGysDAO;
import com.demo.dao.entity.Gys;

@Service
public class IGysServiceImpl implements IGysService {
	@Autowired
	private IGysDAO gysDAO;

	@Override
	public Gys findByPK(String gysdm){
        return gysDAO.findByPK(gysdm);
	}

	@Override
	public Collection<Gys> findAllGys() {
		// TODO 自动生成的方法存根
		return gysDAO.findAllGys();
	}

	@Override
	public Collection<Gys> findGysByGysmc(String gysmc) {
		// TODO 自动生成的方法存根
		return gysDAO.findGysByGysmc(gysmc);
	}
}
