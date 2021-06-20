package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository("daoClass")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String  GET_EMP_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	private static final String  INSERT_EMP_BY="UPDATE EMP  SET ENAME=? WHERE EMPNO=? ";
	
	
	
	private EmployeeSelector1 selector1;
	private EmployeeSelector2 selector2;
	private EmployeeSelector3 selector3;
	
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		selector1=new EmployeeSelector1(ds,GET_EMP_BY_ID);
		selector2=new EmployeeSelector2(ds,GET_EMP_BY_DESG);
		selector3=new EmployeeSelector3(ds,INSERT_EMP_BY);
	}
	@Override
	public Employee getPoliticalPartyDetailsByPartyId(int eno) {
		Employee emp=selector1.findObject(eno);
		return emp;
	}
	
	private static class EmployeeSelector1 extends MappingSqlQuery<Employee>{
		
		public EmployeeSelector1(DataSource ds, String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
		@Override
		protected Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			//copy Rs Object to model classobj
			Employee emp=new Employee();
			emp.setEmpno(rs.getInt(1));emp.setEname(rs.getString(2));emp.setJob(rs.getString(3));
			emp.setSal(rs.getFloat(4));
			return emp;
		}
		
	}//inner class

	@Override
	public List<Employee> getPoliticalPartiesByPartyNames(String job1, String job2, String job3) {
		List<Employee> list =selector2.execute(job1,job2,job3);
		return list;
	}
	
private static class EmployeeSelector2 extends MappingSqlQuery<Employee>{
		
		public EmployeeSelector2(DataSource ds, String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}
		@Override
		protected Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			//copy Rs Object to model classobj
			Employee emp=new Employee();
			emp.setEmpno(rs.getInt(1));emp.setEname(rs.getString(2));emp.setJob(rs.getString(3));
			emp.setSal(rs.getFloat(4));
			return emp;
		}
		
	}//inner class

@Override
public int updateEmployee(String ename,int empno) {
	int result=selector3.update(ename, empno);
	return result;
}
	private static class EmployeeSelector3 extends SqlUpdate{
		public EmployeeSelector3(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
	}//inner class
}
