package jh.api.zjutclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jh.api.zjutclass.bean.ClassBean;
import jh.api.zjutclass.http.HtmlPaser;
import jh.api.zjutclass.http.HttpUtil;

public class getClassServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private HttpUtil myHttpUtil ;
	private HtmlPaser queryHtmlPaser, viewStateHtmlPaser;
	private List<ClassBean> classesList;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String term = request.getParameter("term");
		String method = request.getParameter("method");
		
		myHttpUtil = new HttpUtil(userId,password,term);
		try {
			if(!myHttpUtil.login()){
				out.print("<script language='javascript'>alert('帐号或密码错误！登入失败!请重新输入！如果你确定没错，那就是原创的服务器瘫掉了，等会吧！我也木有办法...');window.location.href='index.jsp';</script>");
				
			}else{
				viewStateHtmlPaser = new HtmlPaser(myHttpUtil.getViewStateHtml());
				String queryViewState = viewStateHtmlPaser.getQueryViewState();
				
				queryHtmlPaser = new HtmlPaser(myHttpUtil.query(queryViewState));
				//studentBean = queryHtmlPaser.getStudentInfo();
				classesList = queryHtmlPaser.getClasses();
				if(classesList.size() == 0){
					out.print("<script language='javascript'>alert('该学期没有你的课表信息！请重新输入！');window.location.href='index.jsp';</script>");
				}else if(method.equals("xml")){
					
					out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
					out.println("<classes>");
					for(int i=0;i<classesList.size();i++){
						out.println("<class>");
						
						out.println("<className>");
						out.println(classesList.get(i).getClassName());
						out.println("</className>");
						out.println("<faculty>");
						out.println(classesList.get(i).getFaculty());
						out.println("</faculty>");
						out.println("<credit>");
						out.println(classesList.get(i).getCredit());
						out.println("</credit>");
						out.println("<times>");
						out.println(classesList.get(i).getTimes());
						out.println("</times>");
						out.println("<address>");
						out.println(classesList.get(i).getAddress());
						out.println("</address>");
						out.println("<type>");
						out.println(classesList.get(i).getType());
						out.println("</type>");
						
						out.println("</class>");
					}
					out.println("</classes>");
				}else if(method.equals("json")){
					out.print("{\"courses\":[");
					for(int j=0;j<classesList.size();j++){
						out.print("{\"className\":\""+classesList.get(j).getClassName()+"\",");
						out.print("\"faculty\":\""+classesList.get(j).getFaculty()+"\",");
						out.print("\"credit\":\""+classesList.get(j).getCredit()+"\",");
						out.print("\"times\":\""+classesList.get(j).getTimes()+"\",");
						out.print("\"address\":\""+classesList.get(j).getAddress()+"\",");
						out.print("\"type\":\""+classesList.get(j).getType()+"\"}");
						if(j != classesList.size()-1){
							out.print(",");
						}else{
							out.print("]}");
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
