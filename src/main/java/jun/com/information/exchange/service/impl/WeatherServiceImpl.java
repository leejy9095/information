package jun.com.information.exchange.service.impl;
/**
 *********************************************************************************
 * <pre>
 * ?åå   ?ùº   Î™? : MngBizServiceImpl.java
 * Class OR Interface Î™?  : MngBizServiceImpl
 * ?óÖ   Î¨?   Î™? : 
 * ?Ñ§         Î™? : 
 * ?ûë   ?Ñ±   ?ûê : LJH
 * ?ûë   ?Ñ±   ?ùº : 2018. 10. 25. ?ò§?õÑ 8:26:20
 * Version : 1.0 
 * Î≥? Í≤?  ?ù¥ ?†• [?ûë?óÖ?ûê(Î≤ÑÏ†Ñ) | ?ûë?óÖ?ùº?ûê | ?ûë?óÖ?Ç¥?ö©]
 * ------------------------------------------------------------------------------
 *   LJH(V1.0) | 2018. 10. 25. ?ò§?õÑ 8:26:20 | 
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
 * Class OR Interface Î™? : DeductionBizServiceImpl
 * ?Ñ§Î™? : 
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
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
		
		Long lMbrcoSno = Long.parseLong(vDdcBsnAssrncVO.getParTgtSno()); //?öå?õê?Ç¨ ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
		
		vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);			
		vDdcBsnAssrncVO.setDdcSeCd(vDdcBsnAssrncVO.getParSrchOpt9());
		
		mDdcBsnAssrncList = ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO);
		
		lDataList = (List<WeatherVO>)mDdcBsnAssrncList.get("resultList");
		
		//?ó∞?ÜçÍ∞??ûÖ?ÖÑ?àò
		Double iCsctYr = selectCsctJoinYrCnt(lMbrcoSno);
		map.put("csctYr", iCsctYr); 
		
		BasMbrcoVO vBasMbrcoVO = new BasMbrcoVO();
		vBasMbrcoVO.setMbrcoSno(lMbrcoSno);
		vBasMbrcoVO = basMbrcoDAO.selectOne(vBasMbrcoVO);
				
		map.put("mbrcoInfo", vBasMbrcoVO);
			
		/**
		 * Í≥µÎèô???ëú Î™©Î°ù
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
		 * ?öå?õê?Ç¨ Îß§Ï∂ú?ï°?†ïÎ≥?
		 */
		BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
		vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
		
		map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
		
		HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
		
		cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// Ïß??ó≠Íµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("TASE"));  // Ïß??†êÍµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?òÅ?óÖ?ÉÅ?ÉúÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?ã†?ö©?ì±Í∏?
		cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?ã†?ö©Ï°∞Ìöå Í≤∞Í≥º
		cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
		cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
		cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
		
		map.put("cds", cds);
			
		
		
		return map;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
			Long lMbrcoSno = Long.parseLong(vDdcBsnAssrncVO.getParTgtSno()); //?öå?õê?Ç¨ ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
			
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
			
			//?ó∞?ÜçÍ∞??ûÖ?ÖÑ?àò
			Double iCsctYr = selectCsctJoinYrCnt(lMbrcoSno);
			map.put("csctYr", iCsctYr); 
			
			BasMbrcoIndtVO indVO = new BasMbrcoIndtVO();
			indVO.setMbrcoSno(lMbrcoSno);
			indVO.setIndtCd(vDdcBsnAssrncVO.getParSrchOpt3());
			
			indVO = basMbrcoIndtDAO.selectOne(indVO);
			
			map.put("indtInfo", indVO);
			
			//?ï¥?ãπ ?öå?õê?Ç¨Î°? ?òÅ?óÖÎ≥¥Ï¶ù?ù¥ ?ì±Î°ùÎêúÍ≤? ?ûà?úºÎ©? ÎßàÏ?Îß? ?òÅ?óÖÎ≥¥Ï¶ù?†ïÎ≥? set
			if(Integer.parseInt(mDdcBsnAssrncList.get("resultCnt").toString()) > 0){
				WeatherVO vDetailDdcBsnAssrncVO = lDataList.get(0); 
				
				map.put("biz", lDataList.get(0));
				
				long lDdcBsnAssrncSno = vDetailDdcBsnAssrncVO.getDdcAssrncSno();
				
				//Ïß??ó≠?†ú?ñ¥ ?ôï?ù∏
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
						
						List<RgnCtrlVO> lCtrlList = new ArrayList<RgnCtrlVO>();		//?òÑ?û¨?ùº?ûê?óê ?†ú?ñ¥?ù∏ Î¶¨Ïä§?ä∏Î™©Î°ù
						lCtrlList =  (List<RgnCtrlVO>) rgnCtrlDAO.selectListNowCtrl(vNowSrchVO).get("resultList");
						if(lCtrlList.size()>0){
							map.put("ctrlYn", "N");
						}
					}
				}
				
				//Í¥?Î¶¨Î©îÎ™?
				Map<String,Object> mMngMmo = new HashMap<String, Object>();
				BasMngMmoVO vBasMngMmoVO = new BasMngMmoVO();
				vBasMngMmoVO.setRefSe("RFSEBSNASSRNC"); //Í¥?Î¶¨Î©îÎ™? ?òÅ?óÖÎ≥¥Ï¶ùÏΩîÎìú?Ñ∏?åÖ
				vBasMngMmoVO.setRefSno(lDdcBsnAssrncSno); //?òÅ?óÖÎ≥¥Ï¶ù ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
				
				mMngMmo = mngService.selectListMngMmo("",vBasMngMmoVO);
				
				map.put("mmo", mMngMmo.get("resultList"));
				
				
				//?ûÖÍ∏àÏ†ïÎ≥?
				List<DdcRcpmInfVO> lDdcRcpmInf = new ArrayList<DdcRcpmInfVO>();
				DdcRcpmInfVO vDdcRcpmInfVO = new DdcRcpmInfVO();
				vDdcRcpmInfVO.setDdcAssrncSno(lDdcBsnAssrncSno);				
				
				lDdcRcpmInf = (List<DdcRcpmInfVO>) ddcRcpmInfDAO.selectList(vDdcRcpmInfVO).get("resultList");
				
				map.put("rcpm", lDdcRcpmInf);
				
				//?ã¨?Ç¨?†ïÎ≥?
				List<DdcJdgmnVO> lDdcJdgmn = new ArrayList<DdcJdgmnVO>();
				DdcJdgmnVO vDdcJdgmnVO = new DdcJdgmnVO();
				vDdcJdgmnVO.setDdcAssrncSno(lDdcBsnAssrncSno);				
				
				lDdcJdgmn = (List<DdcJdgmnVO>) ddcJdgmnDAO.selectListDeductionJdgmn(vDdcJdgmnVO).get("resultList");
				
				map.put("jdgmn", lDdcJdgmn);
				
				//?ûÖÍ∏àÏ†ïÎ≥?
				List<ComFlBnchVO> lFlData = new ArrayList<ComFlBnchVO>();
				
				lFlData = comFlBnchDAO.selectListFileGroupByPrntSe("FLSEDDC1", lDdcBsnAssrncSno);
				
				map.put("flList", lFlData);
				
				//?ïú?èÑ?ÉÅ?ñ•
				DdcLmtApprvVO vDdcLmtApprvVO = new DdcLmtApprvVO();
				vDdcLmtApprvVO.setDdcAssrncSno(lDdcBsnAssrncSno);
				
				vDdcLmtApprvVO = ddcLmtApprvDAO.selectOneWithDdcSno(vDdcLmtApprvVO);
				
				map.put("lmtApprv", vDdcLmtApprvVO);
				
				//?†Ñ?ûê?ÑúÎ™? ?†ïÎ≥?
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
				
				
			}else{ //Í∏∞ÏóÖ?†ïÎ≥¥Îßå ?Ñ∏?åÖ
				BasMbrcoVO vBasMbrcoVO = new BasMbrcoVO();
				vBasMbrcoVO.setMbrcoSno(lMbrcoSno);
				vBasMbrcoVO = basMbrcoDAO.selectOne(vBasMbrcoVO);
				
				
				//vBasMbrcoVO.setBrthdy(util.decrypt(vBasMbrcoVO.getBrthdy()));
				//vBasMbrcoVO.setEml(util.decrypt(vBasMbrcoVO.getEml()));
				vBasMbrcoVO.setParSrchOpt1(vDdcBsnAssrncVO.getParSrchOpt1());
				
				map.put("mbrcoInfo", vBasMbrcoVO);
				
				
			}
			
	
			/**
			 * Í≥µÎèô???ëú Î™©Î°ù
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
			 * ?öå?õê?Ç¨ Îß§Ï∂ú?ï°?†ïÎ≥?
			 */
			BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
			vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
			
			map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
			
			HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
			
			cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// Ïß??ó≠Íµ¨Î∂ÑÏΩîÎìú
			cds.putAll(comSeService.selectCodeSelMap("TASE"));  // Ïß??†êÍµ¨Î∂ÑÏΩîÎìú
			cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?òÅ?óÖ?ÉÅ?ÉúÏΩîÎìú
			cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?ã†?ö©?ì±Í∏?
			cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?ã†?ö©Ï°∞Ìöå Í≤∞Í≥º
			cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
			cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
			cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
			cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
			
			map.put("cds", cds);
			
		}
		
		return map;
	}
	
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?ï®  ?àò  Î™? : insertDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
			vDdcBsnAssrncVO.setEndrsYn("EDST10"); //?ã†Í∑úÎì±Î°? ?ú†?ö®Ï¶ùÏÑú
			vDdcBsnAssrncVO.setCntrctAmt(0L);
			vDdcBsnAssrncVO.setFrstRgtDttm("__SYSDATE__");
			vDdcBsnAssrncVO.setRcntChngDttm("__SYSDATE__");
			vDdcBsnAssrncVO.setDdcStplatAgreDttm("__SYSDATE__");
			lBsnAssrncSno = ddcBsnAssrncDAO.insertOneAutoIdx(vDdcBsnAssrncVO);
			
			//?ã†Í∑úÎì±Î°ùÏãú?óêÎß? ?åå?ùº Ï∂îÍ?
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
					if(vDdcBsnAssrncVO.getIndtCd().equals("INDT100")){ //Íµ??ô∏
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
		
		//?ïú?èÑ?ÉÅ?ñ•?ã†Ï≤?
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
		
		
		//Î≥¥Ï¶ù?ù∏?†ïÎ≥?
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
		 * Îß§Ï∂ú?ï°?†ïÎ≥? upsert
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
		 * Í¥?Î¶¨Î©îÎ™? ?ûÖ?†•
		 * Í¥?Î¶¨Î©îÎ™? ?öå?õê?Ç¨ ÏΩîÎìú - RFSEMBRCO
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
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Map<String,Object> selectUpdateDeductionBiz(WeatherVO svcVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		Long lDdcBsnAssrncSno = Long.parseLong(svcVO.getParTgtSno()); //?öå?õê?Ç¨ ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
		
		//Long lDdcBsnAssrncSno = svcVO.getBsnAssrncSno(); //?öå?õê?Ç¨ ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
		
		Map<String, Object> mDdcBsnAssrncList = new HashMap<String, Object>();		
		
		WeatherVO vDdcBsnAssrncVO = new WeatherVO(); 
		vDdcBsnAssrncVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		vDdcBsnAssrncVO = ddcBsnAssrncDAO.selectOne(vDdcBsnAssrncVO);
			
	/*	if(vDdcBsnAssrncVO.getAplrEml() != null && vDdcBsnAssrncVO.getAplrEml() != ""){
			vDdcBsnAssrncVO.setAplrEml(util.decrypt(vDdcBsnAssrncVO.getAplrEml()));
		}*/
		
		map.put("biz", vDdcBsnAssrncVO);		
		
		//Ïß??ó≠?†ú?ñ¥ ?ôï?ù∏
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
				
				List<RgnCtrlVO> lCtrlList = new ArrayList<RgnCtrlVO>();		//?òÑ?û¨?ùº?ûê?óê ?†ú?ñ¥?ù∏ Î¶¨Ïä§?ä∏Î™©Î°ù
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
		vBasMngMmoVO.setRefSe("RFSEBSNASSRNC"); //Í¥?Î¶¨Î©îÎ™? ?òÅ?óÖÎ≥¥Ï¶ùÏΩîÎìú?Ñ∏?åÖ
		vBasMngMmoVO.setRefSno(lDdcBsnAssrncSno); //?òÅ?óÖÎ≥¥Ï¶ù ?ùº?†®Î≤àÌò∏ ?Ñ∏?åÖ
		
		mMngMmo = mngService.selectListMngMmo("",vBasMngMmoVO);
		
		map.put("mmo", mMngMmo.get("resultList"));
		
		
		/**
		 * Í≥µÎèô???ëú Î™©Î°ù
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
		
		//?ã¨?Ç¨?†ïÎ≥?
		List<DdcJdgmnVO> lDdcJdgmn = new ArrayList<DdcJdgmnVO>();
		DdcJdgmnVO vDdcJdgmnVO = new DdcJdgmnVO();
		vDdcJdgmnVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcJdgmn = (List<DdcJdgmnVO>) ddcJdgmnDAO.selectListDeductionJdgmn(vDdcJdgmnVO).get("resultList");
		
		map.put("jdgmn", lDdcJdgmn);
		
		//?ïú?èÑ?ÉÅ?ñ•
		DdcLmtApprvVO vDdcLmtApprvVO = new DdcLmtApprvVO();
		vDdcLmtApprvVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		vDdcLmtApprvVO = ddcLmtApprvDAO.selectOneWithDdcSno(vDdcLmtApprvVO);
		
		map.put("lmtApprv", vDdcLmtApprvVO);
		
		//?ûÖÍ∏àÏ†ïÎ≥?
		List<DdcRcpmInfVO> lDdcRcpmInf = new ArrayList<DdcRcpmInfVO>();
		DdcRcpmInfVO vDdcRcpmInfVO = new DdcRcpmInfVO();
		vDdcRcpmInfVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcRcpmInf = (List<DdcRcpmInfVO>) ddcRcpmInfDAO.selectList(vDdcRcpmInfVO).get("resultList");
		
		map.put("rcpm", lDdcRcpmInf);
		
		//?†Ñ?ûê?ÑúÎ™? ?†ïÎ≥?
		List<DdcElctrnSignVO> lDdcSign = new ArrayList<DdcElctrnSignVO>();
		DdcElctrnSignVO vDdcElctrnSignVO = new DdcElctrnSignVO();
		vDdcElctrnSignVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcSign = (List<DdcElctrnSignVO>) ddcElctrnSignDAO.selectList(vDdcElctrnSignVO).get("resultList");
		
		map.put("sign", lDdcSign);
		
		
		/**
		 * ?öå?õê?Ç¨ Îß§Ï∂ú?ï°?†ïÎ≥?
		 */
		BasMbrcoSlsVO vBasMbrcoSlsVO = new BasMbrcoSlsVO();
		vBasMbrcoSlsVO.setMbrcoSno(lMbrcoSno);
		
		map.put("slsList", basMbrcoSlsDAO.selectList(vBasMbrcoSlsVO).get("resultList"));
		
		//?ûÖÍ∏àÏ†ïÎ≥?
		List<ComFlBnchVO> lFlData = new ArrayList<ComFlBnchVO>();
		
		lFlData = comFlBnchDAO.selectListFileGroupByPrntSe("FLSEDDC1", lDdcBsnAssrncSno);
		
		map.put("flList", lFlData);
		
		/**
		 * Î≥¥Ï¶ù?ù∏ Î™©Î°ù
		*/
		
		List<DdcSldrtyAssrncVO> lDdcSldrtyList = new ArrayList<DdcSldrtyAssrncVO>();
		DdcSldrtyAssrncVO vDdcSldrtyAssrncVO = new DdcSldrtyAssrncVO();
		vDdcSldrtyAssrncVO.setDdcAssrncSno(lDdcBsnAssrncSno);
		
		lDdcSldrtyList = (List<DdcSldrtyAssrncVO>) ddcSldrtyAssrncDAO.selectList(vDdcSldrtyAssrncVO).get("resultList");
		
		map.put("grntrList", lDdcSldrtyList);
		
		HashMap<String, List<Object>> cds = new HashMap<String, List<Object>>();
		
		cds.putAll(comSeService.selectCodeSelMap("LOSE"));	// Ïß??ó≠Íµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("TASE"));  // Ïß??†êÍµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("BUST"));  // ?òÅ?óÖ?ÉÅ?ÉúÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("CDGR"));  // ?ã†?ö©?ì±Í∏?
		cds.putAll(comSeService.selectCodeSelMap("CDRS"));  // ?ã†?ö©Ï°∞Ìöå Í≤∞Í≥º
		cds.putAll(comSeService.selectCodeSelMap("CDTG"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
		cds.putAll(comSeService.selectCodeSelMap("JDRS"));  // ?ã†?ö©Ï°∞Ìöå ???ÉÅ
		cds.putAll(comSeService.selectCodeSelMap("FLKN"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
		cds.putAll(comSeService.selectCodeSelMap("SGSE"));  // ?†Ñ?ûê?ÑúÎ™ÖÍµ¨Î∂?
		cds.putAll(comSeService.selectCodeSelMap("SGKD"));  // ?†Ñ?ûê?ÑúÎ™ÖÎ∞©Î≤?
		cds.putAll(comSeService.selectCodeSelMap("SASE"));  // ?åå?ùºÍµ¨Î∂ÑÏΩîÎìú
		
		map.put("cds", cds);
		
		return map;
	}
	
	/**
	 *********************************************************************************
	 * <pre>
	 * @?ï®  ?àò  Î™? : UpdateAplStpDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param sLoseNo
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : ?òÅ?óÖÎ≥¥Ï¶ù?ùò ?ÉÅ?ÉúÎ•? ?óÖ?ç∞?ù¥?ä∏?ïú?ã§
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
			vUpdateDdcBsnAssrncVO.setEdycApprvYnWithMark("Y"); //Ï¶ùÏÑú?äπ?ù∏?ó¨Î∂? Y
			vUpdateDdcBsnAssrncVO.setEdycPubYnWithMark("Y"); //Î∞úÌñâ?ó¨Î∂? Y
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
	 * @?ï®  ?àò  Î™? : extractBizEdcyNo
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param sLoseNo
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : ?òÅ?óÖÎ≥¥Ï¶ù Ï¶ùÏÑúÎ≤àÌò∏Î•? Î¶¨ÌÑ¥?ï¥Ï§??ã§
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
		int year = cal.get(cal.YEAR); //?òÑ?û¨?ÖÑ?èÑ
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
	 * @?ï®  ?àò  Î™? : selectCsctJoinYrCnt
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param lMbrcoSno
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : ?ï¥?ãπ Í∏∞ÏóÖ?ùò ?ó∞?ÜçÍ∞??ûÖ?ÖÑ?èÑÎ•? Ï°∞Ìöå?ïú?ã§
	 *  
	 * @see WeatherService.custom.deduction.biz.service.DeductionBizService#selectDetailDeductionBiz(WeatherVO.custom.deduction.biz.service.DdcBsnAssrncVO)
	 * </pre>
	 *********************************************************************************
	 */
	@Override
	public Double selectCsctJoinYrCnt(long lMbrcoSno) throws Exception{
		Double iCsctJoinYrCnt = 0D;
		
		//Ïß?Í∏?, Í≥ÑÏïΩÎ≥¥Ï¶ùÍµ¨ÌòÑ ?õÑ Ï∂îÍ??ïÑ?öî
		WeatherVO vDdcBsnAssrncVO = new WeatherVO();
		Map<String, Object> map = new HashMap<String, Object>();
		List<WeatherVO> lDdcBsnAssrnc = new ArrayList<WeatherVO>();
		vDdcBsnAssrncVO.setMbrcoSno(lMbrcoSno);
		vDdcBsnAssrncVO.setEdycApprvYn("Y"); //?äπ?ù∏?êú Ï¶ùÏÑú Ï°∞Ìöå
		vDdcBsnAssrncVO.setDdcSeCd("DDSEBSN");
		
		lDdcBsnAssrnc = (List<WeatherVO>) ddcBsnAssrncDAO.selectList(vDdcBsnAssrncVO).get("resultList");
		
		
			
		if(lDdcBsnAssrnc.size() > 0){
			vDdcBsnAssrncVO = lDdcBsnAssrnc.get(0); //?Ç†Ïß? desc 0Î≤àÏ?∞Í? Í∞??û• ÏµúÍ∑º Ï¶ùÏÑú
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
	 * @?ï®  ?àò  Î™? : makeBsnImgFile
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param lBsnAssrncSno
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : ?òÅ?óÖÎ≥¥Ï¶ù ?åå?ùº ?Éù?Ñ±
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
		
		//1?éò?ù¥Ïß? ?†ïÎ≥? ?Ñ∏?åÖ ?ãú?ûë
		HtmlConvertVO htmlConvertVO = new HtmlConvertVO();		
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		Map<String, Object> value1 = new HashMap<String, Object>();
		value1.put("edycNo", "?†ú "+vDdcBsnAssrncVO.getEdycNo()+" ?ò∏");
		value1.put("ipsNm", vDdcBsnAssrncVO.getIpsNm());
		value1.put("addr",  "("+vDdcBsnAssrncVO.getZip()+")"+vDdcBsnAssrncVO.getAddrBas() + " " + vDdcBsnAssrncVO.getAddrDtl());
		value1.put("mbrcoNm", vDdcBsnAssrncVO.getMbrcoNm());
		value1.put("ceoNm", vDdcBsnAssrncVO.getCeoNm());
		value1.put("mbrcoRgtno", vDdcBsnAssrncVO.getMbrcoRgtno());
		value1.put("indtNm", vDdcBsnAssrncVO.getIndtNm());
		value1.put("rprTelno", phoneUtil(vDdcBsnAssrncVO.getRprTelno()));
		value1.put("rprFaxno", phoneUtil(vDdcBsnAssrncVO.getRprFaxno()));
		value1.put("ddcAmt",df.format(vDdcBsnAssrncVO.getDdcAmt()) + "?õê");
		value1.put("shareAmt",df.format(vDdcBsnAssrncVO.getShareAmt())+ "?õê");	
		value1.put("bsrno", vDdcBsnAssrncVO.getBsrno().substring(0,3) + "-" + vDdcBsnAssrncVO.getBsrno().substring(3,5) + "-" + vDdcBsnAssrncVO.getBsrno().substring(5,10));
		
		String[] aBgnDt = vDdcBsnAssrncVO.getDdcBgnDttm().split("-");
		String[] aEndDt = vDdcBsnAssrncVO.getDdcEndDttm().split("-");
		String[] aPubDttm = vDdcBsnAssrncVO.getEdycPubDttm().split(" ");
		value1.put("ddcTerm", aBgnDt[0]+"?ÖÑ "+aBgnDt[1]+"?õî "+aBgnDt[2]+"?ùº (24?ãúÎ∂??Ñ∞) ~ "+aEndDt[0]+"?ÖÑ "+aEndDt[1]+"?õî "+aEndDt[2]+"?ùº (24?ãú ÍπåÏ?) 365?ùºÍ∞? ");
		value1.put("edycPubDttm", aPubDttm[0].split("-")[0] + "?ÖÑ " + aPubDttm[0].split("-")[1]+ "?õî "+ aPubDttm[0].split("-")[2]+ "?ùº ");
		value1.put("spcablMttr", vDdcBsnAssrncVO.getSpcablMttr() == null ? "" : vDdcBsnAssrncVO.getSpcablMttr());
		
		String nowDt = aPubDttm[0].replaceAll("[-]","");
		
		htmlConvertVO.setTypes(docForm1);
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-1.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(2));
		
		lHtmlConvertVO.add(htmlConvertVO);
		//1?éò?ù¥Ïß? ?†ïÎ≥? ?Ñ∏?åÖ ?Åù
		
		htmlConvertVO = new HtmlConvertVO();
		htmlConvertVO.setTypes(docForm4);
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-view.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(1));
		lHtmlConvertVO.add(htmlConvertVO);
		
		//2?éò?ù¥Ïß??†ïÎ≥? ?Ñ∏?åÖ
		htmlConvertVO = new HtmlConvertVO();
		value1 = new HashMap<String, Object>();
		htmlConvertVO.setTypes("bsn_doc_2.html");
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-2.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(3));
		
		lHtmlConvertVO.add(htmlConvertVO);
		
		//3?éò?ù¥Ïß? ?†ïÎ≥? ?Ñ∏?åÖ
		htmlConvertVO = new HtmlConvertVO();
		value1 = new HashMap<String, Object>();
		value1.put("mbrcoNm", vDdcBsnAssrncVO.getMbrcoNm()+" Í∑?Ï§?");
		value1.put("edycNo", "Ï¶ùÏÑúÎ≤àÌò∏ ?†ú "+vDdcBsnAssrncVO.getEdycNo()+" ?ò∏");
		value1.put("ddcAmt",df.format(vDdcBsnAssrncVO.getDdcAmt()) + "?õê");
		value1.put("ipsNm", vDdcBsnAssrncVO.getIpsNm());
		value1.put("shareAmt",df.format(vDdcBsnAssrncVO.getShareAmt())+ "?õê");	
		value1.put("ddcTerm", aBgnDt[0]+"?ÖÑ "+aBgnDt[1]+"?õî "+aBgnDt[2]+"?ùº (24?ãúÎ∂??Ñ∞) ~ "+aEndDt[0]+"?ÖÑ "+aEndDt[1]+"?õî "+aEndDt[2]+"?ùº (24?ãú ÍπåÏ?) 365?ùºÍ∞? ");
		value1.put("edycPubDttm", aPubDttm[0].split("-")[0] + "?ÖÑ " + aPubDttm[0].split("-")[1]+ "?õî "+ aPubDttm[0].split("-")[2]+ "?ùº ");
		
		
		htmlConvertVO.setTypes("bsn_doc_3.html");
		htmlConvertVO.setImgNames(vDdcBsnAssrncVO.getEdycNo()+"-3.png");
		htmlConvertVO.setValues(value1);
		htmlConvertVO.setPathDt(nowDt + "/"+vDdcBsnAssrncVO.getDdcSeCd()+"/");
		htmlConvertVO.setDdcSeCd(vDdcBsnAssrncVO.getDdcSeCd());
		htmlConvertVO.setFlDspOrd(new Integer(4));
		
		lHtmlConvertVO.add(htmlConvertVO);
		
		value1 = new HashMap<String, Object>();
		
		String pdfFlNm = vDdcBsnAssrncVO.getEdycNo()+".pdf";
		//?Éù?Ñ±?ï† pdf Î™?		
		HtmlConvertUtil.htmlConvert(lHtmlConvertVO,pdfFlNm);		
		
		String uploadPath = "upload/"+nowDt+"/"+vDdcBsnAssrncVO.getDdcSeCd();
		
		//pdf?åå?ùº ?åå?ùº?Öå?ù¥Î∏? Ï∂îÍ?
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
		
		
		//image?åå?ùº ?åå?ùº?Öå?ù¥Î∏? Ï∂îÍ?
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
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
	 * @?ï®  ?àò  Î™? : selectDetailDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2018. 11. 6. ?ò§?õÑ 6:42:09
	 * @?ûë  ?Ñ±  ?ûê : yohan
	 * @param svcVO
	 * @return
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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
	 * @?ï®  ?àò  Î™? : deleteDeductionBiz
	 * @?ûë  ?Ñ±  ?ùº : 2019. 2. 21. ?ò§?õÑ 4:22:20
	 * @?ûë  ?Ñ±  ?ûê : jun
	 * @param svcVO
	 * @return 
	 * @throws Exception 
	 * @?Ñ§       Î™? : 
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

		//snoÎ°? update?ï† ?†ïÎ≥? select
		svcVO.setDdcAssrncSno(ddcAssrncSno);
		updateBsnAssrncVO = ddcBsnAssrncDAO.selectOne(svcVO);
		
		//dlt_yn update
		updateBsnAssrncVO.setDltYn("Y");
		ddcBsnAssrncDAO.updateOne(updateBsnAssrncVO);
		
		//Î≥¥Ï¶ù?ÑúÎ™©Î°ù select
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
		
		System.out.println("10.94.50.40" + " ?ó∞Í≤∞Îê®");
		
		return map;
	}
	
}
