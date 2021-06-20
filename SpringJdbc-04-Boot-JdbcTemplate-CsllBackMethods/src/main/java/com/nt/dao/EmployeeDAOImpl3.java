package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("dao")
//@Primary
public class EmployeeDAOImpl3 implements IEmployeeDAO {
	private static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESG = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	@Override
	public EmployeeBO getEmployeeByNo(int eno) {
		EmployeeBO ebo=jt.queryForObject(GET_EMP_BY_ENO, 
																			new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)
																					,eno);
		return ebo;
	}
	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		BeanPropertyRowMapper<EmployeeBO> rowmapper= new  BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		List<EmployeeBO> listbo=jt.query(GET_EMP_BY_DESG, new RowMapperResultSetExtractor<EmployeeBO>(rowmapper), desg1,desg2,desg3);
		return listbo;
	}
	
	
}
