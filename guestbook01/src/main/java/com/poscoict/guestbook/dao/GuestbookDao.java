package com.poscoict.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.guestbook.vo.GuestbookVo;

public class GuestbookDao {

	public List<GuestbookVo> findAll(){
		Connection conn = null;
		List<GuestbookVo> result = new ArrayList<GuestbookVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();//sqlexception
			String sql = "select no, name, message, reg_date from guestbook order by no desc";
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String message = rs.getString(3);
				String reg_date = rs.getString(4);
				
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setMessage(message);
				vo.setReg_date(reg_date);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error : "+ e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			System.out.println("mysql 연결성공");
		}
		return result;
	}
	
	// insert
	public boolean insert(GuestbookVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(null, ?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			result = pstmt.executeUpdate() == 1;
			
		}catch(SQLException e) {
			System.out.println("error : "+ e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("mysql 연결성공");
		}
		return result;
	}
	
	//delete
	public boolean delete(GuestbookVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from guestbook where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getNo());
			
			result = pstmt.executeUpdate() == 1;
			
		}catch(SQLException e) {
			System.out.println("error: "+ e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println(" mysql 연결성공");
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");//classnotfound
			//2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");//sqlexception
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+ e);
		}
		return conn;
	}
}
