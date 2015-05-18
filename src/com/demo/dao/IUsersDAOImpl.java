package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Users;

@Repository
public class IUsersDAOImpl extends BaseDAO implements IUsersDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Users> findAllUsers() {
		String strSQL = "select userId,dwdm,dwmc,userName,jl,lxdh,ckdm,ckmc,sex,bzdm,bzmc from t_users";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Users.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Users findByPK(String userId) {
		String strSQL = "select * from t_users where userid='"
				+ userId + "'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(Users.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new Users();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Users> findUsersByUserId(String userId) {
		String strSQL = "select userId,dwdm,dwmc,userName,jl,lxdh,ckdm,ckmc,sex,bzdm,bzmc from t_users where userid like '%"
				+ userId + "%'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Users.class));
	}
	
	/**
	 * 根据主键删除数据
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delByPK(String userId) {
		String strSql = "delete from t_users where userId='"+userId+"'";
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
	public String insByPK(Users user) {
		StringBuffer str = new StringBuffer();
		str.append("insert into t_users (userId,dwdm,dwmc,userName,jl,lxdh,ckdm,ckmc,bzdm,bzmc,sex)  VALUES(");
		str.append("'"+user.getUserId()+"',");
		str.append("'"+user.getDwdm()+"',");
		str.append("'"+user.getDwmc()+"',");
		str.append("'"+user.getUserName()+"',");
		str.append("'"+user.getJl()+"',");
		str.append("'"+user.getLxdh()+"',");
		str.append("'"+user.getCkdm()+"',");
		str.append("'"+user.getCkmc()+"',");
		str.append("'"+user.getBzdm()+"',");
		str.append("'"+user.getBzmc()+"',");
		str.append("'"+user.getSex()+"'");
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
	public String updByPK(Users user) {
		StringBuffer str = new StringBuffer();
		str.append("update t_users set ");
		str.append(" dwdm='"+user.getDwdm()+"',");		
		str.append(" dwmc='"+user.getDwmc()+"',");
		str.append(" userName='"+user.getUserName()+"',");
		str.append(" jl='"+user.getJl()+"',");
		str.append(" lxdh='"+user.getLxdh()+"',");
		str.append(" ckdm='"+user.getCkdm()+"',");
		str.append(" ckmc='"+user.getCkmc()+"',");
		str.append(" sex='"+user.getSex()+"',");
		str.append(" bzdm='"+user.getBzdm()+"',");
		str.append(" bzmc='"+user.getBzmc()+"'");
		str.append(" where userId='"+user.getUserId()+"'");
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
