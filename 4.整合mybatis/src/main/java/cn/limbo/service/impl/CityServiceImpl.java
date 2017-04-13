package cn.limbo.service.impl;

import cn.limbo.dao.CityDao;
import cn.limbo.domain.City;
import cn.limbo.exception.NoCityFoundException;
import cn.limbo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by limbo on 2017/4/10.
 */
@Service
public class CityServiceImpl implements CityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Autowired
	CityDao cityDao;

	@Override
	public City findCityByName(String cityName) throws NoCityFoundException {
		City result = cityDao.findByName(cityName);
		LOGGER.info("getCity result:'{}'", result);
		if (Objects.isNull(result)) {
			throw new NoCityFoundException("找不到该城市！");
		} else {
			return result;
		}
	}
}
