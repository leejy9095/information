package jun.com.information.exchange.service.impl;
/**
 *********************************************************************************
 * <pre>
 * ?��   ?��   �? : MngBizServiceImpl.java
 * Class OR Interface �?  : MngBizServiceImpl
 * ?��   �?   �? : 
 * ?��         �? : 
 * ?��   ?��   ?�� : LJH
 * ?��   ?��   ?�� : 2018. 10. 25. ?��?�� 8:26:20
 * Version : 1.0 
 * �? �?  ?�� ?�� [?��?��?��(버전) | ?��?��?��?�� | ?��?��?��?��]
 * ------------------------------------------------------------------------------
 *   LJH(V1.0) | 2018. 10. 25. ?��?�� 8:26:20 | 
 *
 * </pre>
 *************************************************************jun.com.information.exchange.service.impl1.custom.deduction.biz.service.impl;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import withus21.cms.bas.service.impl.BaseServiceImpl;
import withus21.cms.svc.service.ComFlBnchVO;
import withus21.cms.svc.service.ComFlVO;
import withus21.cms.svc.service.impl.ComFlBnchDAO;
import withus21.cms.svc.service.impl.ComFlDAO;
import withus21.cms.util.AESUtil;
import withus21.cms.util.HtmlConvertUtil;
import withus21.cms.util.HtmlConvertVO;
import withus21.custom.deduction.biz.service.DdcBsnAssrncVO;
import withus21.custom.deduction.biz.service.DeductionBizService;
import withus21.custom.deduction.elctrn.service.DdcElctrnSignVO;
import withus21.custom.deduction.elctrn.service.impl.DdcElctrnSignDAO;
import withus21.custom.deduction.indmrt.service.DdcIndmrtVO;
import withus21.custom.deduction.indmrt.service.impl.DdcIndmrtDAO;
import withus21.custom.deduction.jdgmn.service.DdcJdgmnVO;
import withus21.custom.deduction.jdgmn.service.impl.DdcJdgmnDAO;
import withus21.custom.deduction.lmt.service.DdcLmtApprvVO;
import withus21.custom.deduction.lmt.service.impl.DdcLmtApprvDAO;
import withus21.custom.deduction.mlbx.service.DdcMlbxNoVO;
import withus21.custom.deduction.mlbx.service.DeductionMlbxNoService;
import withus21.custom.deduction.mlbx.service.impl.DdcMlbxNoDAO;
import withus21.custom.deduction.sldrty.service.DdcSldrtyAssrncVO;
import withus21.custom.deduction.sldrty.service.impl.DdcSldrtyAssrncDAO;
import withus21.custom.ktamng.rdp.service.DdcRcpmInfVO;
import withus21.custom.ktamng.rdp.service.KtamngRdpService;
import withus21.custom.ktamng.rdp.service.impl.DdcRcpmInfDAO;
import withus21.custom.mbrco.service.BasMbrcoCeoVO;
import withus21.custom.mbrco.service.BasMbrcoCredtGradVO;
import withus21.custom.mbrco.service.BasMbrcoIndtVO;
import withus21.custom.mbrco.service.BasMbrcoSlsVO;
import withus21.custom.mbrco.service.BasMbrcoVO;
import withus21.custom.mbrco.service.impl.BasMbrcoCeoDAO;
import withus21.custom.mbrco.service.impl.BasMbrcoDAO;
import withus21.custom.mbrco.service.impl.BasMbrcoIndtDAO;
import withus21.custom.mbrco.service.impl.BasMbrcoSlsDAO;
import withus21.custom.mng.service.BasMngMmoVO;
import withus21.custom.mng.service.MngService;
import withus21.custom.rgn.ctrl.service.RgnCtrlVO;
import withus21.custom.rgn.ctrl.service.impl.RgnCtrlDAO;
import withus21.usr.deduction.biz.service.UsrDeductionBizService;
import wuwg.base.service.WuwgAuthData;
import wuwg.context.WuwgContextHolder;
import wuwgcom.constant.ComConstants;
import wuwgcom.svc.com.service.ComSeService;


/**
 *********************************************************************************
 * <pre>
 * Class OR Interface �? : DeductionBizServiceImpl
 * ?���? : 
 * 
 * </pre>
 *********************************************************************************
 */

@Service ("deductionBizService")
public class WeatherServiceImpl extends BaseServiceImpl implements WeatherService {
	
	@Resource(name="ddcBsnAssrncDAO")
	private WeatherDAO ddcBsnAssrncDAO;
	
	@Resource(name="basMbrcoDAO")
	private BasMbrcoDAO basMbrcoDAO;
	
	@Resource(name="basMbrcoCeoDAO")
	private BasMbrcoCeoDAO basMbrcoCeoDAO;
	
	@Resource(name="basMbrcoSlsDAO")
	private BasMbrcoSlsDAO basMbrcoSlsDAO;
	
	@Resource(name = "comSeService")
	private ComSeService comSeService;
	
	@Resource(name = "mngService")
	private MngService mngService;
	
	@Resource(name = "ddcRcpmInfDAO")
	private DdcRcpmInfDAO ddcRcpmInfDAO;
	
	@Resource(name = "ddcJdgmnDAO")
	private DdcJdgmnDAO ddcJdgmnDAO;
	
	@Resource(name = "ddcElctrnSignDAO")
	private DdcElctrnSignDAO ddcElctrnSignDAO;
	
	@Resource(name = "ddcSldrtyAssrncDAO")
	private DdcSldrtyAssrncDAO ddcSldrtyAssrncDAO;
	
	@Resource(name = "basMbrcoIndtDAO")
	private BasMbrcoIndtDAO basMbrcoIndtDAO;
	
	@Resource(name = "comFlBnchDAO")
	private ComFlBnchDAO comFlBnchDAO;
	
	@Resource(name = "comFlDAO")
	private ComFlDAO comFlDAO;
	
	@Resource(name = "deductionMlbxNoService")
	private DeductionMlbxNoService deductionMlbxNoService; 
	
	@Resource(name = "ddcLmtApprvDAO")
	private DdcLmtApprvDAO ddcLmtApprvDAO;
	
	@Resource(name = "ddcIndmrtDAO")
	private DdcIndmrtDAO ddcIndmrtDAO;
	
	@Resource(name = "usrDeductionBizService")
	private UsrDeductionBizService usrDeductionBizService;
	
