package jun.com.information.crawling.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import jun.com.information.crawling.service.CrawlingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CrawlingController {
	
	@Resource(name = "crawlingService")
	private CrawlingService crawlingService;
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@RequestMapping(value = "/crawling.do", method = RequestMethod.GET)
	public ModelAndView CrawlingList(
		ModelAndView modelAndView,
		HttpServletRequest request,
		HttpServletResponse response,
		SessionStatus status
	) throws Exception{
		logger.info("crawling.do");
		
		String[] returnVal = crawlingService.GetCrawlingData();
		
		return modelAndView;
	}
	
}
