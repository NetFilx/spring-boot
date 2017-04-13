package cn.limbo.service;

import cn.limbo.domain.City;
import cn.limbo.exception.NoCityFoundException;

/**
 * Created by limbo on 2017/4/10.
 */
public interface CityService {

	/**
	 * 根据城市名字查找城市
	 * @param cityName 城市名字
	 * @return 返回城市信息
	 * @throws NoCityFoundException 城市找不到
	 */
	City findCityByName(String cityName) throws NoCityFoundException;

}
