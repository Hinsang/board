package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Dto;

public class Dao {
	
	private static Dao dao = new Dao();
	
	Connection con;	PreparedStatement ps;	ResultSet rs;
	public Dao() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			 con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board", 
					"root",
					"1234");
		}catch (Exception e) { System.out.println(e);}
	}
	
	public static Dao getInstance() { return dao;}
	
	//1. 회원가입 메소드 
	public boolean signup( Dto dto ) {
		String sql ="insert into"
				+ " board( btitle, bcontent,"
				+ "bid, bpw)"
				+ " values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getBtitle() );
			ps.setString( 2 , dto.getBcontent() );
			ps.setString( 3 , dto.getBid() );
			ps.setString( 4 , dto.getBpw() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false; 	
	} // 회원가입 end
	
	public ArrayList<Dto> boardlist() {
		ArrayList<Dto> list = new ArrayList<>();
		String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Dto dto = new Dto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), null,
						rs.getString(6), rs.getInt(7)
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public boolean delete( int bno, String bpw ) {
		String sql = "delete from board where bno = ? and bpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setString(2, bpw);
			int count = ps.executeUpdate(); // 삭제 레코드 수 반환
			if(count == 1) {
				return true;
				// 삭제된 레코드가 1개이면 성공
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public Dto getboard(int bno) {
		System.out.println(bno);
		String sql = "select * from board where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
							rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6),
							rs.getInt(7)
						);
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}



















