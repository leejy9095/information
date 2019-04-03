package jun.com.information.exchange.service;

import withus21.cms.bas.service.BaseVO;

import withus21.cms.util.AESUtil;



public class __WeatherVO extends BaseVO {
	
	AESUtil util = new AESUtil();
	

	private String tblAlias = "da" ; //* table alias 

	private Long ddcAssrncSno; //* Í≥µÏ†ú Î≥¥Ï¶ù ?ùº?†®Î≤àÌò∏
	private String ddcSeCd; //* Í≥µÏ†ú Íµ¨Î∂Ñ ÏΩîÎìú
	private String edycNo; //* Ï¶ùÏÑú Î≤àÌò∏
	private String mlbxNo; //* ?Ç¨?Ñú?ï® Î≤àÌò∏
	private Long ipsSno; //* ?îºÎ≥¥Ìóò?ûê ?ùº?†®Î≤àÌò∏
	private String ipsCd; //* ?îºÎ≥¥Ìóò?ûê ÏΩîÎìú
	private String ipsNm; //* ?îºÎ≥¥Ìóò?ûê Î™?
	private String aplSeCd; //* ?ã†Ï≤? Íµ¨Î∂Ñ ÏΩîÎìú
	private String aplStpCd; //* ?ã†Ï≤? ?ã®Í≥? ÏΩîÎìú
	private Long mbrcoSno; //* ?öå?õê?Ç¨ ?ùº?†®Î≤àÌò∏
	private String jrrgno; //* Î≤ïÏù∏?ì±Î°ùÎ≤à?ò∏
	private String bsrno; //* ?Ç¨?óÖ?ûê?ì±Î°ùÎ≤à?ò∏
	private String mbrcoSeCd; //* ?öå?õê?Ç¨ Íµ¨Î∂Ñ ÏΩîÎìú
	private String mbrcoRgtno; //* ?öå?õê?Ç¨ ?ì±Î°ùÎ≤à?ò∏
	private String mbrcoNm; //* ?öå?õê?Ç¨ Î™?
	private String entSeCd; //* Í∏∞ÏóÖ Íµ¨Î∂Ñ ÏΩîÎìú
	private Long mbrcoCeoSno; //* ?öå?õê?Ç¨ ???ëú?ûê ?ùº?†®Î≤àÌò∏
	private String ceoNm; //* ???ëú?ûê Î™?
	private String ceoBrthdy; //* ???ëú?ûê ?Éù?ÖÑ?õî?ùº
	private String ceoRno; //* ???ëú?ûê Ï£ºÎ?ºÎì±Î°ùÎ≤à?ò∏
	private String copertnCeoYn; //* Í≥µÎèô ???ëú?ûê ?ó¨Î∂?
	private String zip; //* ?ö∞?é∏Î≤àÌò∏
	private String addrRgnCd; //* Ï£ºÏÜå Ïß??ó≠ ÏΩîÎìú
	private String addrBas; //* Ï£ºÏÜå Í∏∞Î≥∏
	private String addrDtl; //* Ï£ºÏÜå ?ÉÅ?Ñ∏
	private String indtCd; //* ?óÖÏ¢? ÏΩîÎìú
	private String sidjbYn; //* Í≤∏ÏóÖ ?ó¨Î∂?
	private String bustCd; //* ?òÅ?óÖ?ÉÅ?Éú ÏΩîÎìú
	private String rprTelno; //* ???ëú ?†Ñ?ôîÎ≤àÌò∏
	private String rprFaxno; //* ???ëú ?å©?ä§Î≤àÌò∏
	private String rprEml; //* ???ëú ?ù¥Î©îÏùº
	private Integer slsYr; //* Îß§Ï∂ú ?ÖÑ?èÑ
	private Long slsAmtDom; //* Îß§Ï∂ú Í∏àÏï° Íµ??Ç¥
	private Long slsAmtOvs; //* Îß§Ï∂ú Í∏àÏï° ?ï¥?ô∏
	private Long slsAmtEtc; //* Îß§Ï∂ú Í∏àÏï° Í∏∞Ì?
	private Long slsAmtSm; //* Îß§Ï∂ú Í∏àÏï° ?ï©Í≥?
	private Long ddcAmt; //* Í≥µÏ†ú Í∏àÏï°
	private Double csctJoinYrCnt; //* ?ó∞?Üç Í∞??ûÖ ?ÖÑ ?àò
	private String credtInqrTgtCd; //* ?ã†?ö© Ï°∞Ìöå ???ÉÅ ÏΩîÎìú
	private String credtInqrTgtNm; //* ?ã†?ö© Ï°∞Ìöå ???ÉÅ ?ù¥Î¶?
	private String credtInqrTgtBrthdy; //* ?ã†?ö© Ï°∞Ìöå ???ÉÅ ?Éù?ÖÑ?õî?ùº
	private String credtInqrDttm; //* ?ã†?ö© Ï°∞Ìöå ?ùº?ãú
	private String credtInqrRslt; //* ?ã†?ö© Ï°∞Ìöå Í≤∞Í≥º
	private String credtInqrRsltCd; //* ?ã†?ö© Ï°∞Ìöå Í≤∞Í≥º ÏΩîÎìú
	private Double joinTariff; //* Í∞??ûÖ ?öî?ú®
	private Long shareAmt; //* Î∂ÑÎã¥ Í∏àÏï°
	private String shareAmtRcpmDttm; //* Î∂ÑÎã¥ Í∏àÏï° ?ûÖÍ∏? ?ùº?ãú
	private String pprPrsntnCpltYn; //* ?ÑúÎ•? ?†úÏ∂? ?ôÑÎ£? ?ó¨Î∂?
	private String jdgmnStCd; //* ?ã¨?Ç¨ ?ÉÅ?Éú ÏΩîÎìú
	private String edycApprvYn; //* Ï¶ùÏÑú ?äπ?ù∏ ?ó¨Î∂?
	private String signCpltYn; //* ?ÑúÎ™? ?ôÑÎ£? ?ó¨Î∂?
	private String rcpmStCd; //* ?ûÖÍ∏? ?ÉÅ?Éú ÏΩîÎìú
	private String mbrcoRcpmYn; //* ?öå?õê?Ç¨ ?ûÖÍ∏? ?ó¨Î∂?
	private String edycPubYn; //* Ï¶ùÏÑú Î∞úÌñâ ?ó¨Î∂?
	private String edycPubDttm; //* Ï¶ùÏÑú Î∞úÌñâ ?ùº?ãú
	private String ddcBgnDttm; //* Í≥µÏ†ú ?ãú?ûë ?ùº?ãú
	private String ddcEndDttm; //* Í≥µÏ†ú Ï¢ÖÎ£å ?ùº?ãú
	private String spcablMttr; //* ?äπÍ∏? ?Ç¨?ï≠
	private String cntrctNm; //* Í≥ÑÏïΩ Î™?
	private String assrncCn; //* Î≥¥Ï¶ù ?Ç¥?ö©
	private String speclStplat; //* ?äπÎ≥? ?ïΩÍ¥?
	private Long cntrctAmt; //* Í≥ÑÏïΩ Í∏àÏï°
	private String pubAsocCd; //* Î∞úÌñâ ?òë?öå ÏΩîÎìú
	private String pubAsocNm; //* Î∞úÌñâ ?òë?öå Î™?
	private String aplrMbrSno; //* ?ã†Ï≤??ûê ?öå?õê ?ùº?†®Î≤àÌò∏
	private String aplrNm; //* ?ã†Ï≤??ûê ?ù¥Î¶?
	private String aplrPst; //* ?ã†Ï≤??ûê ?Üå?Üç
	private String aplrMbpno; //* ?ã†Ï≤??ûê ?ú¥???è∞Î≤àÌò∏
	private String aplrEml; //* ?ã†Ï≤??ûê ?ù¥Î©îÏùº
	private String endrsYn; //* Î∞∞ÏÑú ?ó¨Î∂?
	private String endrsRsn; //* Î∞∞ÏÑú ?Ç¨?ú†
	private String endrsStdDt; //* Î∞∞ÏÑú Í∏∞Ï? ?ùº
	private String planngAssrncYn; //* Í∏∞Ìöç Î≥¥Ï¶ù ?ó¨Î∂?
	private String lowCredtPermYn; //* ?? ?ã†?ö© ?óà?ö© ?ó¨Î∂?
	private String prdBgnDt; //* Í∏∞Í∞Ñ ?ãú?ûë ?ùº
	private String prdEndDt; //* Í∏∞Í∞Ñ Ï¢ÖÎ£å ?ùº
	private String trmnatExcclcDt; //* ?ï¥Ïß? ?†ï?Ç∞ ?ùº
	private String sssBgnDt; //* ?ú¥?óÖ ?ãú?ûë ?ùº
	private String sssEndDt; //* ?ú¥?óÖ Ï¢ÖÎ£å ?ùº
	private String ddcStplatAgreYn; //* Í≥µÏ†ú ?ïΩÍ¥? ?èô?ùò ?ó¨Î∂?
	private String ddcStplatAgreDttm; //* Í≥µÏ†ú ?ïΩÍ¥? ?èô?ùò ?ùº?ãú
	private String edycPrntngCnt; //* Î≥¥Ï¶ù Ï¶ùÏÑú ?ù∏?áÑ ?öü?àò
	private String edycDwldCnt; //* Î≥¥Ï¶ù Ï¶ùÏÑú ?ã§?ö¥Î°úÎìú ?öü?àò
	private String useYn; //* ?Ç¨?ö© ?ó¨Î∂?
	private String dltYn; //* ?Ç≠?†ú ?ó¨Î∂?
	private String frstRgtrMbrSno; //* ÏµúÏ¥à ?ì±Î°ùÏûê ?öå?õê ?ùº?†®Î≤àÌò∏
	private String frstRgtDttm; //* ÏµúÏ¥à ?ì±Î°? ?ùº?ãú
	private String frstRgtTrnstSno; //* ÏµúÏ¥à ?ì±Î°? ?ä∏?ûú?û≠?Öò ?ùº?†®Î≤àÌò∏
	private String rcntChngrMbrSno; //* ÏµúÍ∑º Î≥?Í≤ΩÏûê ?öå?õê ?ùº?†®Î≤àÌò∏
	private String rcntChngDttm; //* ÏµúÍ∑º Î≥?Í≤? ?ùº?ãú
	private String rcntChngTrnstSno; //* ÏµúÍ∑º Î≥?Í≤? ?ä∏?ûú?û≠?Öò ?ùº?†®Î≤àÌò∏


