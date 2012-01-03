package com.lijiangt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * create database hashcode default character set utf8 default collate utf8_bin;
 * create table HASH_CODE(STR varchar(255) not null,HASH Integer not null) TYPE=innodb;
 * 
 * 
 * select c.HASH,count(1) from HASH_CODE c where LEFT(c.STR,1) not in ('+','/','?','%','#','&',' ') and RIGHT(c.STR,1) not in ('+','/','?','%','#','&',' ') group by c.HASH having count(1)>3;
 * select h.* from HASH_CODE h where h.HASH in (select c.HASH from HASH_CODE c where LEFT(c.STR,1) not in ('+','/','?','%','#','&',' ') and RIGHT(c.STR,1) not in ('+','/','?','%','#','&',' ') group by c.HASH having count(1)>3);
 * @author lijt
 *
 */
public class FindHashCodeStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 2;
		if(args.length==1){
			n = Integer.parseInt(args[0]);
		}
		new FindHashCodeStr().find(n);
	}

	private static List<String> composite(int n) {
		List<String> l = new ArrayList<String>();
		if (n == 1) {
			for (char i = 32; i < 127; i++) {
				l.add("" + i);
			}
			return l;
		} else {
			for (char i = 32; i < 127; i++) {
				for (String str : composite(n - 1)) {
					l.add(str + i);
				}
			}
			return l;
		}

	}

	private Connection conn;
	private PreparedStatement ps;

	public void find(int length) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/hashcode?useUnicode=true&characterEncoding=GBK";
			conn = DriverManager.getConnection(url, "root", "");
			String sql = "INSERT INTO HASH_CODE(STR, HASH) VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			for(String s:composite(length)){
				save(s,s.hashCode());
			}
//			for(String s:new String[]{"和平、发展、合作是时代的呼唤","我相信，只要各国人民戮力同心、同舟共济，我们一定能够战胜前进道路上的各种困难和风险，在推动建设持久和平、共同繁荣的和谐世界的征程上不断迈出新的步伐。"}){
//				save(s,s.hashCode());
//			}
			conn.close();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}

	}

	private void save(String str, int hash) throws SQLException {
		ps.setString(1, str);
		ps.setInt(2, hash);
		int result = ps.executeUpdate();
		if (result != 1) {
			System.err.println("Result: " + result);
		}
		ps.clearParameters();

	}
}
