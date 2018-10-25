package servlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import db.Artdb;
import po.News;

/**
 * Servlet implementation class KeyManage
 */
@MultipartConfig
@WebServlet("/InsertArt")
public class InsertArt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		
			String name = request.getParameter("picname");			
			Part part = request.getPart("word");
			String fileName = getFileName(part);
			String mkDirectoryPath = "D:/eclipse-workspace/website01/WebContent/images/";
			String path = "images/"+fileName;
			if (Artdb.mkDirectory(mkDirectoryPath)) {			
				System.out.println(mkDirectoryPath + "建立完毕");		
				}else{			
					System.out.println(mkDirectoryPath + "建立失败！此目录或许已经存在！");		
					}
			writeTo(fileName, part);			
			News n = new News();
			n.setNewsname(name);
			n.setNewspic(path);
			n.setContent(content);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			n.setTime(sdf.format(new Date()));
			Artdb.insertNews(n);
			request.getRequestDispatcher("ShowArt?pIndex=1").forward(request, response);
	}
	
	//取得上传文件名    
	private String getFileName(Part part) {        
		String header = part.getHeader("Content-Disposition");        
		String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));        
		return fileName;    
	}

	//存储文件    
	private void writeTo(String fileName, Part part) throws IOException, FileNotFoundException {        
		InputStream in = part.getInputStream();  
		OutputStream out = new FileOutputStream("D:/eclipse-workspace/website01/WebContent/images/" + fileName);        
		byte[] buffer = new byte[1024];        
		int length = -1;        
		while ((length = in.read(buffer)) != -1) {            
			out.write(buffer, 0, length);        
		}         
		in.close();        
		out.close();    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
