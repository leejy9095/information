package jun.com.information.exchange.service;

public class WeatherVO extends __WeatherVO {

	//* ?ôï?û• ?ãú?ûë
	//* ?ôï?û• ?Åù

	private String srchCntStart; //Ï¶ùÏÑúÎ≤àÌò∏ Í≤??Éâ ?ãú?ûë?ùº?ûê
	private String srchCntEnd; //Ï¶ùÏÑúÎ≤àÌò∏ Í≤??Éâ Ï¢ÖÎ£å?ùº
	private int bizCnt;
	private String ddcSeCdNm;
	private String mbrcoRgtno; //Í¥?Í¥ëÏÇ¨?óÖ?ûê ?ì±Î°ùÎ≤à?ò∏
	
	
	// ÏΩîÎìúÎ™?
	private String indtNm; 		// ?óÖÏ¢? ÏΩîÎìúÎ™?
	private String mbrcoSeNm; 	// ?öå?õê?Ç¨ Íµ¨Î∂Ñ ÏΩîÎìúÎ™?
	private String bustNm; 		// ?ö¥?òÅ?ÉÅ?Éú ÏΩîÎìúÎ™?
	private String addrRgnNm; 	// ?ö¥?òÅ?ÉÅ?Éú ÏΩîÎìúÎ™?
	private String aplStpNm; 	// ?ö¥?òÅ?ÉÅ?Éú ÏΩîÎìúÎ™?
	private String credtInqrRsltCdNm; 	// ?ö¥?òÅ?ÉÅ?Éú ÏΩîÎìúÎ™?
	private String endrsNm;		//Î∞∞ÏÑúÍµ¨Î∂ÑÏΩîÎìúÎ™?	
	
	//?ï¥Ïß??†ïÎ≥? ?ôï?û•
	private String trmnatStdDt;
	private Long trmnatShareAmt;
	private String excclcStdDt;
	private Long trmnatSno;
	
	
	//?îº?ï¥Î≥¥ÏÉÅ?†ïÎ≥? ?ôï?û•
	private Long dmgeRewardSno;
	private String acdntNo;
	private String acdntDt;
	private Long acdntAmt;
	private String rewardDt;
	private Long rewardAmt;
	private Long rewardNumpCnt;
	private String rewardRmk;
	private String dmgeRewardCn;
	
	private String prcDttm;
	private Long acdntAmtSum;
	private Long rewardAmtSum;
	private Long joinCnt;
	private Long retroDays;
	private Long shareAmtSum;
	private Long trmnatShareAmtSum;
	private String srchYear;
	private Long rewardNumpCntSum;
	private String rcpmCnfrmDt;
	
	//?òë?öå?†ïÎ≥? ?ôï?û•
	private String rpr;
	private String chrgr;
	
	//?öå?õê ?ôï?û•
	private Long mbrcoSno;
	private String mbrcoNm;
	private String rprTelno;
	private String rprTelnoAdt;
	private String rprFaxno;
	private String rprEml;
	private String sidjbYn;
	private String bustBgnDt;
	private String bustEndDt;
	private String bustChngRsn;
	

