package cn.limbo.exception;

/**
 * Created by limbo on 2017/4/10.
 */
public class NoSuchUserException extends Exception {

	public NoSuchUserException() {
		super();
	}


	public NoSuchUserException(String msg) {
		super(msg);
	}
}
