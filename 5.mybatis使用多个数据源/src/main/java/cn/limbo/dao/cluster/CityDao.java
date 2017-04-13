package cn.limbo.dao.cluster;

import cn.limbo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by limbo on 2017/4/10.
 */

@Mapper
public interface CityDao {

	City findByName(@Param("cityName") String cityName);

}