	public String getTblAlias(){
		return this.tblAlias;
	}
	public Long getDdcAssrncSno() {
		return this.ddcAssrncSno;
	}
	public void markDdcAssrncSno() {
		this.oprMap.put("__ddcAssrncSno", "o");
	}
	public void setDdcAssrncSno(Long ddcAssrncSno) throws Exception {
		this.ddcAssrncSno = ddcAssrncSno;
	}
	public void setDdcAssrncSnoWithMark(Long ddcAssrncSno) throws Exception {
		this.markDdcAssrncSno();
		this.setDdcAssrncSno(ddcAssrncSno);
	}
	public String getDdcSeCd() {
		return this.ddcSeCd;
	}
	public void markDdcSeCd() {
		this.oprMap.put("__ddcSeCd", "o");
	}
	public void setDdcSeCd(String ddcSeCd) throws Exception {
		this.ddcSeCd = ddcSeCd;
	}
	public void setDdcSeCdWithMark(String ddcSeCd) throws Exception {
		this.markDdcSeCd();
		this.setDdcSeCd(ddcSeCd);
	}
	public String getEdycNo() {
		return this.edycNo;
	}
	public void markEdycNo() {
		this.oprMap.put("__edycNo", "o");
	}
	public void setEdycNo(String edycNo) throws Exception {
		this.edycNo = edycNo;
	}
	public void setEdycNoWithMark(String edycNo) throws Exception {
		this.markEdycNo();
		this.setEdycNo(edycNo);
	}
	public String getMlbxNo() {
		return this.mlbxNo;
	}
	public void markMlbxNo() {
		this.oprMap.put("__mlbxNo", "o");
	}
	public void setMlbxNo(String mlbxNo) throws Exception {
		this.mlbxNo = mlbxNo;
	}
	public void setMlbxNoWithMark(String mlbxNo) throws Exception {
		this.markMlbxNo();
		this.setMlbxNo(mlbxNo);
	}
	public Long getIpsSno() {
		return this.ipsSno;
	}
	public void markIpsSno() {
		this.oprMap.put("__ipsSno", "o");
	}
	public void setIpsSno(Long ipsSno) throws Exception {
		this.ipsSno = ipsSno;
	}
	public void setIpsSnoWithMark(Long ipsSno) throws Exception {
		this.markIpsSno();
		this.setIpsSno(ipsSno);
	}
	public String getIpsCd() {
		return this.ipsCd;
	}
	public void markIpsCd() {
		this.oprMap.put("__ipsCd", "o");
	}
	public void setIpsCd(String ipsCd) throws Exception {
		this.ipsCd = ipsCd;
	}
	public void setIpsCdWithMark(String ipsCd) throws Exception {
		this.markIpsCd();
		this.setIpsCd(ipsCd);
	}
	public String getIpsNm() {
		return this.ipsNm;
	}
	public void markIpsNm() {
		this.oprMap.put("__ipsNm", "o");
	}
	public void setIpsNm(String ipsNm) throws Exception {
		this.ipsNm = ipsNm;
	}
	public void setIpsNmWithMark(String ipsNm) throws Exception {
		this.markIpsNm();
		this.setIpsNm(ipsNm);
	}
	public String getAplSeCd() {
		return this.aplSeCd;
	}
	public void markAplSeCd() {
		this.oprMap.put("__aplSeCd", "o");
	}
	public void setAplSeCd(String aplSeCd) throws Exception {
		this.aplSeCd = aplSeCd;
	}
	public void setAplSeCdWithMark(String aplSeCd) throws Exception {
		this.markAplSeCd();
		this.setAplSeCd(aplSeCd);
	}
	public String getAplStpCd() {
		return this.aplStpCd;
	}
	public void markAplStpCd() {
		this.oprMap.put("__aplStpCd", "o");
	}
	public void setAplStpCd(String aplStpCd) throws Exception {
		this.aplStpCd = aplStpCd;
	}
	public void setAplStpCdWithMark(String aplStpCd) throws Exception {
		this.markAplStpCd();
		this.setAplStpCd(aplStpCd);
	}
	public Long getMbrcoSno() {
		return this.mbrcoSno;
	}
	public void markMbrcoSno() {
		this.oprMap.put("__mbrcoSno", "o");
	}
	public void setMbrcoSno(Long mbrcoSno) throws Exception {
		this.mbrcoSno = mbrcoSno;
	}
	public void setMbrcoSnoWithMark(Long mbrcoSno) throws Exception {
		this.markMbrcoSno();
		this.setMbrcoSno(mbrcoSno);
	}
	public String getJrrgno() {
		return this.jrrgno;
	}
	public void markJrrgno() {
		this.oprMap.put("__jrrgno", "o");
	}
	public void setJrrgno(String jrrgno) throws Exception {
		this.jrrgno = jrrgno;
	}
	public void setJrrgnoWithMark(String jrrgno) throws Exception {
		this.markJrrgno();
		this.setJrrgno(jrrgno);
	}
	public String getBsrno() {
		return this.bsrno;
	}
	public void markBsrno() {
		this.oprMap.put("__bsrno", "o");
	}
	public void setBsrno(String bsrno) throws Exception {
		this.bsrno = bsrno;
	}
	public void setBsrnoWithMark(String bsrno) throws Exception {
		this.markBsrno();
		this.setBsrno(bsrno);
	}
	public String getMbrcoSeCd() {
		return this.mbrcoSeCd;
	}
	public void markMbrcoSeCd() {
		this.oprMap.put("__mbrcoSeCd", "o");
	}
	public void setMbrcoSeCd(String mbrcoSeCd) throws Exception {
		this.mbrcoSeCd = mbrcoSeCd;
	}
	public void setMbrcoSeCdWithMark(String mbrcoSeCd) throws Exception {
		this.markMbrcoSeCd();
		this.setMbrcoSeCd(mbrcoSeCd);
	}
	public String getMbrcoRgtno() {
		return this.mbrcoRgtno;
	}
	public void markMbrcoRgtno() {
		this.oprMap.put("__mbrcoRgtno", "o");
	}
	public void setMbrcoRgtno(String mbrcoRgtno) throws Exception {
		this.mbrcoRgtno = mbrcoRgtno;
	}
	public void setMbrcoRgtnoWithMark(String mbrcoRgtno) throws Exception {
		this.markMbrcoRgtno();
		this.setMbrcoRgtno(mbrcoRgtno);
	}
	public String getMbrcoNm() {
		return this.mbrcoNm;
	}
	public void markMbrcoNm() {
		this.oprMap.put("__mbrcoNm", "o");
	}
	public void setMbrcoNm(String mbrcoNm) throws Exception {
		this.mbrcoNm = mbrcoNm;
	}
	public void setMbrcoNmWithMark(String mbrcoNm) throws Exception {
		this.markMbrcoNm();
		this.setMbrcoNm(mbrcoNm);
	}
	public String getEntSeCd() {
		return this.entSeCd;
	}
	public void markEntSeCd() {
		this.oprMap.put("__entSeCd", "o");
	}
	public void setEntSeCd(String entSeCd) throws Exception {
		this.entSeCd = entSeCd;
	}
	public void setEntSeCdWithMark(String entSeCd) throws Exception {
		this.markEntSeCd();
		this.setEntSeCd(entSeCd);
	}
	public Long getMbrcoCeoSno() {
		return this.mbrcoCeoSno;
	}
	public void markMbrcoCeoSno() {
		this.oprMap.put("__mbrcoCeoSno", "o");
	}
	public void setMbrcoCeoSno(Long mbrcoCeoSno) throws Exception {
		this.mbrcoCeoSno = mbrcoCeoSno;
	}
	public void setMbrcoCeoSnoWithMark(Long mbrcoCeoSno) throws Exception {
		this.markMbrcoCeoSno();
		this.setMbrcoCeoSno(mbrcoCeoSno);
	}
	public String getCeoNm() {
		return this.ceoNm;
	}
	public void markCeoNm() {
		this.oprMap.put("__ceoNm", "o");
	}
	public void setCeoNm(String ceoNm) throws Exception {
		this.ceoNm = ceoNm;
	}
	public void setCeoNmWithMark(String ceoNm) throws Exception {
		this.markCeoNm();
		this.setCeoNm(ceoNm);
	}
	public String getCeoBrthdy() {
		if(this.ceoBrthdy != null){
			return invokerIsIbatis(__WeatherVO.class) ? this.ceoBrthdy : util.decrypt(this.ceoBrthdy);
		}else{
			return this.ceoBrthdy;
		}
	}
	public void markCeoBrthdy() {
		this.oprMap.put("__ceoBrthdy", "o");
	}
	public void setCeoBrthdy(String ceoBrthdy) throws Exception {
		if(ceoBrthdy != null){
			this.ceoBrthdy = invokerIsIbatis(__WeatherVO.class) ? ceoBrthdy : util.encrypt(ceoBrthdy);
		}else{
			this.ceoBrthdy = ceoBrthdy;
		}
	}
	public void setCeoBrthdyWithMark(String ceoBrthdy) throws Exception {
		this.markCeoBrthdy();
		this.setCeoBrthdy(ceoBrthdy);
	}
	public String getCeoRno() {
		if(this.ceoRno != null){
			return invokerIsIbatis(__WeatherVO.class) ? this.ceoRno : util.decrypt(this.ceoRno);
		}else{
			return this.ceoRno;
		}
	}
	public void markCeoRno() {
		this.oprMap.put("__ceoRno", "o");
	}
	public void setCeoRno(String ceoRno) throws Exception {
		if(ceoRno != null){
			this.ceoRno = invokerIsIbatis(__WeatherVO.class) ? ceoRno : util.encrypt(ceoRno);
		}else{
			this.ceoRno = ceoRno;
		}
	}
	public void setCeoRnoWithMark(String ceoRno) throws Exception {
		this.markCeoRno();
		this.setCeoRno(ceoRno);
	}
	public String getCopertnCeoYn() {
		return this.copertnCeoYn;
	}
	public void markCopertnCeoYn() {
		this.oprMap.put("__copertnCeoYn", "o");
	}
	public void setCopertnCeoYn(String copertnCeoYn) throws Exception {
		this.copertnCeoYn = copertnCeoYn;
	}
	public void setCopertnCeoYnWithMark(String copertnCeoYn) throws Exception {
		this.markCopertnCeoYn();
		this.setCopertnCeoYn(copertnCeoYn);
	}
	public String getZip() {
		return this.zip;
	}
	public void markZip() {
		this.oprMap.put("__zip", "o");
	}
	public void setZip(String zip) throws Exception {
		this.zip = zip;
	}
	public void setZipWithMark(String zip) throws Exception {
		this.markZip();
		this.setZip(zip);
	}
	public String getAddrRgnCd() {
		return this.addrRgnCd;
	}
	public void markAddrRgnCd() {
		this.oprMap.put("__addrRgnCd", "o");
	}
	public void setAddrRgnCd(String addrRgnCd) throws Exception {
		this.addrRgnCd = addrRgnCd;
	}
	public void setAddrRgnCdWithMark(String addrRgnCd) throws Exception {
		this.markAddrRgnCd();
		this.setAddrRgnCd(addrRgnCd);
	}
	public String getAddrBas() {
		return this.addrBas;
	}
	public void markAddrBas() {
		this.oprMap.put("__addrBas", "o");
	}
	public void setAddrBas(String addrBas) throws Exception {
		this.addrBas = addrBas;
	}
	public void setAddrBasWithMark(String addrBas) throws Exception {
		this.markAddrBas();
		this.setAddrBas(addrBas);
	}
	public String getAddrDtl() {
		return this.addrDtl;
	}
	public void markAddrDtl() {
		this.oprMap.put("__addrDtl", "o");
	}
	public void setAddrDtl(String addrDtl) throws Exception {
		this.addrDtl = addrDtl;
	}
	public void setAddrDtlWithMark(String addrDtl) throws Exception {
		this.markAddrDtl();
		this.setAddrDtl(addrDtl);
	}
	public String getIndtCd() {
		return this.indtCd;
	}
	public void markIndtCd() {
		this.oprMap.put("__indtCd", "o");
	}
	public void setIndtCd(String indtCd) throws Exception {
		this.indtCd = indtCd;
	}
	public void setIndtCdWithMark(String indtCd) throws Exception {
		this.markIndtCd();
		this.setIndtCd(indtCd);
	}
	public String getSidjbYn() {
		return this.sidjbYn;
	}
	public void markSidjbYn() {
		this.oprMap.put("__sidjbYn", "o");
	}
	public void setSidjbYn(String sidjbYn) throws Exception {
		this.sidjbYn = sidjbYn;
	}
	public void setSidjbYnWithMark(String sidjbYn) throws Exception {
		this.markSidjbYn();
		this.setSidjbYn(sidjbYn);
	}
	public String getBustCd() {
		return this.bustCd;
	}
	public void markBustCd() {
		this.oprMap.put("__bustCd", "o");
	}
	public void setBustCd(String bustCd) throws Exception {
		this.bustCd = bustCd;
	}
	public void setBustCdWithMark(String bustCd) throws Exception {
		this.markBustCd();
		this.setBustCd(bustCd);
	}
	public String getRprTelno() {
		return this.rprTelno;
	}
	public void markRprTelno() {
		this.oprMap.put("__rprTelno", "o");
	}
	public void setRprTelno(String rprTelno) throws Exception {
		this.rprTelno = rprTelno;
	}
	public void setRprTelnoWithMark(String rprTelno) throws Exception {
		this.markRprTelno();
		this.setRprTelno(rprTelno);
	}
	public String getRprFaxno() {
		return this.rprFaxno;
	}
	public void markRprFaxno() {
		this.oprMap.put("__rprFaxno", "o");
	}
	public void setRprFaxno(String rprFaxno) throws Exception {
		this.rprFaxno = rprFaxno;
	}
	public void setRprFaxnoWithMark(String rprFaxno) throws Exception {
		this.markRprFaxno();
		this.setRprFaxno(rprFaxno);
	}
	public String getRprEml() {
		return this.rprEml;
	}
	public void markRprEml() {
		this.oprMap.put("__rprEml", "o");
	}
	public void setRprEml(String rprEml) throws Exception {
		this.rprEml = rprEml;
	}
	public void setRprEmlWithMark(String rprEml) throws Exception {
		this.markRprEml();
		this.setRprEml(rprEml);
	}
	public Integer getSlsYr() {
		return this.slsYr;
	}
	public void markSlsYr() {
		this.oprMap.put("__slsYr", "o");
	}
	public void setSlsYr(Integer slsYr) throws Exception {
		this.slsYr = slsYr;
	}
	public void setSlsYrWithMark(Integer slsYr) throws Exception {
		this.markSlsYr();
		this.setSlsYr(slsYr);
	}
	public Long getSlsAmtDom() {
		return this.slsAmtDom;
	}
	public void markSlsAmtDom() {
		this.oprMap.put("__slsAmtDom", "o");
	}
	public void setSlsAmtDom(Long slsAmtDom) throws Exception {
		this.slsAmtDom = slsAmtDom;
	}
	public void setSlsAmtDomWithMark(Long slsAmtDom) throws Exception {
		this.markSlsAmtDom();
		this.setSlsAmtDom(slsAmtDom);
	}
	public Long getSlsAmtOvs() {
		return this.slsAmtOvs;
	}
	public void markSlsAmtOvs() {
		this.oprMap.put("__slsAmtOvs", "o");
	}
	public void setSlsAmtOvs(Long slsAmtOvs) throws Exception {
		this.slsAmtOvs = slsAmtOvs;
	}
	public void setSlsAmtOvsWithMark(Long slsAmtOvs) throws Exception {
		this.markSlsAmtOvs();
		this.setSlsAmtOvs(slsAmtOvs);
	}
	public Long getSlsAmtEtc() {
		return this.slsAmtEtc;
	}
	public void markSlsAmtEtc() {
		this.oprMap.put("__slsAmtEtc", "o");
	}
	public void setSlsAmtEtc(Long slsAmtEtc) throws Exception {
		this.slsAmtEtc = slsAmtEtc;
	}
	public void setSlsAmtEtcWithMark(Long slsAmtEtc) throws Exception {
		this.markSlsAmtEtc();
		this.setSlsAmtEtc(slsAmtEtc);
	}
	public Long getSlsAmtSm() {
		return this.slsAmtSm;
	}
	public void markSlsAmtSm() {
		this.oprMap.put("__slsAmtSm", "o");
	}
	public void setSlsAmtSm(Long slsAmtSm) throws Exception {
		this.slsAmtSm = slsAmtSm;
	}
	public void setSlsAmtSmWithMark(Long slsAmtSm) throws Exception {
		this.markSlsAmtSm();
		this.setSlsAmtSm(slsAmtSm);
	}
	public Long getDdcAmt() {
		return this.ddcAmt;
	}
	public void markDdcAmt() {
		this.oprMap.put("__ddcAmt", "o");
	}
	public void setDdcAmt(Long ddcAmt) throws Exception {
		this.ddcAmt = ddcAmt;
	}
	public void setDdcAmtWithMark(Long ddcAmt) throws Exception {
		this.markDdcAmt();
		this.setDdcAmt(ddcAmt);
	}
	public Double getCsctJoinYrCnt() {
		return this.csctJoinYrCnt;
	}
	public void markCsctJoinYrCnt() {
		this.oprMap.put("__csctJoinYrCnt", "o");
	}
	public void setCsctJoinYrCnt(Double csctJoinYrCnt) throws Exception {
		this.csctJoinYrCnt = csctJoinYrCnt;
	}
	public void setCsctJoinYrCntWithMark(Double csctJoinYrCnt) throws Exception {
		this.markCsctJoinYrCnt();
		this.setCsctJoinYrCnt(csctJoinYrCnt);
	}
	public String getCredtInqrTgtCd() {
		return this.credtInqrTgtCd;
	}
	public void markCredtInqrTgtCd() {
		this.oprMap.put("__credtInqrTgtCd", "o");
	}
	public void setCredtInqrTgtCd(String credtInqrTgtCd) throws Exception {
		this.credtInqrTgtCd = credtInqrTgtCd;
	}
	public void setCredtInqrTgtCdWithMark(String credtInqrTgtCd) throws Exception {
		this.markCredtInqrTgtCd();
		this.setCredtInqrTgtCd(credtInqrTgtCd);
	}
	public String getCredtInqrTgtNm() {
		return this.credtInqrTgtNm;
	}
	public void markCredtInqrTgtNm() {
		this.oprMap.put("__credtInqrTgtNm", "o");
	}
	public void setCredtInqrTgtNm(String credtInqrTgtNm) throws Exception {
		this.credtInqrTgtNm = credtInqrTgtNm;
	}
	public void setCredtInqrTgtNmWithMark(String credtInqrTgtNm) throws Exception {
		this.markCredtInqrTgtNm();
		this.setCredtInqrTgtNm(credtInqrTgtNm);
	}
	public String getCredtInqrTgtBrthdy() {
		return this.credtInqrTgtBrthdy;
	}
	public void markCredtInqrTgtBrthdy() {
		this.oprMap.put("__credtInqrTgtBrthdy", "o");
	}
	public void setCredtInqrTgtBrthdy(String credtInqrTgtBrthdy) throws Exception {
		this.credtInqrTgtBrthdy = credtInqrTgtBrthdy;
	}
	public void setCredtInqrTgtBrthdyWithMark(String credtInqrTgtBrthdy) throws Exception {
		this.markCredtInqrTgtBrthdy();
		this.setCredtInqrTgtBrthdy(credtInqrTgtBrthdy);
	}
	public String getCredtInqrDttm() {
		return this.credtInqrDttm;
	}
	public void markCredtInqrDttm() {
		this.oprMap.put("__credtInqrDttm", "o");
	}
	public void setCredtInqrDttm(String credtInqrDttm) throws Exception {
		this.credtInqrDttm = credtInqrDttm;
	}
	public void setCredtInqrDttmWithMark(String credtInqrDttm) throws Exception {
		this.markCredtInqrDttm();
		this.setCredtInqrDttm(credtInqrDttm);
	}
	public String getCredtInqrRslt() {
		return this.credtInqrRslt;
	}
	public void markCredtInqrRslt() {
		this.oprMap.put("__credtInqrRslt", "o");
	}
	public void setCredtInqrRslt(String credtInqrRslt) throws Exception {
		this.credtInqrRslt = credtInqrRslt;
	}
	public void setCredtInqrRsltWithMark(String credtInqrRslt) throws Exception {
		this.markCredtInqrRslt();
		this.setCredtInqrRslt(credtInqrRslt);
	}
	public String getCredtInqrRsltCd() {
		return this.credtInqrRsltCd;
	}
	public void markCredtInqrRsltCd() {
		this.oprMap.put("__credtInqrRsltCd", "o");
	}
	public void setCredtInqrRsltCd(String credtInqrRsltCd) throws Exception {
		this.credtInqrRsltCd = credtInqrRsltCd;
	}
	public void setCredtInqrRsltCdWithMark(String credtInqrRsltCd) throws Exception {
		this.markCredtInqrRsltCd();
		this.setCredtInqrRsltCd(credtInqrRsltCd);
	}
	public Double getJoinTariff() {
		return this.joinTariff;
	}
	public void markJoinTariff() {
		this.oprMap.put("__joinTariff", "o");
	}
	public void setJoinTariff(Double joinTariff) throws Exception {
		this.joinTariff = joinTariff;
	}
	public void setJoinTariffWithMark(Double joinTariff) throws Exception {
		this.markJoinTariff();
		this.setJoinTariff(joinTariff);
	}
	public Long getShareAmt() {
		return this.shareAmt;
	}
	public void markShareAmt() {
		this.oprMap.put("__shareAmt", "o");
	}
	public void setShareAmt(Long shareAmt) throws Exception {
		this.shareAmt = shareAmt;
	}
	public void setShareAmtWithMark(Long shareAmt) throws Exception {
		this.markShareAmt();
		this.setShareAmt(shareAmt);
	}
	public String getShareAmtRcpmDttm() {
		return this.shareAmtRcpmDttm;
	}
	public void markShareAmtRcpmDttm() {
		this.oprMap.put("__shareAmtRcpmDttm", "o");
	}
	public void setShareAmtRcpmDttm(String shareAmtRcpmDttm) throws Exception {
		this.shareAmtRcpmDttm = shareAmtRcpmDttm;
	}
	public void setShareAmtRcpmDttmWithMark(String shareAmtRcpmDttm) throws Exception {
		this.markShareAmtRcpmDttm();
		this.setShareAmtRcpmDttm(shareAmtRcpmDttm);
	}
	public String getPprPrsntnCpltYn() {
		return this.pprPrsntnCpltYn;
	}
	public void markPprPrsntnCpltYn() {
		this.oprMap.put("__pprPrsntnCpltYn", "o");
	}
	public void setPprPrsntnCpltYn(String pprPrsntnCpltYn) throws Exception {
		this.pprPrsntnCpltYn = pprPrsntnCpltYn;
	}
	public void setPprPrsntnCpltYnWithMark(String pprPrsntnCpltYn) throws Exception {
		this.markPprPrsntnCpltYn();
		this.setPprPrsntnCpltYn(pprPrsntnCpltYn);
	}
	public String getJdgmnStCd() {
		return this.jdgmnStCd;
	}
	public void markJdgmnStCd() {
		this.oprMap.put("__jdgmnStCd", "o");
	}
	public void setJdgmnStCd(String jdgmnStCd) throws Exception {
		this.jdgmnStCd = jdgmnStCd;
	}
	public void setJdgmnStCdWithMark(String jdgmnStCd) throws Exception {
		this.markJdgmnStCd();
		this.setJdgmnStCd(jdgmnStCd);
	}
	public String getEdycApprvYn() {
		return this.edycApprvYn;
	}
	public void markEdycApprvYn() {
		this.oprMap.put("__edycApprvYn", "o");
	}
	public void setEdycApprvYn(String edycApprvYn) throws Exception {
		this.edycApprvYn = edycApprvYn;
	}
	public void setEdycApprvYnWithMark(String edycApprvYn) throws Exception {
		this.markEdycApprvYn();
		this.setEdycApprvYn(edycApprvYn);
	}
	public String getSignCpltYn() {
		return this.signCpltYn;
	}
	public void markSignCpltYn() {
		this.oprMap.put("__signCpltYn", "o");
	}
	public void setSignCpltYn(String signCpltYn) throws Exception {
		this.signCpltYn = signCpltYn;
	}
	public void setSignCpltYnWithMark(String signCpltYn) throws Exception {
		this.markSignCpltYn();
		this.setSignCpltYn(signCpltYn);
	}
	public String getRcpmStCd() {
		return this.rcpmStCd;
	}
	public void markRcpmStCd() {
		this.oprMap.put("__rcpmStCd", "o");
	}
	public void setRcpmStCd(String rcpmStCd) throws Exception {
		this.rcpmStCd = rcpmStCd;
	}
	public void setRcpmStCdWithMark(String rcpmStCd) throws Exception {
		this.markRcpmStCd();
		this.setRcpmStCd(rcpmStCd);
	}
	public String getMbrcoRcpmYn() {
		return this.mbrcoRcpmYn;
	}
	public void markMbrcoRcpmYn() {
		this.oprMap.put("__mbrcoRcpmYn", "o");
	}
	public void setMbrcoRcpmYn(String mbrcoRcpmYn) throws Exception {
		this.mbrcoRcpmYn = mbrcoRcpmYn;
	}
	public void setMbrcoRcpmYnWithMark(String mbrcoRcpmYn) throws Exception {
		this.markMbrcoRcpmYn();
		this.setMbrcoRcpmYn(mbrcoRcpmYn);
	}
	public String getEdycPubYn() {
		return this.edycPubYn;
	}
	public void markEdycPubYn() {
		this.oprMap.put("__edycPubYn", "o");
	}
	public void setEdycPubYn(String edycPubYn) throws Exception {
		this.edycPubYn = edycPubYn;
	}
	public void setEdycPubYnWithMark(String edycPubYn) throws Exception {
		this.markEdycPubYn();
		this.setEdycPubYn(edycPubYn);
	}
	public String getEdycPubDttm() {
		return this.edycPubDttm;
	}
	public void markEdycPubDttm() {
		this.oprMap.put("__edycPubDttm", "o");
	}
	public void setEdycPubDttm(String edycPubDttm) throws Exception {
		this.edycPubDttm = edycPubDttm;
	}
	public void setEdycPubDttmWithMark(String edycPubDttm) throws Exception {
		this.markEdycPubDttm();
		this.setEdycPubDttm(edycPubDttm);
	}
	public String getDdcBgnDttm() {
		return this.ddcBgnDttm;
	}
	public void markDdcBgnDttm() {
		this.oprMap.put("__ddcBgnDttm", "o");
	}
	public void setDdcBgnDttm(String ddcBgnDttm) throws Exception {
		this.ddcBgnDttm = ddcBgnDttm;
	}
	public void setDdcBgnDttmWithMark(String ddcBgnDttm) throws Exception {
		this.markDdcBgnDttm();
		this.setDdcBgnDttm(ddcBgnDttm);
	}
	public String getDdcEndDttm() {
		return this.ddcEndDttm;
	}
	public void markDdcEndDttm() {
		this.oprMap.put("__ddcEndDttm", "o");
	}
	public void setDdcEndDttm(String ddcEndDttm) throws Exception {
		this.ddcEndDttm = ddcEndDttm;
	}
	public void setDdcEndDttmWithMark(String ddcEndDttm) throws Exception {
		this.markDdcEndDttm();
		this.setDdcEndDttm(ddcEndDttm);
	}
	public String getSpcablMttr() {
		return this.spcablMttr;
	}
	public void markSpcablMttr() {
		this.oprMap.put("__spcablMttr", "o");
	}
	public void setSpcablMttr(String spcablMttr) throws Exception {
		this.spcablMttr = spcablMttr;
	}
	public void setSpcablMttrWithMark(String spcablMttr) throws Exception {
		this.markSpcablMttr();
		this.setSpcablMttr(spcablMttr);
	}
	public String getCntrctNm() {
		return this.cntrctNm;
	}
	public void markCntrctNm() {
		this.oprMap.put("__cntrctNm", "o");
	}
	public void setCntrctNm(String cntrctNm) throws Exception {
		this.cntrctNm = cntrctNm;
	}
	public void setCntrctNmWithMark(String cntrctNm) throws Exception {
		this.markCntrctNm();
		this.setCntrctNm(cntrctNm);
	}
	public String getAssrncCn() {
		return this.assrncCn;
	}
	public void markAssrncCn() {
		this.oprMap.put("__assrncCn", "o");
	}
	public void setAssrncCn(String assrncCn) throws Exception {
		this.assrncCn = assrncCn;
	}
	public void setAssrncCnWithMark(String assrncCn) throws Exception {
		this.markAssrncCn();
		this.setAssrncCn(assrncCn);
	}
	public String getSpeclStplat() {
		return this.speclStplat;
	}
	public void markSpeclStplat() {
		this.oprMap.put("__speclStplat", "o");
	}
	public void setSpeclStplat(String speclStplat) throws Exception {
		this.speclStplat = speclStplat;
	}
	public void setSpeclStplatWithMark(String speclStplat) throws Exception {
		this.markSpeclStplat();
		this.setSpeclStplat(speclStplat);
	}
	public Long getCntrctAmt() {
		return this.cntrctAmt;
	}
	public void markCntrctAmt() {
		this.oprMap.put("__cntrctAmt", "o");
	}
	public void setCntrctAmt(Long cntrctAmt) throws Exception {
		this.cntrctAmt = cntrctAmt;
	}
	public void setCntrctAmtWithMark(Long cntrctAmt) throws Exception {
		this.markCntrctAmt();
		this.setCntrctAmt(cntrctAmt);
	}
	public String getPubAsocCd() {
		return this.pubAsocCd;
	}
	public void markPubAsocCd() {
		this.oprMap.put("__pubAsocCd", "o");
	}
	public void setPubAsocCd(String pubAsocCd) throws Exception {
		this.pubAsocCd = pubAsocCd;
	}
	public void setPubAsocCdWithMark(String pubAsocCd) throws Exception {
		this.markPubAsocCd();
		this.setPubAsocCd(pubAsocCd);
	}
	public String getPubAsocNm() {
		return this.pubAsocNm;
	}
	public void markPubAsocNm() {
		this.oprMap.put("__pubAsocNm", "o");
	}
	public void setPubAsocNm(String pubAsocNm) throws Exception {
		this.pubAsocNm = pubAsocNm;
	}
	public void setPubAsocNmWithMark(String pubAsocNm) throws Exception {
		this.markPubAsocNm();
		this.setPubAsocNm(pubAsocNm);
	}
	public String getAplrMbrSno() {
		return this.aplrMbrSno;
	}
	public void markAplrMbrSno() {
		this.oprMap.put("__aplrMbrSno", "o");
	}
	public void setAplrMbrSno(String aplrMbrSno) throws Exception {
		this.aplrMbrSno = aplrMbrSno;
	}
	public void setAplrMbrSnoWithMark(String aplrMbrSno) throws Exception {
		this.markAplrMbrSno();
		this.setAplrMbrSno(aplrMbrSno);
	}
	public String getAplrNm() {
		return this.aplrNm;
	}
	public void markAplrNm() {
		this.oprMap.put("__aplrNm", "o");
	}
	public void setAplrNm(String aplrNm) throws Exception {
		this.aplrNm = aplrNm;
	}
	public void setAplrNmWithMark(String aplrNm) throws Exception {
		this.markAplrNm();
		this.setAplrNm(aplrNm);
	}
	public String getAplrPst() {
		return this.aplrPst;
	}
	public void markAplrPst() {
		this.oprMap.put("__aplrPst", "o");
	}
	public void setAplrPst(String aplrPst) throws Exception {
		this.aplrPst = aplrPst;
	}
	public void setAplrPstWithMark(String aplrPst) throws Exception {
		this.markAplrPst();
		this.setAplrPst(aplrPst);
	}
	public String getAplrMbpno() {
		if(this.aplrMbpno != null){
			return invokerIsIbatis(__WeatherVO.class) ? this.aplrMbpno : util.decrypt(this.aplrMbpno);
		}else{
			return this.aplrMbpno;
		}
	}
	public void markAplrMbpno() {
		this.oprMap.put("__aplrMbpno", "o");
	}
	public void setAplrMbpno(String aplrMbpno) throws Exception {
		if(aplrMbpno != null){
			this.aplrMbpno = invokerIsIbatis(__WeatherVO.class) ? aplrMbpno : util.encrypt(aplrMbpno);
		}else{
			this.aplrMbpno = aplrMbpno;
		}
	}
	public void setAplrMbpnoWithMark(String aplrMbpno) throws Exception {
		this.markAplrMbpno();
		this.setAplrMbpno(aplrMbpno);
	}
	public String getAplrEml() {
		if(this.aplrEml != null){
			return invokerIsIbatis(__WeatherVO.class) ? this.aplrEml : util.decrypt(this.aplrEml);
		}else{
			return this.aplrEml;
		}
	}
	public void markAplrEml() {
		this.oprMap.put("__aplrEml", "o");
	}
	public void setAplrEml(String aplrEml) throws Exception {
		if(aplrEml != null){
			this.aplrEml = invokerIsIbatis(__WeatherVO.class) ? aplrEml : util.encrypt(aplrEml);
		}else{
			this.aplrEml = aplrEml;
		}
	}
	public void setAplrEmlWithMark(String aplrEml) throws Exception {
		this.markAplrEml();
		this.setAplrEml(aplrEml);
	}
	public String getEndrsYn() {
		return this.endrsYn;
	}
	public void markEndrsYn() {
		this.oprMap.put("__endrsYn", "o");
	}
	public void setEndrsYn(String endrsYn) throws Exception {
		this.endrsYn = endrsYn;
	}
	public void setEndrsYnWithMark(String endrsYn) throws Exception {
		this.markEndrsYn();
		this.setEndrsYn(endrsYn);
	}
	public String getEndrsRsn() {
		return this.endrsRsn;
	}
	public void markEndrsRsn() {
		this.oprMap.put("__endrsRsn", "o");
	}
	public void setEndrsRsn(String endrsRsn) throws Exception {
		this.endrsRsn = endrsRsn;
	}
	public void setEndrsRsnWithMark(String endrsRsn) throws Exception {
		this.markEndrsRsn();
		this.setEndrsRsn(endrsRsn);
	}
	public String getEndrsStdDt() {
		return this.endrsStdDt;
	}
	public void markEndrsStdDt() {
		this.oprMap.put("__endrsStdDt", "o");
	}
	public void setEndrsStdDt(String endrsStdDt) throws Exception {
		this.endrsStdDt = endrsStdDt;
	}
	public void setEndrsStdDtWithMark(String endrsStdDt) throws Exception {
		this.markEndrsStdDt();
		this.setEndrsStdDt(endrsStdDt);
	}
	public String getPlanngAssrncYn() {
		return this.planngAssrncYn;
	}
	public void markPlanngAssrncYn() {
		this.oprMap.put("__planngAssrncYn", "o");
	}
	public void setPlanngAssrncYn(String planngAssrncYn) throws Exception {
		this.planngAssrncYn = planngAssrncYn;
	}
	public void setPlanngAssrncYnWithMark(String planngAssrncYn) throws Exception {
		this.markPlanngAssrncYn();
		this.setPlanngAssrncYn(planngAssrncYn);
	}
	public String getLowCredtPermYn() {
		return this.lowCredtPermYn;
	}
	public void markLowCredtPermYn() {
		this.oprMap.put("__lowCredtPermYn", "o");
	}
	public void setLowCredtPermYn(String lowCredtPermYn) throws Exception {
		this.lowCredtPermYn = lowCredtPermYn;
	}
	public void setLowCredtPermYnWithMark(String lowCredtPermYn) throws Exception {
		this.markLowCredtPermYn();
		this.setLowCredtPermYn(lowCredtPermYn);
	}
	public String getPrdBgnDt() {
		return this.prdBgnDt;
	}
	public void markPrdBgnDt() {
		this.oprMap.put("__prdBgnDt", "o");
	}
	public void setPrdBgnDt(String prdBgnDt) throws Exception {
		this.prdBgnDt = prdBgnDt;
	}
	public void setPrdBgnDtWithMark(String prdBgnDt) throws Exception {
		this.markPrdBgnDt();
		this.setPrdBgnDt(prdBgnDt);
	}
	public String getPrdEndDt() {
		return this.prdEndDt;
	}
	public void markPrdEndDt() {
		this.oprMap.put("__prdEndDt", "o");
	}
	public void setPrdEndDt(String prdEndDt) throws Exception {
		this.prdEndDt = prdEndDt;
	}
	public void setPrdEndDtWithMark(String prdEndDt) throws Exception {
		this.markPrdEndDt();
		this.setPrdEndDt(prdEndDt);
	}
	public String getTrmnatExcclcDt() {
		return this.trmnatExcclcDt;
	}
	public void markTrmnatExcclcDt() {
		this.oprMap.put("__trmnatExcclcDt", "o");
	}
	public void setTrmnatExcclcDt(String trmnatExcclcDt) throws Exception {
		this.trmnatExcclcDt = trmnatExcclcDt;
	}
	public void setTrmnatExcclcDtWithMark(String trmnatExcclcDt) throws Exception {
		this.markTrmnatExcclcDt();
		this.setTrmnatExcclcDt(trmnatExcclcDt);
	}
	public String getSssBgnDt() {
		return this.sssBgnDt;
	}
	public void markSssBgnDt() {
		this.oprMap.put("__sssBgnDt", "o");
	}
	public void setSssBgnDt(String sssBgnDt) throws Exception {
		this.sssBgnDt = sssBgnDt;
	}
	public void setSssBgnDtWithMark(String sssBgnDt) throws Exception {
		this.markSssBgnDt();
		this.setSssBgnDt(sssBgnDt);
	}
	public String getSssEndDt() {
		return this.sssEndDt;
	}
	public void markSssEndDt() {
		this.oprMap.put("__sssEndDt", "o");
	}
	public void setSssEndDt(String sssEndDt) throws Exception {
		this.sssEndDt = sssEndDt;
	}
	public void setSssEndDtWithMark(String sssEndDt) throws Exception {
		this.markSssEndDt();
		this.setSssEndDt(sssEndDt);
	}
	public String getDdcStplatAgreYn() {
		return this.ddcStplatAgreYn;
	}
	public void markDdcStplatAgreYn() {
		this.oprMap.put("__ddcStplatAgreYn", "o");
	}
	public void setDdcStplatAgreYn(String ddcStplatAgreYn) throws Exception {
		this.ddcStplatAgreYn = ddcStplatAgreYn;
	}
	public void setDdcStplatAgreYnWithMark(String ddcStplatAgreYn) throws Exception {
		this.markDdcStplatAgreYn();
		this.setDdcStplatAgreYn(ddcStplatAgreYn);
	}
	public String getDdcStplatAgreDttm() {
		return this.ddcStplatAgreDttm;
	}
	public void markDdcStplatAgreDttm() {
		this.oprMap.put("__ddcStplatAgreDttm", "o");
	}
	public void setDdcStplatAgreDttm(String ddcStplatAgreDttm) throws Exception {
		this.ddcStplatAgreDttm = ddcStplatAgreDttm;
	}
	public void setDdcStplatAgreDttmWithMark(String ddcStplatAgreDttm) throws Exception {
		this.markDdcStplatAgreDttm();
		this.setDdcStplatAgreDttm(ddcStplatAgreDttm);
	}
	public String getEdycPrntngCnt() {
		return this.edycPrntngCnt;
	}
	public void markEdycPrntngCnt() {
		this.oprMap.put("__edycPrntngCnt", "o");
	}
	public void setEdycPrntngCnt(String edycPrntngCnt) throws Exception {
		this.edycPrntngCnt = edycPrntngCnt;
	}
	public void setEdycPrntngCntWithMark(String edycPrntngCnt) throws Exception {
		this.markEdycPrntngCnt();
		this.setEdycPrntngCnt(edycPrntngCnt);
	}
	public String getEdycDwldCnt() {
		return this.edycDwldCnt;
	}
	public void markEdycDwldCnt() {
		this.oprMap.put("__edycDwldCnt", "o");
	}
	public void setEdycDwldCnt(String edycDwldCnt) throws Exception {
		this.edycDwldCnt = edycDwldCnt;
	}
	public void setEdycDwldCntWithMark(String edycDwldCnt) throws Exception {
		this.markEdycDwldCnt();
		this.setEdycDwldCnt(edycDwldCnt);
	}
	public String getUseYn() {
		return this.useYn;
	}
	public void markUseYn() {
		this.oprMap.put("__useYn", "o");
	}
	public void setUseYn(String useYn) throws Exception {
		this.useYn = useYn;
	}
	public void setUseYnWithMark(String useYn) throws Exception {
		this.markUseYn();
		this.setUseYn(useYn);
	}
	public String getDltYn() {
		return this.dltYn;
	}
	public void markDltYn() {
		this.oprMap.put("__dltYn", "o");
	}
	public void setDltYn(String dltYn) throws Exception {
		this.dltYn = dltYn;
	}
	public void setDltYnWithMark(String dltYn) throws Exception {
		this.markDltYn();
		this.setDltYn(dltYn);
	}
	public String getFrstRgtrMbrSno() {
		return this.frstRgtrMbrSno;
	}
	public void markFrstRgtrMbrSno() {
		this.oprMap.put("__frstRgtrMbrSno", "o");
	}
	public void setFrstRgtrMbrSno(String frstRgtrMbrSno) throws Exception {
		this.frstRgtrMbrSno = frstRgtrMbrSno;
	}
	public void setFrstRgtrMbrSnoWithMark(String frstRgtrMbrSno) throws Exception {
		this.markFrstRgtrMbrSno();
		this.setFrstRgtrMbrSno(frstRgtrMbrSno);
	}
	public String getFrstRgtDttm() {
		return this.frstRgtDttm;
	}
	public void markFrstRgtDttm() {
		this.oprMap.put("__frstRgtDttm", "o");
	}
	public void setFrstRgtDttm(String frstRgtDttm) throws Exception {
		this.frstRgtDttm = frstRgtDttm;
	}
	public void setFrstRgtDttmWithMark(String frstRgtDttm) throws Exception {
		this.markFrstRgtDttm();
		this.setFrstRgtDttm(frstRgtDttm);
	}
	public String getFrstRgtTrnstSno() {
		return this.frstRgtTrnstSno;
	}
	public void markFrstRgtTrnstSno() {
		this.oprMap.put("__frstRgtTrnstSno", "o");
	}
	public void setFrstRgtTrnstSno(String frstRgtTrnstSno) throws Exception {
		this.frstRgtTrnstSno = frstRgtTrnstSno;
	}
	public void setFrstRgtTrnstSnoWithMark(String frstRgtTrnstSno) throws Exception {
		this.markFrstRgtTrnstSno();
		this.setFrstRgtTrnstSno(frstRgtTrnstSno);
	}
	public String getRcntChngrMbrSno() {
		return this.rcntChngrMbrSno;
	}
	public void markRcntChngrMbrSno() {
		this.oprMap.put("__rcntChngrMbrSno", "o");
	}
	public void setRcntChngrMbrSno(String rcntChngrMbrSno) throws Exception {
		this.rcntChngrMbrSno = rcntChngrMbrSno;
	}
	public void setRcntChngrMbrSnoWithMark(String rcntChngrMbrSno) throws Exception {
		this.markRcntChngrMbrSno();
		this.setRcntChngrMbrSno(rcntChngrMbrSno);
	}
	public String getRcntChngDttm() {
		return this.rcntChngDttm;
	}
	public void markRcntChngDttm() {
		this.oprMap.put("__rcntChngDttm", "o");
	}
	public void setRcntChngDttm(String rcntChngDttm) throws Exception {
		this.rcntChngDttm = rcntChngDttm;
	}
	public void setRcntChngDttmWithMark(String rcntChngDttm) throws Exception {
		this.markRcntChngDttm();
		this.setRcntChngDttm(rcntChngDttm);
	}
	public String getRcntChngTrnstSno() {
		return this.rcntChngTrnstSno;
	}
	public void markRcntChngTrnstSno() {
		this.oprMap.put("__rcntChngTrnstSno", "o");
	}
	public void setRcntChngTrnstSno(String rcntChngTrnstSno) throws Exception {
		this.rcntChngTrnstSno = rcntChngTrnstSno;
	}
	public void setRcntChngTrnstSnoWithMark(String rcntChngTrnstSno) throws Exception {
		this.markRcntChngTrnstSno();
		this.setRcntChngTrnstSno(rcntChngTrnstSno);
	}


}

