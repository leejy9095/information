package jun.com.information.com.crawling;

import org.jsoup.Jsoup;

public class crawling {

	String url ="http://www.kma.go.kr/";	//url ÁöÁ¤
	
	Document doc = Jsoup.connect(url).get();   //connect
	
	return "";
	
}
