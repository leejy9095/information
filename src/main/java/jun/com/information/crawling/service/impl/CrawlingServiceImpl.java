/**
 *********************************************************************************
 * <pre>
 * ?ŒŒ   ?¼   ëª? : MngBizServiceImpl.java
 * Class OR Interface ëª?  : MngBizServiceImpl
 * ?—…   ë¬?   ëª? : 
 * ?„¤         ëª? : 
 * ?‘   ?„±   ? : LJH
 * ?‘   ?„±   ?¼ : 2018. 10. 25. ?˜¤?›„ 8:26:20
 * Version : 1.0 
 * ë³? ê²?  ?´ ? ¥ [?‘?—…?(ë²„ì „) | ?‘?—…?¼? | ?‘?—…?‚´?š©]
 * ------------------------------------------------------------------------------
 *   LJH(V1.0) | 2018. 10. 25. ?˜¤?›„ 8:26:20 | 
 *
 * </pre>
 *********************************************************************************
 */
package jun.com.information.crawling.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jun.com.information.com.crawling.crawling;
import jun.com.information.crawling.service.CrawlingService;
import jun.com.information.weather.service.WeatherVO;


@Service ("crawlingService")
public class CrawlingServiceImpl implements CrawlingService {

	@Override
	public String[] GetCrawlingData() throws Exception {

		String[] returnData = crawling.getData();
			
		return returnData;
	}
}
