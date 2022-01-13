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

	public List<GuestbookVo> findAll() {
		List<GuestbookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();// sqlexception
			String sql = "select no, name, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, message from guestbook order by reg_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
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
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// delete
	public boolean delete(GuestbookVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from guestbook where no = ? and password =?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());

			// executeUpdate(C,U,D)는 숫자(갯수)로 반환해줌
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// insert
	public boolean insert(GuestbookVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(null, ?,?,?,now())";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");// classnotfound
			// 2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");// sqlexception
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}
}
