package org.serratec.borrachariaLambda.exception;

public class ServicoPrestadoException extends Exception{
    private static final long serialVersionUID = 1L;

    public ServicoPrestadoException() {
        super();
    }

    public ServicoPrestadoException(String message) {
        super(message);
    }

    public ServicoPrestadoException(String message, Exception cause) {
        super(message, cause);
    }

    public ServicoPrestadoException(Exception e) {
        super(e);
    }
}
