package exceptions;

public class MyArrayDataException extends NumberFormatException{
    private final String ERROR_MESSAGE;

    public MyArrayDataException(String errorMessage){
        super(errorMessage);
        this.ERROR_MESSAGE = errorMessage;
    }

    @Override
    public String toString() {
        return this.ERROR_MESSAGE;
    }
}
