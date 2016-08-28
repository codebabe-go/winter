package codebabe.library.winter.exception;

/**
 * author: code.babe
 * date: 2016-08-25 21:06
 */
public class EnvironmentException extends RuntimeException {

    public EnvironmentException() {
    }

    public EnvironmentException(String message) {
        super(message);
    }

    public EnvironmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnvironmentException(Throwable cause) {
        super(cause);
    }

    private enum Environment {
        INIT_ERROR(1, "INIT FAILED"),
        DESTROY_ERROR(2, "DESTROY FAILED")
        ;

        private int code;
        private String msg;

        private Environment(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
