package db;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.News;

public class Artdb {
	//上传文件，如果不存在文件夹则自动创建
		public static boolean mkDirectory(String path) {		
			File file = null;		
			try {			
				file = new File(path);			
				if (!file.exists()) {				
					return file.mkdirs();			
				}else{				
					return false;			
				}		
			} catch (Exception e) {		

			} finally {			
				file = null;		
			}		
			return false;	
		}
		
	public static void insertNews(News n) {
		String sql = "insert into news(newsname,newspic,content,time) values('"+n.getNewsname()+"'"
				+ ",'"+n.getNewspic()+"','"+n.getContent()+"','"+n.getTime()+"')";
		try {
			Mydb.getSmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<News> getNews(int p){
		List<News> list = new ArrayList<News>();
		String sql  = "select * from news order by id desc limit "+p+",5";
		try {
			ResultSet rs = Mydb.getSmt().executeQuery(sql);
			while(rs.next()) {
				News n = new News();
				n.setId(Integer.parseInt(rs.getString(1)));
				n.setNewsname(rs.getString(2));
				n.setNewspic(rs.getString(3));
				n.setContent(rs.getString("content"));
				String str = rs.getString("time");
				n.setTime(str.substring(0,str.length()-10));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;	
	}
	public static int pageCount() {
		int count = 0;
		String sql="select count(*) from news";
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
	public static News getOneNews(int id) {
		String sql="select * from news where id="+id;
		News n = new News();
		try {
			ResultSet rs = Mydb.getSmt().executeQuery(sql);
			if(rs.next()) {
				n.setId(Integer.parseInt(rs.getString(1)));
				n.setNewsname(rs.getString(2));
				n.setNewspic(rs.getString(3));
				n.setContent(rs.getString("content"));
				String str = rs.getString("time");
				n.setTime(str.substring(0,str.length()-2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
}
