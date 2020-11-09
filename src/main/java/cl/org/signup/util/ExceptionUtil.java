package cl.org.signup.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ExceptionUtil {

    public ErrorExceptionResource create(HttpStatus httpStatus, Object object, boolean showStackTrace) throws ErrorExceptionResource {
        if (httpStatus.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            httpStatus = HttpStatus.NO_CONTENT;
        }

        if (showStackTrace) {
            throw new ErrorStandarException(httpStatus, object);
        } else {
            throw new ErrorWithoutStackTrace(httpStatus, object);
        }
    }

    public class ErrorExceptionResource extends RuntimeException {

        private static final long serialVersionUID = 1L;
        private HttpStatus httpStatus = null;
        private Object object;
        protected static final String EMPTY_STRING = "";


        public ErrorExceptionResource(HttpStatus httpStatus, Object object) {
            super(httpStatus.getReasonPhrase());
            this.httpStatus = httpStatus;
            this.object = object;
        }

        public ErrorExceptionResource(HttpStatus httpStatus, Object object, Throwable cause) {
            super(httpStatus.getReasonPhrase(), null, true, false);
            this.httpStatus = httpStatus;
            this.object = object;
        }

        public HttpStatus getHttpStatus() {
            return this.httpStatus;
        }


        public Object getBody() {
            return object;
        }
    }

    public class ErrorWithoutStackTrace extends ErrorExceptionResource {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public ErrorWithoutStackTrace(HttpStatus httpStatus, Object object) {
            super(httpStatus, object, null);
        }

        @Override
        public String getMessage() {
            return EMPTY_STRING;
        }

        @Override
        public String toString() {
            return EMPTY_STRING;
        }

        @Override
        public void printStackTrace() {
        }
    }

    public class ErrorStandarException extends ErrorExceptionResource {

        /**
         *
         */
        private static final long serialVersionUID = 1L;


        public ErrorStandarException(HttpStatus httpStatus, Object object) {
            super(httpStatus, object);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }


        @Override
        public String toString() {
            return super.toString();
        }
    }
}