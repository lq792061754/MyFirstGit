package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Artdb;
import po.News;
import po.PageUtil;

/**
 * Servlet implementation class ShowArt
 */
@WebServlet("/ShowArt")
public class ShowArt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pIndex = request.getParameter("pIndex");

		int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 5;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<News> pageUtil = new PageUtil<News>();//初始化工具类
        List<News> lists = new ArrayList<News>();
        if (pIndex != null) {
            pageIndex = Integer.parseInt(pIndex);
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = Artdb.pageCount();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        pageUtil.setPageCount((int) Math.ceil((double) (pageUtil
                .getPageNumber() / pageUtil.getPageSize())) + 1);//计算出总页数,并封装到工具类
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        lists = Artdb.getNews(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(lists);//保存到工具类中的集合
		request.setAttribute("pageUtil", pageUtil);
        request.getRequestDispatcher("article_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
