package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Ck;

@Repository
public class ICkDAOImpl extends BaseDAO implements ICkDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Ck findByPK(String ckdm) {
		String strSQL = "select ckdm,ckmc from t_ck where ckdm='"
				+ ckdm + "'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(Ck.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new Ck();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Ck> findAllCk() {
		String strSQL = "select ckdm,ckmc from t_ck";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Ck.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Ck> findCkByCkdm(String ckdm) {
		String strSQL = "select ckdm,ckmc from t_ck where ckdm like '%"
				+ ckdm + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Ck.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Ck> findCkByCkmc(String ckmc) {
		String strSQL = "select ckdm,ckmc from t_ck where ckdm like '%"
				+ ckmc + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Ck.class));
	}
	
	/**
	 * 根据主键删除数据
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delByPK(String ckdm) {
		String strSql = "delete from t_ck where ckdm='"+ckdm+"'";
		System.out.println("del-sql=="+strSql);
		try{
			this.getJdbcTemplate().update(strSql);
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
	
	/**
	 * 新增数据
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String insByPK(Ck ck) {
		StringBuffer str = new StringBuffer();
		str.append("insert into t_ck (ckdm,ckmc)  VALUES(");
		str.append("'"+ck.getCkdm()+"',");
		str.append("'"+ck.getCkmc()+"'");
		str.append(")");
		System.out.println("ins-sql=="+str.toString());
		try{
			this.getJdbcTemplate().update(str.toString());
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}	
		return "Y";
	}
	
	/**
	 * 根据主键保存数据
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String updByPK(Ck ck) {
		StringBuffer str = new StringBuffer();
		str.append("update t_ck set ");	
		str.append(" ckmc='"+ck.getCkmc()+"'");
		str.append(" where ckdm='"+ck.getCkdm()+"'");
		System.out.println("upd-sql=="+str.toString());
		try{
			this.getJdbcTemplate().update(str.toString());
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
}