	@Resource (name="rgnCtrlDAO")
	private RgnCtrlDAO rgnCtrlDAO;
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************	 */
	@Override
	public Map<String,Object> selectListBiz(WeatherVO vDdcBsnAssrncVO) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		vDdcBsnAssrncVO.setDdcSeCd("DDSEBSN");
		resultMap = ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO);
		
		map.put("resultList", resultMap.get("resultList"));
		
		return map;
	}
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String,Object> selectInsertDeductionBiz(WeatherVO vDdcBsnAssrncVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mDdcBsnAssrncList = new HashMap<String, Object>();
		List<WeatherVO> lDataList 	= new ArrayList<WeatherVO>();
		
		Long lMbrcoSno = Long.parseLong(vDdcBsnAssrncVO.getParTgtSno()); //?��?��?�� ?��?��번호 ?��?��
		
		vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);			
		vDdcBsnAssrncVO.setDdcSeCd(vDdcBsnAssrncVO.getParSrchOpt9());
		
		mDdcBsnAssrncList = ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO);
		
		lDataList = (List<WeatherVO>)mDdcBsnAssrncList.get("resultList");
		
		//?��?���??��?��?��
		Double iCsctYr = selectCsctJoinYrCnt(lMbrcoSno);
		map.put("csctYr", iCsctYr); 
		
		BasMbrcoVO vBasMbrcoVO = new BasMbrcoVO();
		vBasMbrcoVO.setMbrcoSno(lMbrcoSno);
		vBasMbrcoVO = basMbrcoDAO.selectOne(vBasMbrcoVO);
				
		map.put("mbrcoInfo", vBasMbrcoVO);
			
		/**
		 * 공동???�� 목록
		*/
		
		BasMbrcoCeoVO vBasMbrcoCeoVO = new BasMbrcoCeoVO();
		vBasMbrcoCeoVO.setMbrcoSno(lMbrcoSno);			
		
		List<BasMbrcoCeoVO> ceoList = (List<BasMbrcoCeoVO>) basMbrcoCeoDAO.selectList(vBasMbrcoCeoVO).get("resultList");
		/*for(BasMbrcoCeoVO cVO : ceoList){
			cVO.setBrthdy(util.decrypt(cVO.getBrthdy()));
			cVO.setRno(util.decrypt(cVO.getRno()));
		}*/
		
		map.put("ceoList", ceoList);
		
		
		/**
		 * ?��?��?�� 매출?��?���?
		 */
		BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
		vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
		
		map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
		
		HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
		
		cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// �??��구분코드
		cds.putAll(comSeService.selectCodeSelMap("TASE"));  // �??��구분코드
		cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?��?��?��?��코드
		cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?��?��?���?
		cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?��?��조회 결과
		cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?��?��조회 ???��
		cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?��?��조회 ???��
		cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?��?��구분코드
		cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?��?��구분코드
		
		map.put("cds", cds);
			
		
		
		return map;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String,Object> selectDetailDeductionBiz(WeatherVO vDdcBsnAssrncVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mDdcBsnAssrncList = new HashMap<String, Object>();
		List<WeatherVO> lDataList 	= new ArrayList<WeatherVO>();
		
		if(vDdcBsnAssrncVO.getDdcAssrncSno() != null){
			map = selectUpdateDeductionBiz(vDdcBsnAssrncVO);
		}else{
			Long lMbrcoSno = Long.parseLong(vDdcBsnAssrncVO.getParTgtSno()); //?��?��?�� ?��?��번호 ?��?��
			
			vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);		
			vDdcBsnAssrncVO.setDdcSeCd(vDdcBsnAssrncVO.getParSrchOpt9());
			vDdcBsnAssrncVO.setPlanngAssrncYn(vDdcBsnAssrncVO.getParSrchOpt10());
			mDdcBsnAssrncList = ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO);
			
			lDataList = (List<WeatherVO>)mDdcBsnAssrncList.get("resultList");			
			
			WeatherVO vSrchVO = new WeatherVO(); 
			vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);		
			vDdcBsnAssrncVO.setDdcSeCd(vDdcBsnAssrncVO.getParSrchOpt9());
			vDdcBsnAssrncVO.setPlanngAssrncYn(vDdcBsnAssrncVO.getParSrchOpt10());
			vDdcBsnAssrncVO.setEdycPubYn("Y");
			
			map.put("mbrcoList", (List<WeatherVO>)ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO).get("resultList"));
			
			//?��?���??��?��?��
			Double iCsctYr = selectCsctJoinYrCnt(lMbrcoSno);
			map.put("csctYr", iCsctYr); 
			
			BasMbrcoIndtVO indVO = new BasMbrcoIndtVO();
			indVO.setMbrcoSno(lMbrcoSno);
			indVO.setIndtCd(vDdcBsnAssrncVO.getParSrchOpt3());
			
			indVO = basMbrcoIndtDAO.selectOne(indVO);
			
			map.put("indtInfo", indVO);
			
			//?��?�� ?��?��?���? ?��?��보증?�� ?��록된�? ?��?���? 마�?�? ?��?��보증?���? set
			if(Integer.parseInt(mDdcBsnAssrncList.get("resultCnt").toString()) > 0){
				WeatherVO vDetailDdcBsnAssrncVO = lDataList.get(0); 
				
				map.put("biz", lDataList.get(0));
				
				long lDdcBsnAssrncSno = vDetailDdcBsnAssrncVO.getDdcAssrncSno();
				
				//�??��?��?�� ?��?��
				String sTaseCd = "";
				@SuppressWarnings("unchecked")
				Map<String, WuwgAuthData> am = (Map<String, WuwgAuthData>)vDdcBsnAssrncVO.getRequest().getSession().getAttribute(ComConstants.SESS_AUTH_MAP);
				if(am!=null && am.get("ADMIN") != null && am.get("ADMIN").getUsrMap() != null){
					sTaseCd = am.get("ADMIN").getUsrMap().get("taseCd").toString();
				}
				
				if(sTaseCd.substring(0,4).equals("TASE")){
					if(!sTaseCd.equals("TASELOSE00")){ 
						RgnCtrlVO vNowSrchVO = new RgnCtrlVO();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
						Calendar c1 = Calendar.getInstance();
						String sToday = sdf.format(c1.getTime());
						vNowSrchVO.setParSrchTxt1(sToday);
						vNowSrchVO.setGrpCd(sTaseCd);
						vNowSrchVO.setDdcSeCd("DDSEBSN");
						
						List<RgnCtrlVO> lCtrlList = new ArrayList<RgnCtrlVO>();		//?��?��?��?��?�� ?��?��?�� 리스?��목록
						lCtrlList =  (List<RgnCtrlVO>) rgnCtrlDAO.selectListNowCtrl(vNowSrchVO).get("resultList");
						if(lCtrlList.size()>0){
							map.put("ctrlYn", "N");
						}
					}
				}
				
				//�?리메�?
				Map<String,Object> mMngMmo = new HashMap<String, Object>();
				BasMngMmoVO vBasMngMmoVO = new BasMngMmoVO();
				vBasMngMmoVO.setRefSe("RFSEBSNASSRNC"); //�?리메�? ?��?��보증코드?��?��
				vBasMngMmoVO.setRefSno(lDdcBsnAssrncSno); //?��?��보증 ?��?��번호 ?��?��
				
				mMngMmo = mngService.selectListMngMmo("",vBasMngMmoVO);
				
				map.put("mmo", mMngMmo.get("resultList"));
				
				
				//?��금정�?
				List<DdcRcpmInfVO> lDdcRcpmInf = new ArrayList<DdcRcpmInfVO>();
				DdcRcpmInfVO vDdcRcpmInfVO = new DdcRcpmInfVO();
				vDdcRcpmInfVO.setDdcAssrncSno(lDdcBsnAssrncSno);				
				
				lDdcRcpmInf = (List<DdcRcpmInfVO>) ddcRcpmInfDAO.selectList(vDdcRcpmInfVO).get("resultList");
				
				map.put("rcpm", lDdcRcpmInf);
				
				//?��?��?���?
				List<DdcJdgmnVO> lDdcJdgmn = new ArrayList<DdcJdgmnVO>();
				DdcJdgmnVO vDdcJdgmnVO = new DdcJdgmnVO();
				vDdcJdgmnVO.setDdcAssrncSno(lDdcBsnAssrncSno);				
				
				lDdcJdgmn = (List<DdcJdgmnVO>) ddcJdgmnDAO.selectListDeductionJdgmn(vDdcJdgmnVO).get("resultList");
				
				map.put("jdgmn", lDdcJdgmn);
				
				//?��금정�?
				List<ComFlBnchVO> lFlData = new ArrayList<ComFlBnchVO>();
				
				lFlData = comFlBnchDAO.selectListFileGroupByPrntSe("FLSEDDC1", lDdcBsnAssrncSno);
				
				map.put("flList", lFlData);
				
				//?��?��?��?��
				DdcLmtApprvVO vDdcLmtApprvVO = new DdcLmtApprvVO();
				vDdcLmtApprvVO.setDdcAssrncSno(lDdcBsnAssrncSno);
				
				vDdcLmtApprvVO = ddcLmtApprvDAO.selectOneWithDdcSno(vDdcLmtApprvVO);
				
				map.put("lmtApprv", vDdcLmtApprvVO);
				
				//?��?��?���? ?���?
				List<DdcElctrnSignVO> lDdcSign = new ArrayList<DdcElctrnSignVO>();
				DdcElctrnSignVO vDdcElctrnSignVO = new DdcElctrnSignVO();
				vDdcElctrnSignVO.setDdcAssrncSno(lDdcBsnAssrncSno);
				
				lDdcSign = (List<DdcElctrnSignVO>) ddcElctrnSignDAO.selectList(vDdcElctrnSignVO).get("resultList");
				
				map.put("sign", lDdcSign);
				
				List<DdcSldrtyAssrncVO> lDdcSldrtyList = new ArrayList<DdcSldrtyAssrncVO>();
				DdcSldrtyAssrncVO vDdcSldrtyAssrncVO = new DdcSldrtyAssrncVO();
				vDdcSldrtyAssrncVO.setDdcAssrncSno(lDdcBsnAssrncSno);
				
				lDdcSldrtyList = (List<DdcSldrtyAssrncVO>) ddcSldrtyAssrncDAO.selectList(vDdcSldrtyAssrncVO).get("resultList");
				
				map.put("grntrList", lDdcSldrtyList);
				
				
			}else{ //기업?��보만 ?��?��
				BasMbrcoVO vBasMbrcoVO = new BasMbrcoVO();
				vBasMbrcoVO.setMbrcoSno(lMbrcoSno);
				vBasMbrcoVO = basMbrcoDAO.selectOne(vBasMbrcoVO);
				
				
				//vBasMbrcoVO.setBrthdy(util.decrypt(vBasMbrcoVO.getBrthdy()));
				//vBasMbrcoVO.setEml(util.decrypt(vBasMbrcoVO.getEml()));
				vBasMbrcoVO.setParSrchOpt1(vDdcBsnAssrncVO.getParSrchOpt1());
				
				map.put("mbrcoInfo", vBasMbrcoVO);
				
				
			}
			
	
			/**
			 * 공동???�� 목록
			*/
			
			BasMbrcoCeoVO vBasMbrcoCeoVO = new BasMbrcoCeoVO();
			vBasMbrcoCeoVO.setMbrcoSno(lMbrcoSno);			
			
			List<BasMbrcoCeoVO> ceoList = (List<BasMbrcoCeoVO>) basMbrcoCeoDAO.selectList(vBasMbrcoCeoVO).get("resultList");
		/*	for(BasMbrcoCeoVO cVO : ceoList){
				cVO.setBrthdy(util.decrypt(cVO.getBrthdy()));
				cVO.setRno(util.decrypt(cVO.getRno()));
			}*/
			
			map.put("ceoList", ceoList);
			
			
			/**
			 * ?��?��?�� 매출?��?���?
			 */
			BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
			vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
			
			map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
			
			HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
			
			cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// �??��구분코드
			cds.putAll(comSeService.selectCodeSelMap("TASE"));  // �??��구분코드
			cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?��?��?��?��코드
			cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?��?��?���?
			cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?��?��조회 결과
			cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?��?��조회 ???��
			cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?��?��조회 ???��
			cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?��?��구분코드
			cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?��?��구분코드
			
			map.put("cds", cds);
			
		}
		
		return map;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : insertDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String,Object> insertDeductionBiz(WeatherVO vDdcBsnAssrncVO, BasMbrcoCredtGradVO vMbrcoCredtGradVO,BasMbrcoSlsVO vMbrcoSlsVO, BasMngMmoVO[] mmoVOs, DdcSldrtyAssrncVO[] ddcSlsdrtyAssrncVOs,DdcLmtApprvVO vDdcLmtApprvVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<LinkedHashMap<String,Object>> lDataList 	= new ArrayList<LinkedHashMap<String,Object>>();
		
		Long lBsnAssrncSno = 0L;

		if(vDdcBsnAssrncVO.getDdcAssrncSno() == null){
					
			vDdcBsnAssrncVO.setEdycPubYn("N");
			vDdcBsnAssrncVO.setEdycApprvYn("N");
			vDdcBsnAssrncVO.setEndrsYn("EDST10"); //?��규등�? ?��?��증서
			vDdcBsnAssrncVO.setCntrctAmt(0L);
			vDdcBsnAssrncVO.setFrstRgtDttm("__SYSDATE__");
			vDdcBsnAssrncVO.setRcntChngDttm("__SYSDATE__");
			vDdcBsnAssrncVO.setDdcStplatAgreDttm("__SYSDATE__");
			lBsnAssrncSno = ddcBsnAssrncDAO.insertOneAutoIdx(vDdcBsnAssrncVO);
			
			//?��규등록시?���? ?��?�� 추�?
			List<ComFlBnchVO> lFlData = new ArrayList<ComFlBnchVO>();
			
			lFlData = comFlBnchDAO.selectListFileGroupByPrntSe("FLSEENTP", vDdcBsnAssrncVO.getMbrcoSno());		
			
			for(ComFlBnchVO vComFlVO : lFlData){
				ComFlBnchVO vInsertBnchVO = new ComFlBnchVO();
				String sSelFlSno = "";
				vInsertBnchVO.setFlBnchPrntSeCd("FLSEDDC1");
				vInsertBnchVO.setFlBnchPrntKvl(String.valueOf(lBsnAssrncSno));
				vInsertBnchVO.setFlSeCd("FLSEDDC1");
				vInsertBnchVO.copyAuthFrom(vDdcBsnAssrncVO);
				if(vComFlVO.getFlKindCd().equals("FLKNFLSEENTP01")){
					sSelFlSno = vComFlVO.getFlSno();
					vInsertBnchVO.setFlKindCd("FLKNFLSEDDC101");
				}else if(vComFlVO.getFlKindCd().equals("FLKNFLSEENTP22")){
					if(vDdcBsnAssrncVO.getIndtCd().equals("INDT100")){ //�??��
						sSelFlSno = vComFlVO.getFlSno();
						vInsertBnchVO.setFlKindCd("FLKNFLSEDDC102");
					}
				}else if(vComFlVO.getFlKindCd().equals("FLKNFLSEENTP12")){
					if(vDdcBsnAssrncVO.getIndtCd().equals("INDT110")){
						sSelFlSno = vComFlVO.getFlSno();
						vInsertBnchVO.setFlKindCd("FLKNFLSEDDC102");
					}
				}else if(vComFlVO.getFlKindCd().equals("FLKNFLSEENTP02")){
					if(vDdcBsnAssrncVO.getIndtCd().equals("INDT115")){
						sSelFlSno = vComFlVO.getFlSno();
						vInsertBnchVO.setFlKindCd("FLKNFLSEDDC102");
					}
				}
				
				if(sSelFlSno != ""){
					usrDeductionBizService.copyFileData(sSelFlSno, vInsertBnchVO);
				}
			}
			
			
		}else{
			
			vDdcBsnAssrncVO.setRcntChngDttm("__SYSDATE__");
			lBsnAssrncSno = vDdcBsnAssrncVO.getDdcAssrncSno();
			ddcBsnAssrncDAO.updateOne(vDdcBsnAssrncVO);
		}
		
		String userID =  "";
		String mbrSno = "";
		String sTaseCd = "";
		@SuppressWarnings("unchecked")
		Map<String, WuwgAuthData> am = (Map<String, WuwgAuthData>)vDdcBsnAssrncVO.getRequest().getSession().getAttribute(ComConstants.SESS_AUTH_MAP);
		if(am!=null && am.get("ADMIN") != null){
			userID = am.get("ADMIN").getMbrId();
			mbrSno = am.get("ADMIN").getMbrSno();
			sTaseCd = am.get("ADMIN").getUsrMap().get("taseCd").toString();
		}
		
		//?��?��?��?��?���?
		if(vDdcLmtApprvVO.getLmtAmt() != 0){
			vDdcLmtApprvVO.copyAuthFrom(vDdcBsnAssrncVO);
			vDdcLmtApprvVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
			vDdcLmtApprvVO.setDdcAssrncSno(lBsnAssrncSno);
			vDdcLmtApprvVO.setDdcAmt(vDdcBsnAssrncVO.getDdcAmt());
			vDdcLmtApprvVO.setRqstDttm("__SYSDATE__");
			vDdcLmtApprvVO.setRqstAsocCd(sTaseCd);
			vDdcLmtApprvVO.setRqstMbrSno(mbrSno);
			vDdcLmtApprvVO.setRqstMbrId(userID);
			vDdcLmtApprvVO.setLmtApprvRslt("PRSE10");
			vDdcLmtApprvVO.setFrstRgtDttm("__SYSDATE__");
			vDdcLmtApprvVO.setRcntChngDttm("__SYSDATE__");
			
			ddcLmtApprvDAO.insertOne(vDdcLmtApprvVO);
		}
		
		
		//보증?��?���?
		if(ddcSlsdrtyAssrncVOs.length > 0){
			for(DdcSldrtyAssrncVO vTempVO : ddcSlsdrtyAssrncVOs){				
				vTempVO.copyAuthFrom(vDdcBsnAssrncVO);
				vTempVO.setDdcAssrncSno(lBsnAssrncSno);
				vTempVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
				vTempVO.setFrstRgtDttm("__SYSDATE__");
				vTempVO.setRcntChngDttm("__SYSDATE__");
				
				if(vTempVO.getSldrtyAssrncSno() != null){
					ddcSldrtyAssrncDAO.updateOne(vTempVO);
				}else{
					ddcSldrtyAssrncDAO.insertOne(vTempVO);
				}
				
			}
		}
		
		/**
		 * 매출?��?���? upsert
		 */
		if(vDdcBsnAssrncVO.getSlsYr() != null){
			BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
			vBasMbrcoSlsVO.setMbrcoSno(vDdcBsnAssrncVO.getMbrcoSno());
			vBasMbrcoSlsVO.setSlsYr(vDdcBsnAssrncVO.getSlsYr());
			vBasMbrcoSlsVO.setSlsAmtSm(vDdcBsnAssrncVO.getSlsAmtSm());
			vBasMbrcoSlsVO.setSlsAmtDom(vDdcBsnAssrncVO.getSlsAmtDom());
			vBasMbrcoSlsVO.setSlsAmtOvs(vDdcBsnAssrncVO.getSlsAmtOvs());
			vBasMbrcoSlsVO.setSlsAmtEtc(vDdcBsnAssrncVO.getSlsAmtEtc());
			
			basMbrcoSlsDAO.upsertOne(vBasMbrcoSlsVO);
		}
		
		
		
		/**
		 * �?리메�? ?��?��
		 * �?리메�? ?��?��?�� 코드 - RFSEMBRCO
		 */
		if (mmoVOs.length > 0) {
			for (BasMngMmoVO mVO : mmoVOs) {
				mVO.copyAuthFrom(vDdcBsnAssrncVO);
				
				mngService.upsertMngMmo(mVO, lBsnAssrncSno, "RFSEBSNASSRNC");
			}
		}	
		
		return map;
	}
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String,Object> selectUpdateDeductionBiz(WeatherVO svcVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		Long lDdcBsnAssrncSno = Long.parseLong(svcVO.getParTgtSno()); //?��?��?�� ?��?��번호 ?��?��
		
		//Long lDdcBsnAssrncSno = svcVO.getBsnAssrncSno(); //?��?��?�� ?��?��번호 ?��?��
		
		Map<String, Object> mDdcBsnAssrncList = new HashMap<String, Object>();		
		
		WeatherVO vDdcBsnAssrncVO = new WeatherVO(); 
		vDdcBsnAssrncVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		vDdcBsnAssrncVO = ddcBsnAssrncDAO.selectOne(vDdcBsnAssrncVO);
			
	/*	if(vDdcBsnAssrncVO.getAplrEml() != null && vDdcBsnAssrncVO.getAplrEml() != ""){
			vDdcBsnAssrncVO.setAplrEml(util.decrypt(vDdcBsnAssrncVO.getAplrEml()));
		}*/
		
		map.put("biz", vDdcBsnAssrncVO);		
		
		//�??��?��?�� ?��?��
		String sTaseCd = "";
		@SuppressWarnings("unchecked")
		Map<String, WuwgAuthData> am = (Map<String, WuwgAuthData>)svcVO.getRequest().getSession().getAttribute(ComConstants.SESS_AUTH_MAP);
		if(am!=null && am.get("ADMIN") != null && am.get("ADMIN").getUsrMap() != null){
			sTaseCd = am.get("ADMIN").getUsrMap().get("taseCd").toString();
		}
		
		if(sTaseCd.substring(0,4).equals("TASE")){
			if(!sTaseCd.equals("TASELOSE00")){ 
				RgnCtrlVO vNowSrchVO = new RgnCtrlVO();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar c1 = Calendar.getInstance();
				String sToday = sdf.format(c1.getTime());
				vNowSrchVO.setParSrchTxt1(sToday);
				vNowSrchVO.setGrpCd(sTaseCd);
				vNowSrchVO.setDdcSeCd("DDSEBSN");
				
				List<RgnCtrlVO> lCtrlList = new ArrayList<RgnCtrlVO>();		//?��?��?��?��?�� ?��?��?�� 리스?��목록
				lCtrlList =  (List<RgnCtrlVO>) rgnCtrlDAO.selectListNowCtrl(vNowSrchVO).get("resultList");
				if(lCtrlList.size()>0){
					map.put("ctrlYn", "N");
				}
			}
		}
		
		
		WeatherVO vSrchVO = new WeatherVO();
		
		vSrchVO.setMbrcoSno(vDdcBsnAssrncVO.getMbrcoSno());		
		vSrchVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		vSrchVO.setPlanngAssrncYn(vDdcBsnAssrncVO.getPlanngAssrncYn());
		vSrchVO.setEdycPubYn("Y");
		
		map.put("mbrcoList", ddcBsnAssrncDAO.selectList(vSrchVO).get("resultList"));
		
		Map<String,Object> mMngMmo = new HashMap<String, Object>(); 
		BasMngMmoVO vBasMngMmoVO = new BasMngMmoVO();
		vBasMngMmoVO.setRefSe("RFSEBSNASSRNC"); //�?리메�? ?��?��보증코드?��?��
		vBasMngMmoVO.setRefSno(lDdcBsnAssrncSno); //?��?��보증 ?��?��번호 ?��?��
		
		mMngMmo = mngService.selectListMngMmo("",vBasMngMmoVO);
		
		map.put("mmo", mMngMmo.get("resultList"));
		
		
		/**
		 * 공동???�� 목록
		*/
		
		Long lMbrcoSno = vDdcBsnAssrncVO.getMbrcoSno();
		BasMbrcoCeoVO vBasMbrcoCeoVO = new BasMbrcoCeoVO();
		vBasMbrcoCeoVO.setMbrcoSno(lMbrcoSno);			
		
		List<BasMbrcoCeoVO> ceoList = (List<BasMbrcoCeoVO>) basMbrcoCeoDAO.selectList(vBasMbrcoCeoVO).get("resultList");
	/*	for(BasMbrcoCeoVO cVO : ceoList){
			cVO.setBrthdy(util.decrypt(cVO.getBrthdy()));
			cVO.setRno(util.decrypt(cVO.getRno()));
		}*/
		
		map.put("ceoList", ceoList);
		
		Double iCsctYr = selectCsctJoinYrCnt(lMbrcoSno);
		map.put("csctYr", iCsctYr); 
		
		//?��?��?���?
		List<DdcJdgmnVO> lDdcJdgmn = new ArrayList<DdcJdgmnVO>();
		DdcJdgmnVO vDdcJdgmnVO = new DdcJdgmnVO();
		vDdcJdgmnVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcJdgmn = (List<DdcJdgmnVO>) ddcJdgmnDAO.selectListDeductionJdgmn(vDdcJdgmnVO).get("resultList");
		
		map.put("jdgmn", lDdcJdgmn);
		
		//?��?��?��?��
		DdcLmtApprvVO vDdcLmtApprvVO = new DdcLmtApprvVO();
		vDdcLmtApprvVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		vDdcLmtApprvVO = ddcLmtApprvDAO.selectOneWithDdcSno(vDdcLmtApprvVO);
		
		map.put("lmtApprv", vDdcLmtApprvVO);
		
		//?��금정�?
		List<DdcRcpmInfVO> lDdcRcpmInf = new ArrayList<DdcRcpmInfVO>();
		DdcRcpmInfVO vDdcRcpmInfVO = new DdcRcpmInfVO();
		vDdcRcpmInfVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcRcpmInf = (List<DdcRcpmInfVO>) ddcRcpmInfDAO.selectList(vDdcRcpmInfVO).get("resultList");
		
		map.put("rcpm", lDdcRcpmInf);
		
		//?��?��?���? ?���?
		List<DdcElctrnSignVO> lDdcSign = new ArrayList<DdcElctrnSignVO>();
		DdcElctrnSignVO vDdcElctrnSignVO = new DdcElctrnSignVO();
		vDdcElctrnSignVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcSign = (List<DdcElctrnSignVO>) ddcElctrnSignDAO.selectList(vDdcElctrnSignVO).get("resultList");
		
		map.put("sign", lDdcSign);
		
		
		/**
		 * ?��?��?�� 매출?��?���?
		 */
		BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
		vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
		
		map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
		
		//?��금정�?
		List<ComFlBnchVO> lFlData = new ArrayList<ComFlBnchVO>();
		
		lFlData = comFlBnchDAO.selectListFileGroupByPrntSe("FLSEDDC1", lDdcBsnAssrncSno);
		
		map.put("flList", lFlData);
		
		/**
		 * 보증?�� 목록
		*/
		
		List<DdcSldrtyAssrncVO> lDdcSldrtyList = new ArrayList<DdcSldrtyAssrncVO>();
		DdcSldrtyAssrncVO vDdcSldrtyAssrncVO = new DdcSldrtyAssrncVO();
		vDdcSldrtyAssrncVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcSldrtyList = (List<DdcSldrtyAssrncVO>) ddcSldrtyAssrncDAO.selectList(vDdcSldrtyAssrncVO).get("resultList");
		
		map.put("grntrList", lDdcSldrtyList);
		
		HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
		
		cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// �??��구분코드
		cds.putAll(comSeService.selectCodeSelMap("TASE"));  // �??��구분코드
		cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?��?��?��?��코드
		cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?��?��?���?
		cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?��?��조회 결과
		cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?��?��조회 ???��
		cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?��?��조회 ???��
		cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?��?��구분코드
		cds.putAll(comSeService.selectCodeSelMap("SGSE"));  // ?��?��?��명구�?
		cds.putAll(comSeService.selectCodeSelMap("SGKD"));  // ?��?��?��명방�?
		cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?��?��구분코드
		
		map.put("cds", cds);
		
		return map;
	}
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : UpdateAplStpDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param sLoseNo
	 * @return
	 * @throws Exception 
	 * @?��       �? : ?��?��보증?�� ?��?���? ?��?��?��?��?��?��
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public void UpdateAplStpDeductionBiz(Long lBsnAssrncSno, String sAplStpCd) throws Exception{
		WeatherVO vDdcBsnAssrncVO = new WeatherVO();
		WeatherVO vUpdateDdcBsnAssrncVO = new WeatherVO();
		
		vUpdateDdcBsnAssrncVO.setDdcAssrncSno(lBsnAssrncSno);
		vUpdateDdcBsnAssrncVO.setDdcAssrncSnoWithMark(lBsnAssrncSno);
		vUpdateDdcBsnAssrncVO.setAplStpCdWithMark(sAplStpCd);
		
		if(sAplStpCd.equals("APST4001") || sAplStpCd.equals("APST5001")){
			vDdcBsnAssrncVO = ddcBsnAssrncDAO.selectOne(vUpdateDdcBsnAssrncVO);
			vUpdateDdcBsnAssrncVO.setEdycApprvYnWithMark("Y"); //증서?��?��?���? Y
			vUpdateDdcBsnAssrncVO.setEdycPubYnWithMark("Y"); //발행?���? Y
			vUpdateDdcBsnAssrncVO.setEdycPubDttmWithMark("__SYSDATE__");
			vUpdateDdcBsnAssrncVO.setEdycNoWithMark(extractBizEdcyNo(lBsnAssrncSno,vDdcBsnAssrncVO.getDdcSeCd()));
			vUpdateDdcBsnAssrncVO.setMlbxNoWithMark(deductionMlbxNoService.selectMlbxNo(vDdcBsnAssrncVO.getPubAsocCd()));
			ddcBsnAssrncDAO.updatePart(vUpdateDdcBsnAssrncVO);
			makeBsnImgFile(lBsnAssrncSno);
		}else{
			ddcBsnAssrncDAO.updatePart(vUpdateDdcBsnAssrncVO);
		}
		
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : extractBizEdcyNo
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param sLoseNo
	 * @return
	 * @throws Exception 
	 * @?��       �? : ?��?��보증 증서번호�? 리턴?���??��
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public String extractBizEdcyNo(long lBsnAssrncSno,String ddcSeCd) throws Exception{
		String sEdcyno = "";
		String sLoseNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR); //?��?��?��?��
		String yy = String.valueOf(year).substring(2,4);
		
		
		WeatherVO vDdcBsnAssrncVO = new WeatherVO();
		vDdcBsnAssrncVO.setSrchCntStart(String.valueOf((year-1))+"-12-31 23:59:59");
		vDdcBsnAssrncVO.setSrchCntEnd(String.valueOf((year+1))+"-01-01");
		//vDdcBsnAssrncVO.setDdcSeCd(ddcSeCd);
		map = ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO);
		
		int bizCnt = Integer.parseInt(ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO).get("resultCnt").toString());
		
		
		vDdcBsnAssrncVO.setDdcAssrncSno(lBsnAssrncSno);
		vDdcBsnAssrncVO = ddcBsnAssrncDAO.selectOne(vDdcBsnAssrncVO);
		sLoseNo = vDdcBsnAssrncVO.getAddrRgnCd().substring(4,6);
		
		String sCnt = String.format("%04d", bizCnt+1);
		
		sEdcyno = sLoseNo + "-" + yy + "-" + sCnt;
		
		return sEdcyno;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectCsctJoinYrCnt
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param lMbrcoSno
	 * @return
	 * @throws Exception 
	 * @?��       �? : ?��?�� 기업?�� ?��?���??��?��?���? 조회?��?��
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Double selectCsctJoinYrCnt(long lMbrcoSno) throws Exception{
		Double iCsctJoinYrCnt = 0D;
		
		//�?�?, 계약보증구현 ?�� 추�??��?��
		WeatherVO vDdcBsnAssrncVO = new WeatherVO();
		Map<String, Object> map = new HashMap<String, Object>();
		List<WeatherVO> lDdcBsnAssrnc = new ArrayList<WeatherVO>();
		vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);
		vDdcBsnAssrncVO.setEdycApprvYn("Y"); //?��?��?�� 증서 조회
		vDdcBsnAssrncVO.setDdcSeCd("DDSEBSN");
		
		lDdcBsnAssrnc = (List<WeatherVO>) ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO).get("resultList");
		
		
			
		if(lDdcBsnAssrnc.size() > 0){
			vDdcBsnAssrncVO = lDdcBsnAssrnc.get(0); //?���? desc 0번�?��? �??�� 최근 증서
			String sEndDttm = vDdcBsnAssrncVO.getDdcEndDttm().replaceAll("-", "");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try{
				String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
				Date sNowDate = sdf.parse(inDate);
				Date endDttm = sdf.parse(sEndDttm);
				
				long diffDay = (sNowDate.getTime() - endDttm.getTime()) / (24*60*60*1000);
				
				if(diffDay < 8 && vDdcBsnAssrncVO.getCredtInqrTgtCd().equals("CDTGINDI")){
					iCsctJoinYrCnt = vDdcBsnAssrncVO.getCsctJoinYrCnt() + 1D;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return iCsctJoinYrCnt;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : makeBsnImgFile
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param lBsnAssrncSno
	 * @return
	 * @throws Exception 
	 * @?��       �? : ?��?��보증 ?��?�� ?��?��
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	public void makeBsnImgFile(Long lBsnAssrncSno) throws Exception{
		
		WeatherVO vDdcBsnAssrncVO = new WeatherVO(); 
		vDdcBsnAssrncVO.setDdcAssrncSno(lBsnAssrncSno);		
		vDdcBsnAssrncVO = ddcBsnAssrncDAO.selectOne(vDdcBsnAssrncVO);
		
		String docForm1 = "bsn_doc_1.html";
		String docForm4 = "bsn_doc_4.html";
		if(vDdcBsnAssrncVO.getDdcSeCd().equals("DDSEPLANNG")){
			docForm1 = "esn_doc_1.html";
			docForm4 = "esn_doc_4.html";
		}
		
		List<HtmlConvertVO> lHtmlConvertVO = new ArrayList<HtmlConvertVO>();
		
		//1?��?���? ?���? ?��?�� ?��?��
		HtmlConvertVO htmlConvertVO = new HtmlConvertVO();		
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		Map<String, Object> value1 = new HashMap<String, Object>();
		value1.put("edycNo", "?�� "+vDdcBsnAssrncVO.getEdycNo()+" ?��");
		value1.put("ipsNm", vDdcBsnAssrncVO.getIpsNm());
		value1.put("addr",  "("+vDdcBsnAssrncVO.getZip()+")"+vDdcBsnAssrncVO.getAddrBas() + " " + vDdcBsnAssrncVO.getAddrDtl());
		value1.put("mbrcoNm", vDdcBsnAssrncVO.getMbrcoNm());
		value1.put("ceoNm", vDdcBsnAssrncVO.getCeoNm());
		value1.put("mbrcoRgtno", vDdcBsnAssrncVO.getMbrcoRgtno());
		value1.put("indtNm", vDdcBsnAssrncVO.getIndtNm());
		value1.put("rprTelno", phoneUtil(vDdcBsnAssrncVO.getRprTelno()));
		value1.put("rprFaxno", phoneUtil(vDdcBsnAssrncVO.getRprFaxno()));
		value1.put("ddcAmt",df.format(vDdcBsnAssrncVO.getDdcAmt()) + "?��");
		value1.put("shareAmt",df.format(vDdcBsnAssrncVO.getShareAmt())+ "?��");	
		value1.put("bsrno", vDdcBsnAssrncVO.getBsrno().substring(0,3) + "-" + vDdcBsnAssrncVO.getBsrno().substring(3,5) + "-" + vDdcBsnAssrncVO.getBsrno().substring(5,10));
		
		String[] aBgnDt = vDdcBsnAssrncVO.getDdcBgnDttm().split("-");
		String[] aEndDt = vDdcBsnAssrncVO.getDdcEndDttm().split("-");
		String[] aPubDttm = vDdcBsnAssrncVO.getEdycPubDttm().split(" ");
		value1.put("ddcTerm", aBgnDt[0]+"?�� "+aBgnDt[1]+"?�� "+aBgnDt[2]+"?�� (24?���??��) ~ "+aEndDt[0]+"?�� "+aEndDt[1]+"?�� "+aEndDt[2]+"?�� (24?�� 까�?) 365?���? ");
		value1.put("edycPubDttm", aPubDttm[0].split("-")[0] + "?�� " + aPubDttm[0].split("-")[1]+ "?�� "+ aPubDttm[0].split("-")[2]+ "?�� ");
		value1.put("spcablMttr", vDdcBsnAssrncVO.getSpcablMttr() == null ? "" : vDdcBsnAssrncVO.getSpcablMttr());
		
		String nowDt = aPubDttm[0].replaceAll("[-]","");
		
		htmlConvertVO.setTypes(docForm1);
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-1.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(2));
		
		lHtmlConvertVO.add(htmlConvertVO);
		//1?��?���? ?���? ?��?�� ?��
		
		htmlConvertVO = new HtmlConvertVO();
		htmlConvertVO.setTypes(docForm4);
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-view.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(1));
		lHtmlConvertVO.add(htmlConvertVO);
		
		//2?��?���??���? ?��?��
		htmlConvertVO = new HtmlConvertVO();
		value1 = new HashMap<String, Object>();
		htmlConvertVO.setTypes("bsn_doc_2.html");
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-2.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(3));
		
		lHtmlConvertVO.add(htmlConvertVO);
		
		//3?��?���? ?���? ?��?��
		htmlConvertVO = new HtmlConvertVO();
		value1 = new HashMap<String, Object>();
		value1.put("mbrcoNm", vDdcBsnAssrncVO.getMbrcoNm()+" �?�?");
		value1.put("edycNo", "증서번호 ?�� "+vDdcBsnAssrncVO.getEdycNo()+" ?��");
		value1.put("ddcAmt",df.format(vDdcBsnAssrncVO.getDdcAmt()) + "?��");
		value1.put("ipsNm", vDdcBsnAssrncVO.getIpsNm());
		value1.put("shareAmt",df.format(vDdcBsnAssrncVO.getShareAmt())+ "?��");	
		value1.put("ddcTerm", aBgnDt[0]+"?�� "+aBgnDt[1]+"?�� "+aBgnDt[2]+"?�� (24?���??��) ~ "+aEndDt[0]+"?�� "+aEndDt[1]+"?�� "+aEndDt[2]+"?�� (24?�� 까�?) 365?���? ");
		value1.put("edycPubDttm", aPubDttm[0].split("-")[0] + "?�� " + aPubDttm[0].split("-")[1]+ "?�� "+ aPubDttm[0].split("-")[2]+ "?�� ");
		
		
		htmlConvertVO.setTypes("bsn_doc_3.html");
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-3.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(4));
		
		lHtmlConvertVO.add(htmlConvertVO);
		
		value1 = new HashMap<String, Object>();
		
		String pdfFlNm = vDdcBsnAssrncVO.getEdycNo()+".pdf";
		//?��?��?�� pdf �?		
		HtmlConvertUtil.htmlConvert(lHtmlConvertVO,pdfFlNm);		
		
		String uploadPath = "upload/"+nowDt+"/"+vDdcBsnAssrncVO.getDdcSeCd();
		
		//pdf?��?�� ?��?��?��?���? 추�?
		ComFlVO vComFlVO = new ComFlVO();
		ComFlBnchVO vComFlBnchVO = new ComFlBnchVO();
		
		vComFlVO.setFlSno(comFlDAO.genSeqNo("", ComConstants.HDR_COM_FL_SNO));
		vComFlVO.setFlOrgnFlNm(pdfFlNm);
		vComFlVO.setFlStrePth(uploadPath);
		vComFlVO.setFlStreFlNm(pdfFlNm);
		
		comFlDAO.insertOne(vComFlVO);
	
		vComFlBnchVO.setFlBnchPrntSeCd("FLSEDDC0");
		vComFlBnchVO.setFlBnchPrntKvl(String.valueOf(lBsnAssrncSno));
		vComFlBnchVO.setFlSno(vComFlVO.getFlSno());
		vComFlBnchVO.setFlSeCd("FLSEDDC0");
		vComFlBnchVO.setFlKindCd("FLSEDDC0");
		vComFlBnchVO.setFlDspOrd(new Integer(5));
		
		comFlBnchDAO.insertOne(vComFlBnchVO);		
		
		
		//image?��?�� ?��?��?��?���? 추�?
		for(HtmlConvertVO vHtmlConvertVO : lHtmlConvertVO){
			vComFlVO = new ComFlVO();
			vComFlVO.setFlSno(comFlDAO.genSeqNo("", ComConstants.HDR_COM_FL_SNO));
			vComFlVO.setFlOrgnFlNm(vHtmlConvertVO.getImgNames());
			vComFlVO.setFlStrePth(uploadPath);
			vComFlVO.setFlStreFlNm(vHtmlConvertVO.getImgNames());
			
			comFlDAO.insertOne(vComFlVO);
			
			vComFlBnchVO = new ComFlBnchVO();
			vComFlBnchVO.setFlBnchPrntSeCd("FLSEDDC0");
			vComFlBnchVO.setFlBnchPrntKvl(String.valueOf(lBsnAssrncSno));
			vComFlBnchVO.setFlSno(vComFlVO.getFlSno());
			vComFlBnchVO.setFlSeCd("FLSEDDC0");
			vComFlBnchVO.setFlKindCd("FLSEDDC0");
			
			comFlBnchDAO.insertOne(vComFlBnchVO);					
		}
		
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************	 */
	@Override
	public Map<String,Object> selectListBizWithTrmnat(WeatherVO vDdcBsnAssrncVO) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap = ddcBsnAssrncDAO.selectBsnListWithTrmnat(vDdcBsnAssrncVO);
		
		map.put("resultList", resultMap.get("resultList"));
		
		return map;
	}
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : selectDetailDeductionBiz
	 * @?��  ?��  ?�� : 2018. 11. 6. ?��?�� 6:42:09
	 * @?��  ?��  ?�� : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************	 */
	@Override
	public Map<String,Object> selectListBizWithDmge(WeatherVO vDdcBsnAssrncVO) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap = ddcBsnAssrncDAO.selectBsnListWithDmge(vDdcBsnAssrncVO);
		
		List<WeatherVO> lDdcBsnList = new ArrayList<WeatherVO>();
		
		map.put("resultList", resultMap.get("resultList"));
		
		return map;
	}
	
	public String phoneUtil(String src) {
	    if (src == null) {
	      return "";
	    }
	    if (src.length() == 8) {
	      return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
	    } else if (src.length() == 12) {
	      return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
	    }
	    return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	  }

	/**
	 *********************************************************************************
	 * <pre>
	 * @?��  ?��  �? : deleteDeductionBiz
	 * @?��  ?��  ?�� : 2019. 2. 21. ?��?�� 4:22:20
	 * @?��  ?��  ?�� : jun
	 * @param svcVO
	 * @return 
	 * @throws Exception 
	 * @?��       �? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#deleteDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String, Object> deleteDeductionBiz(WeatherVO svcVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap  = new HashMap<String, Object>();
		
		WeatherVO updateBsnAssrncVO = new WeatherVO();
		BasMbrcoVO basMbrcoVO = new BasMbrcoVO();
		
		Long ddcAssrncSno = Long.parseLong(svcVO.getParTgtSno()); 

		//sno�? update?�� ?���? select
		svcVO.setDdcAssrncSno(ddcAssrncSno);
		updateBsnAssrncVO = ddcBsnAssrncDAO.selectOne(svcVO);
		
		//dlt_yn update
		updateBsnAssrncVO.setDltYn("Y");
		ddcBsnAssrncDAO.updateOne(updateBsnAssrncVO);
		
		//보증?��목록 select
		List<BasMbrcoVO> resultList = new ArrayList<BasMbrcoVO>();
		int resultCnt = 0;		

		map.put("resultList", resultList);
		map.put("resultCnt", resultCnt);
		
		return map;
	}	
	
	@Override
	public Map<String,Object> searchCredtIndt(BasMbrcoVO svcVO) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		Socket socket = new Socket("10.94.50.40",29861);
		
		System.out.println("10.94.50.40" + " ?��결됨");
		
		return map;
	}
	
}
