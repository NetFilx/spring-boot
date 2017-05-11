package cn.limbo.exception;

/**
 * Created by limbo on 2017/5/11.
 */
public class UploadFileNotFoundException extends UploadFileException {
	public UploadFileNotFoundException(String message) {
		super(message);
	}

	public UploadFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
