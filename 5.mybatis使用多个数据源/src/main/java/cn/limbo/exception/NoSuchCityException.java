package cn.limbo.exception;

/**
 * Created by limbo on 2017/4/10.
 */
public class NoSuchCityException extends Exception {

	public NoSuchCityException(){
		super();
	}

	public NoSuchCityException(String msg){
		super(msg);
	}

}
