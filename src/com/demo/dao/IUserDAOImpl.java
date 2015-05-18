package com.demo.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.User;

@Repository
public class IUserDAOImpl extends BaseDAO implements IUserDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User findUserByUsrName(String usrName) {
		String strSQL = "select userid usrId,username usrName,password usrPwd from t_users where userid='"
				+ usrName + "'";
		// return this.getJdbcTemplate().queryForObject(strSQL,
		// new ParameterizedRowMapper<User>() {
		// @Override
		// public User mapRow(ResultSet rs, int rowNum)
		// throws SQLException {
		// User user = new User();
		// user.setUsrId(rs.getString("userid"));
		// user.setUsrName(rs.getString("username"));
		// user.setUsrPwd(rs.getString("password"));
		// return user;
		// }
		// });

		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(User.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<User> findAllUsers() {
		String strSQL = "select userid usrId,username usrName,password usrPwd from t_users";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(User.class));
	}

}
