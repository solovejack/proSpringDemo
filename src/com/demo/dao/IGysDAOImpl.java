package com.demo.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Gys;

@Repository
public class IGysDAOImpl extends BaseDAO implements IGysDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Gys findByPK(String gysdm){
		String strSQL = "select gysdm,gysmc,fddb,lxr,lxdh,czhm,yzbm,email,www,qyxzdm,khyh,yhzh,swh,qymc,bz,dwdz from t_gys where gysdm='"+gysdm+"'";
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(Gys.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Gys> findAllGys(){
		String strSQL = "select gysdm,gysmc,fddb,lxr,lxdh,czhm,yzbm,email,www,qyxzdm,khyh,yhzh,swh,qymc,bz,dwdz from t_gys";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Gys.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Gys> findGysByGysmc(String gysmc){
		String strSQL = "select gysdm,gysmc,fddb,lxr,lxdh,czhm,yzbm,email,www,qyxzdm,khyh,yhzh,swh,qymc,bz,dwdz from t_gys where gysmc like '%"+gysmc+"%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Gys.class));
	}
}
