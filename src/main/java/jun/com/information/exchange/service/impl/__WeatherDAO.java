package jun.com.information.exchange.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import withus21.cms.bas.service.impl.BaseDAO;
import withus21.custom.deduction.biz.service.DdcBsnAssrncVO;

public class __WeatherDAO extends BaseDAO<WeatherVO> {

	@Resource(name="sqlSessionFactory")
	public void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public __WeatherDAO() {
		super("withus21.custom.deduction.biz.service.DdcBsnAssrncMapper", WeatherVO.class);
	}

}
