package exceptions;

public class MyArraySizeException extends IndexOutOfBoundsException{
    private final String ERROR_MESSAGE;

    public MyArraySizeException(String errorMessage){
        super(errorMessage);
        this.ERROR_MESSAGE = errorMessage;
    }

    @Override
    public String toString() {
        return this.ERROR_MESSAGE;
    }
}
