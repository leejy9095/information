package jun.com.information.exchange.service;
/**
 *********************************************************************************
 * <pre>
 * ?åå   ?ùº   Î™? : MngBizService.java
 * Class OR Interface Î™?  : MngBizService
 * ?óÖ   Î¨?   Î™? : 
 * ?Ñ§         Î™? : 
 * ?ûë   ?Ñ±   ?ûê : LJH
 * ?ûë   ?Ñ±   ?ùº : 2018. 10. 25. ?ò§?õÑ 8:25:54
 * Version : 1.0 
 * Î≥? Í≤?  ?ù¥ ?†• [?ûë?óÖ?ûê(Î≤ÑÏ†Ñ) | ?ûë?óÖ?ùº?ûê | ?ûë?óÖ?Ç¥?ö©]
 * ------------------------------------------------------------------------------
 *   LJH(V1.0) | 2018. 10. 25. ?ò§?õÑ 8:25:54 | 
 *
 * </pre>
 *************************************************************jun.com.information.exchange.servicethus21.custom.deduction.biz.service;

import java.util.Map;

import withus21.cms.bas.service.BaseService;
import withus21.custom.deduction.lmt.service.DdcLmtApprvVO;
import withus21.custom.deduction.sldrty.service.DdcSldrtyAssrncVO;
import withus21.custom.mbrco.service.BasMbrcoCredtGradVO;
import withus21.custom.mbrco.service.BasMbrcoSlsVO;
import withus21.custom.mbrco.service.BasMbrcoVO;
import withus21.custom.mng.service.BasMngMmoVO;

/**
 *********************************************************************************
 * <pre>
 * Class OR Interface Î™? : DeductionBizService
 * ?Ñ§Î™? : 
 * 
 * </pre>
 *********************************************************************************
 */
public interface WeatherService extends BaseService {
	
	Map<String,Object> selectListBiz(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> selectListBizWithTrmnat(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> selectListBizWithDmge(WeatherVO svcVO) throws Exception;
	
	Map<String, Object> selectInsertDeductionBiz(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> selectDetailDeductionBiz(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> insertDeductionBiz(WeatherVO svcVO, BasMbrcoCredtGradVO vMbrcoCredtGradVO,BasMbrcoSlsVO vMbrcoSaleVO, BasMngMmoVO[] mmoVOs, DdcSldrtyAssrncVO[] ddcSlsdrtyAssrncVOs,DdcLmtApprvVO vDdcLmtApprvVO) throws Exception; 

	Map<String,Object> selectUpdateDeductionBiz(WeatherVO svcVO) throws Exception;
	
	void UpdateAplStpDeductionBiz(Long lBsnAssrncSno, String aplStpCd) throws Exception;
	
	String extractBizEdcyNo(long lBsnAssrncSno, String ddcSeCd) throws Exception;
	
	//?öå?õê?Ç¨?ùò ?ó∞?ÜçÍ∞??ûÖ?ÖÑ?èÑ Íµ¨ÌïòÍ∏?
	Double selectCsctJoinYrCnt(long lMbrcoSno) throws Exception;

	Map<String, Object> deleteDeductionBiz(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> searchCredtIndt(BasMbrcoVO svcVO) throws Exception;
}
