package jun.com.information.exchange.service;
/**
 *********************************************************************************
 * <pre>
 * ?��   ?��   �? : MngBizService.java
 * Class OR Interface �?  : MngBizService
 * ?��   �?   �? : 
 * ?��         �? : 
 * ?��   ?��   ?�� : LJH
 * ?��   ?��   ?�� : 2018. 10. 25. ?��?�� 8:25:54
 * Version : 1.0 
 * �? �?  ?�� ?�� [?��?��?��(버전) | ?��?��?��?�� | ?��?��?��?��]
 * ------------------------------------------------------------------------------
 *   LJH(V1.0) | 2018. 10. 25. ?��?�� 8:25:54 | 
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
 * Class OR Interface �? : DeductionBizService
 * ?���? : 
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
	
	//?��?��?��?�� ?��?���??��?��?�� 구하�?
	Double selectCsctJoinYrCnt(long lMbrcoSno) throws Exception;

	Map<String, Object> deleteDeductionBiz(WeatherVO svcVO) throws Exception;
	
	Map<String,Object> searchCredtIndt(BasMbrcoVO svcVO) throws Exception;
}
