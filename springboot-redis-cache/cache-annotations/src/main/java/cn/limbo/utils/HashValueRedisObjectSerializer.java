package cn.limbo.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by limbo on 2017/4/24.
 */
public class HashValueRedisObjectSerializer implements RedisSerializer<Object> {

	static final byte[] EMPTY_ARRAY = new byte[0];
	//序列化
	private Converter<Object, byte[]> serializer = new SerializingConverter();
	//反序列化
	private Converter<byte[], Object> deserializer = new DeserializingConverter();

	@Override
	public byte[] serialize(Object o) throws SerializationException {

		if (o == null)
			return EMPTY_ARRAY;
		try {
			return serializer.convert(o);
		} catch (Exception e) {
			return EMPTY_ARRAY;
		}

	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {

		if (isEmpty(bytes))
			return null;

		try {
			return deserializer.convert(bytes);
		} catch (Exception ex) {
			throw new SerializationException("Cannot deserialize", ex);
		}

	}

	private boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}
}
