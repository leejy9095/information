package jun.com.information.exchange.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WeatherController {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView WeatherList(
		ModelAndView modelAndView,
		HttpServletRequest request,
		HttpServletResponse response,
		SessionStatus status
	){
		logger.info("main");
		
		modelAndView.setViewName("Weather");
		
		return modelAndView;
	}
	
}
