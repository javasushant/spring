package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	@Override
	public List<EmployeeBO> getEmployeeDesg(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeBO> listBO = null;
		try(Connection con=ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPS_DESG)){
			//set value toquery param 
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			//execute Query and get ResultSet obj
			try(ResultSet rs = ps.executeQuery()){
				//convert ResultSet obj records to listBO
				listBO = new ArrayList();
				while(rs.next()) {
					EmployeeBO bo= new EmployeeBO();
					bo.setEmpNo(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getFloat(4));
					bo.setDeptNo(rs.getInt(5));
					listBO.add(bo);
				}//while
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // Exception rethrowing for exception propagation
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;   // Exception rethrowing for exception propagation
		}
		return listBO;
	}

}
