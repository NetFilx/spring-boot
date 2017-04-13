package cn.limbo.exception;

/**
 * Created by limbo on 2017/4/10.
 */
public class NoCityFoundException extends Exception {

	public NoCityFoundException(){
		super();
	}

	public NoCityFoundException(String msg){
		super(msg);
	}

}
