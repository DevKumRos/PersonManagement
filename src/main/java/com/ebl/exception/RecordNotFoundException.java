package com.ebl.exception;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }


}
