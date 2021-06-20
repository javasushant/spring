package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;
@Repository("custDAOMysql")
@Profile({"dev","test"})

public class StudentDAOImplMySql implements IStudentDAO {
	
	private static final String INSERT_QUERY="INSERT INTO STUDENT_INFO(NAME,ADDRS,GAIN,TOTAL,RESULT) VALUES(?,?,?,?,?)";
	
	@Autowired
	
	private DataSource ds;
	
	@Override
	public int insert(StudentBO bo) throws Exception {
		//establish a connection
		Connection con = ds.getConnection();
		//preparedStatement
		PreparedStatement ps= con.prepareStatement(INSERT_QUERY);
		//SET VALUE PARAM
		ps.setString(1, bo.getName());
		ps.setString(2, bo.getAddrs());
		ps.setInt(3, bo.getGain());
		ps.setFloat(4, bo.getTotal()); 
		ps.setString(5, bo.getResult());
		
//		System.out.println(bo.getName()+"  "+bo.getAddrs());
		//execute the query
		int count = ps.executeUpdate();
		//close the jdbc
		ps.close();
		con.close();
		
		return count;
	}

}
