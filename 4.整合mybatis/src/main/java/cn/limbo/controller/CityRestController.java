package cn.limbo.controller;

import cn.limbo.domain.City;
import cn.limbo.exception.NoCityFoundException;
import cn.limbo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by limbo on 2017/4/10.
 */
@RestController
public class CityRestController {

	@Autowired
	CityService cityService;


	@RequestMapping(value = "/api/city",method = RequestMethod.GET)
	public City findOneCity(@RequestParam(value = "cityName") String cityName) {
		City city = null;
		try {
			city = cityService.findCityByName(cityName);
		} catch (NoCityFoundException e) {
			System.err.println(e.toString());
		}
		return city;
	}
}
