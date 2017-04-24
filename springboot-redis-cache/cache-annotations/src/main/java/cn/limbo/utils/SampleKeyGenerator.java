package cn.limbo.utils;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * Created by limbo on 2017/4/24.
 */
public class SampleKeyGenerator implements KeyGenerator {
	@Override
	public Object generate(Object o, Method method, Object... objects) {
		StringBuilder sb = new StringBuilder();
		sb.append(o.getClass().getName());
		sb.append(method.getName());
		for (Object obj : objects) {
			sb.append(obj.toString());
		}
		return sb.toString();
	}
}
