package jun.com.information.weather.service;

import java.util.Map;

public interface WeatherService{
	
	Map<String,Object> selectListWeather(WeatherVO svcVO) throws Exception;

}
