package jh.api.zjutclass.http;

import java.util.ArrayList;
import java.util.List;

import jh.api.zjutclass.bean.ClassBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlPaser {

	private Document doc;
	
	public HtmlPaser(String htmlStr){
		doc = Jsoup.parse(htmlStr);
	}
	
	public String getQueryViewState(){
		String viewState=null;
		Elements eles_input = doc.getElementsByTag("input");
		for(int i=0;i<eles_input.size();i++){
			Element ele_viewState = eles_input.get(i);
			System.out.println("222="+ele_viewState.attr("name"));
			System.out.println("333="+ele_viewState.val());
			if(ele_viewState.attr("name").equals("__VIEWSTATE")){
				viewState = ele_viewState.val(); 
				break;
			}
		}
		return viewState;
	}
	
	public List<ClassBean> getClasses(){
		
		List<ClassBean> scoreList = new ArrayList<ClassBean>();
		
		Element	 table = doc.select("table#DG_PTHasselect").first();
		Elements trs = table.select("tr");
		for(int i=1;i<trs.size();i++){
			ClassBean classbean = new ClassBean();
			
			Element eleclassName = trs.get(i).select("span[id$=BL3]").first();System.out.println("eleclassName="+eleclassName);
			Element elefaculty = trs.get(i).select("span[id$=BL4]").first();System.out.println("elefaculty="+elefaculty);
			Element elecredit = trs.get(i).select("span[id$=BLabel1]").first();System.out.println("elecredit="+elecredit);
			Element eletimes = trs.get(i).select("span[id$=BLabel2]").first();System.out.println("eletimes="+eletimes);
			Element eleaddress = trs.get(i).select("span[id$=Label6]").first();System.out.println("eleaddress="+eleaddress);
			Element eletype = trs.get(i).select("span[id$=BZ]").first();System.out.println("eletype="+eletype);
			
			classbean.setClassName(eleclassName.text().toString());
			classbean.setFaculty(elefaculty.text().toString());
			classbean.setCredit(elecredit.text().toString());
			classbean.setTimes(eletimes.text().toString());
			classbean.setAddress(eleaddress.text().toString());
			classbean.setType(eletype.text().toString());
			scoreList.add(classbean);
		}
		return scoreList;
	}
}
