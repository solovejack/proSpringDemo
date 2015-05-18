package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Hw;
import com.demo.dao.entity.HwExt;

@Repository
public class IHwDAOImpl extends BaseDAO implements IHwDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HwExt findByPK(String hwdm) {
		String strSQL = "select t1.*,t2.ckmc ckmc from t_hw t1 left join t_ck t2 on t1.ckdm=t2.ckdm where hwdm='"
				+ hwdm + "'";
		try {
		       System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(HwExt.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new HwExt();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<HwExt> findAllList() {
		String strSQL = "select t1.*,t2.ckmc ckmc from t_hw t1 left join t_ck t2 on t1.ckdm=t2.ckdm";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(HwExt.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<HwExt> findListByPk(String hwdm) {
		String strSQL = "select t1.*,t2.ckmc ckmc from t_hw t1 left join t_ck t2 on t1.ckdm=t2.ckdm where hwdm like '%"
				+ hwdm + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(HwExt.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<HwExt> findListByHwmc(String hwmc) {
		String strSQL = "select t1.*,t2.ckmc ckmc from t_hw t1 left join t_ck t2 on t1.ckdm=t2.ckdm where hwmc like '%"
				+ hwmc + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(HwExt.class));
	}
	
	/**
	 * 根据主键删除数据
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delByPK(String hwdm) {
		String strSql = "delete from t_hw where hwdm='"+hwdm+"'";
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
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String insByPK(Hw hw) {
		StringBuffer str = new StringBuffer();
		str.append("insert into t_hw (hwdm,hwmc,ckdm)  VALUES(");
		str.append("'"+hw.getHwdm()+"',");
		str.append("'"+hw.getHwmc()+"',");
		str.append("'"+hw.getCkdm()+"'");
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
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String updByPK(Hw hw) {
		StringBuffer str = new StringBuffer();
		str.append("update t_hw set ");	
		str.append(" hwmc='"+hw.getHwmc()+"',");
		str.append(" ckdm='"+hw.getCkdm()+"'");
		str.append(" where hwdm='"+hw.getHwdm()+"'");
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
