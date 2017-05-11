package cn.limbo.exception;

/**
 * Created by limbo on 2017/5/11.
 */
public class UploadFileException extends RuntimeException {

	public UploadFileException(String message){
		super(message);
	}

	public UploadFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
