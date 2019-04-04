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
package jun.com.information.weather.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jun.com.information.weather.service.WeatherService;
import jun.com.information.weather.service.WeatherVO;


/**
 *********************************************************************************
 * <pre>
 * Class OR Interface ëª? : DeductionBizServiceImpl
 * ?„¤ëª? : 
 * 
 * </pre>
 *********************************************************************************
 */

@Service ("weatherService")
public class WeatherServiceImpl implements WeatherService {
	
	@Resource(name="weatherDAO")
	private WeatherDAO weatherDAO;
	
	@Override
	public Map<String,Object> selectListWeather(WeatherVO weatherVO) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<WeatherVO> lDataList 	= new ArrayList<WeatherVO>();
		
		map.put("resultList", resultMap);
		
		return map;
	}
}
