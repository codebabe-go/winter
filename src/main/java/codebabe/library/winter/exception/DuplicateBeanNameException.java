package codebabe.library.winter.exception;

/**
 * author: code.babe
 * date: 2016-08-26 16:27
 */
public class DuplicateBeanNameException extends RuntimeException {

    public DuplicateBeanNameException() {
    }

    public DuplicateBeanNameException(String message) {
        super(message);
    }

    public DuplicateBeanNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateBeanNameException(Throwable cause) {
        super(cause);
    }

}
