package cn.limbo.dao;

import cn.limbo.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by limbo on 2017/4/10.
 */
@Repository
public interface CityDao {

	City findByName(@Param("cityName")String cityName);

}
