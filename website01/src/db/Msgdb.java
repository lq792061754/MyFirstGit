package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Message;

public class Msgdb {
	public static void insertMsg(Message m) {
		String sql = "insert into messages(user,email,content,time) values('"+m.getUser()+"'"
				+ ",'"+m.getEmail()+"','"+m.getContent()+"','"+m.getTime()+"')";
		try {
			Mydb.getSmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<Message> getMsg(int p){
		List<Message> list = new ArrayList<Message>();
		String sql  = "select * from messages order by id desc limit "+p+",5";
		try {
			ResultSet rs = Mydb.getSmt().executeQuery(sql);
			while(rs.next()) {
				Message m = new Message();
				m.setUser(rs.getString("user"));
				m.setEmail(rs.getString("email"));
				m.setContent(rs.getString("content"));
				String str = rs.getString("time");
				m.setTime(str.substring(0,str.length()-2));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;	
	}
	public static int pageCount() {
		int count = 0;
		String sql="select count(*) from messages";
		try {
			ResultSet rs = Mydb.getSmt().executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static List<Message> getAllMsg(){
		List<Message> list = new ArrayList<Message>();
		String sql  = "select * from messages order by id desc";
		try {
			ResultSet rs = Mydb.getSmt().executeQuery(sql);
			while(rs.next()) {
				Message m = new Message();
				m.setId(Integer.parseInt(rs.getString(1)));
				m.setUser(rs.getString("user"));
				m.setEmail(rs.getString("email"));
				m.setContent(rs.getString("content"));
				String str = rs.getString("time");
				m.setTime(str.substring(0,str.length()-2));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;	
	}
	public static void deleteMsg(int id) {
		String sql="delete from messages where id="+id;
		try {
			Mydb.getSmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
