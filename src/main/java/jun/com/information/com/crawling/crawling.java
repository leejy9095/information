package jun.com.information.com.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling {
	
	static public String[] getData() throws Exception {
			
		// 1. URL 선언
	    String connUrl = "http://map.daum.net";
	    
	    // 2. HTML 가져오기
	    Document doc = Jsoup.connect(connUrl).post();
	    //String docVal = doc.toString();
	
	    Elements element = doc.select(".tbl_weather tbody>tr:nth-child(1)");
	    String[] str = element.text().split(" ");

	    
	    return str;
	}	
	
	
}
