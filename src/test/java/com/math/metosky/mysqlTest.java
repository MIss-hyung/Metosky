package com.math.metosky;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class mysqlTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://metosky-maths.cvxuxlmm4a7b.ap-northeast-2.rds.amazonaws.com:3306/metosky_db";
	private static final String USER = "Metosky";
	private static final String PW = "metosky1!";

	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("성공");
			System.out.println(con);
		}catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
	}

}
