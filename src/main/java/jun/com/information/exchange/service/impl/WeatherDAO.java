package jun.com.information.exchange.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import withus21.custom.deduction.biz.service.DdcBsnAssrncVO;
import withus21.custom.mbrco.service.BasMbrcoVO;

@Repository("ddcBsnAssrncDAO")
public class WeatherDAO extends __WeatherDAO {
	private String mapperNm = "withus21.custom.deduction.biz.service.DdcBsnAssrncMapper.";
	public WeatherDAO() {
		super();
	}
	public String getMapperNm(){
		return mapperNm;
	}

	
	public Map<String,Object> selectCntBiz(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectCntBiz", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectChkMbrcoBiz(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectChkMbrcoBiz", vDdcBsnAssrncVO);
	}
	
	public WeatherVO selectOneWithNo(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectOne("selectOneWithNo", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectBsnNonPayList(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectBsnNonPayList", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectBsnListWithTrmnat(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectBsnListWithTrmnat", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectBsnListWithDmge(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectBsnListWithDmge", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectListBsnIndtJoin(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectListBsnIndtJoin", vDdcBsnAssrncVO);
	}
	
	public Map<String,Object> selectListUsrBsn(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectListOnly("selectListUsrBsn", vDdcBsnAssrncVO);
	}

	public WeatherVO selectOneNum(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return selectOne("selectOneNum", vDdcBsnAssrncVO);
	}
	
	public List<WeatherVO> selectListJoinRate(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListJoinRate", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectListJoinRateAmt(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListJoinRateAmt", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectListMbrcoStatus(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMbrcoStatus", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectListRetroactive(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListRetroactive", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectRetroactiveRate(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectRetroactiveRate", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectTrmnatStatus(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectTrmnatStatus", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectTrmnatRate(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectTrmnatRate", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectDmgeStatus(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectDmgeStatus", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectDmgeRate(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectDmgeRate", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectDmgeRateByYear(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectDmgeRateByYear", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectJdgmnStatus(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectJdgmnStatus", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectJdgmnRate(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectJdgmnRate", vDdcBsnAssrncVO).get("resultList");
	}
	
	public List<WeatherVO> selectMbrcoSales(WeatherVO vDdcBsnAssrncVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectMbrcoSales", vDdcBsnAssrncVO).get("resultList");
	}

	public List<WeatherVO> selectListMb(WeatherVO svcVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMb", svcVO).get("resultList");
	}
	public List<WeatherVO> selectListMb1(WeatherVO svcVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMb1", svcVO).get("resultList");
	}
	public List<WeatherVO> selectListMb2(WeatherVO svcVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMb2", svcVO).get("resultList");
	}
	public List<WeatherVO> selectListMb3(WeatherVO svcVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMb3", svcVO).get("resultList");
	}
	public List<WeatherVO> selectListMb4(WeatherVO svcVO) throws Exception{
		return (List<WeatherVO>) selectListOnly("selectListMb4", svcVO).get("resultList");
	}
	
}