	public String getRcpmCnfrmDt() {
		return rcpmCnfrmDt;
	}
	public void setRcpmCnfrmDt(String rcpmCnfrmDt) {
		this.rcpmCnfrmDt = rcpmCnfrmDt;
	}
	public String getPrcDttm() {
		return prcDttm;
	}
	public void setPrcDttm(String prcDttm) {
		this.prcDttm = prcDttm;
	}
	public Long getRewardNumpCnt() {
		return rewardNumpCnt;
	}
	public void setRewardNumpCnt(Long rewardNumpCnt) {
		this.rewardNumpCnt = rewardNumpCnt;
	}
	public Long getRewardNumpCntSum() {
		return rewardNumpCntSum;
	}
	public void setRewardNumpCntSum(Long rewardNumpCntSum) {
		this.rewardNumpCntSum = rewardNumpCntSum;
	}
	public Long getAcdntAmtSum() {
		return acdntAmtSum;
	}
	public void setAcdntAmtSum(Long acdntAmtSum) {
		this.acdntAmtSum = acdntAmtSum;
	}
	public Long getRewardAmtSum() {
		return rewardAmtSum;
	}
	public void setRewardAmtSum(Long rewardAmtSum) {
		this.rewardAmtSum = rewardAmtSum;
	}
	public Long getAcdntAmt() {
		return acdntAmt;
	}
	public void setAcdntAmt(Long acdntAmt) {
		this.acdntAmt = acdntAmt;
	}
	public Long getRewardAmt() {
		return rewardAmt;
	}
	public void setRewardAmt(Long rewardAmt) {
		this.rewardAmt = rewardAmt;
	}
	public String getMbrcoRgtno() {
		return mbrcoRgtno;
	}
	public Long getShareAmtSum() {
		return shareAmtSum;
	}
	public void setShareAmtSum(Long shareAmtSum) {
		this.shareAmtSum = shareAmtSum;
	}
	public Long getTrmnatShareAmtSum() {
		return trmnatShareAmtSum;
	}
	public void setTrmnatShareAmtSum(Long trmnatShareAmtSum) {
		this.trmnatShareAmtSum = trmnatShareAmtSum;
	}
	public void setMbrcoRgtno(String mbrcoRgtno) {
		this.mbrcoRgtno = mbrcoRgtno;
	}
	public String getAddrRgnNm() {
		return addrRgnNm;
	}
	public void setAddrRgnNm(String addrRgnNm) {
		this.addrRgnNm = addrRgnNm;
	}
	public String getSrchYear() {
		return srchYear;
	}
	public void setSrchYear(String srchYear) {
		this.srchYear = srchYear;
	}
	public Long getRetroDays() {
		return retroDays;
	}
	public void setRetroDays(Long retroDays) {
		this.retroDays = retroDays;
	}
	public Long getJoinCnt() {
		return joinCnt;
	}
	public void setJoinCnt(Long joinCnt) {
		this.joinCnt = joinCnt;
	}
	public Long getTrmnatSno() {
		return trmnatSno;
	}
	public void setTrmnatSno(Long trmnatSno) {
		this.trmnatSno = trmnatSno;
	}
	public String getCredtInqrRsltCdNm() {
		return credtInqrRsltCdNm;
	}
	public void setCredtInqrRsltCdNm(String credtInqrRsltCdNm) {
		this.credtInqrRsltCdNm = credtInqrRsltCdNm;
	}
	public String getSrchCntStart() {
		return srchCntStart;
	}
	public void setSrchCntStart(String srchCntStart) {
		this.srchCntStart = srchCntStart;
	}
	public String getSrchCntEnd() {
		return srchCntEnd;
	}	
	public void setSrchCntEnd(String srchCntEnd) {
		this.srchCntEnd = srchCntEnd;
	}
	public int getBizCnt() {
		return bizCnt;
	}
	public void setBizCnt(int bizCnt) {
		this.bizCnt = bizCnt;
	}
	public String getBustNm() {
		return bustNm;
	}
	public void setBustNm(String bustNm) {
		this.bustNm = bustNm;
	}
	public String getIndtNm() {
		return indtNm;
	}
	public void setIndtNm(String indtNm) {
		this.indtNm = indtNm;
	}
	public String getMbrcoSeNm() {
		return mbrcoSeNm;
	}
	public void setMbrcoSeNm(String mbrcoSeNm) {
		this.mbrcoSeNm = mbrcoSeNm;
	}	
	public String getAplStpNm() {
		return aplStpNm;
	}
	public void setAplStpNm(String aplStpNm) {
		this.aplStpNm = aplStpNm;
	}
	/**
	 * @return the endrsNm
	 */
	public String getEndrsNm() {
		return endrsNm;
	}
	/**
	 * @param endrsNm the endrsNm to set
	 */
	public void setEndrsNm(String endrsNm) {
		this.endrsNm = endrsNm;
	}
	public String getTrmnatStdDt() {
		return trmnatStdDt;
	}
	public void setTrmnatStdDt(String trmnatStdDt) {
		this.trmnatStdDt = trmnatStdDt;
	}
	public Long getTrmnatShareAmt() {
		return trmnatShareAmt;
	}
	public void setTrmnatShareAmt(Long trmnatShareAmt) {
		this.trmnatShareAmt = trmnatShareAmt;
	}
	public String getExcclcStdDt() {
		return excclcStdDt;
	}
	public void setExcclcStdDt(String excclcStdDt) {
		this.excclcStdDt = excclcStdDt;
	}
	public Long getDmgeRewardSno() {
		return dmgeRewardSno;
	}
	public void setDmgeRewardSno(Long dmgeRewardSno) {
		this.dmgeRewardSno = dmgeRewardSno;
	}
	public String getAcdntNo() {
		return acdntNo;
	}
	public void setAcdntNo(String acdntNo) {
		this.acdntNo = acdntNo;
	}
	public String getAcdntDt() {
		return acdntDt;
	}
	public void setAcdntDt(String acdntDt) {
		this.acdntDt = acdntDt;
	}
	public String getRewardDt() {
		return rewardDt;
	}
	public void setRewardDt(String rewardDt) {
		this.rewardDt = rewardDt;
	}
	public String getRewardRmk() {
		return rewardRmk;
	}
	public void setRewardRmk(String rewardRmk) {
		this.rewardRmk = rewardRmk;
	}
	public String getDmgeRewardCn() {
		return dmgeRewardCn;
	}
	public void setDmgeRewardCn(String dmgeRewardCn) {
		this.dmgeRewardCn = dmgeRewardCn;
	}
	public String getDdcSeCdNm() {
		return ddcSeCdNm;
	}
	public void setDdcSeCdNm(String ddcSeCdNm) {
		this.ddcSeCdNm = ddcSeCdNm;
	}
	public String getRpr() {
		return rpr;
	}
	public void setRpr(String rpr) {
		this.rpr = rpr;
	}
	public String getChrgr() {
		return chrgr;
	}
	public void setChrgr(String chrgr) {
		this.chrgr = chrgr;
	}
	public String getSidjbYn() {
		return sidjbYn;
	}
	public void setSidjbYn(String sidjbYn) {
		this.sidjbYn = sidjbYn;
	}
	public String getBustBgnDt() {
		return bustBgnDt;
	}
	public void setBustBgnDt(String bustBgnDt) {
		this.bustBgnDt = bustBgnDt;
	}
	public String getBustEndDt() {
		return bustEndDt;
	}
	public void setBustEndDt(String bustEndDt) {
		this.bustEndDt = bustEndDt;
	}
	public String getBustChngRsn() {
		return bustChngRsn;
	}
	public void setBustChngRsn(String bustChngRsn) {
		this.bustChngRsn = bustChngRsn;
	}

	public Long getMbrcoSno() {
		return mbrcoSno;
	}
	public void setMbrcoSno(Long mbrcoSno) {
		this.mbrcoSno = mbrcoSno;
	}
	public String getMbrcoNm() {
		return mbrcoNm;
	}
	public void setMbrcoNm(String mbrcoNm) {
		this.mbrcoNm = mbrcoNm;
	}
	public String getRprTelno() {
		return rprTelno;
	}
	public void setRprTelno(String rprTelno) {
		this.rprTelno = rprTelno;
	}
	public String getRprTelnoAdt() {
		return rprTelnoAdt;
	}
	public void setRprTelnoAdt(String rprTelnoAdt) {
		this.rprTelnoAdt = rprTelnoAdt;
	}
	public String getRprFaxno() {
		return rprFaxno;
	}
	public void setRprFaxno(String rprFaxno) {
		this.rprFaxno = rprFaxno;
	}
	public String getRprEml() {
		return rprEml;
	}
	public void setRprEml(String rprEml) {
		this.rprEml = rprEml;
	}
	
}
