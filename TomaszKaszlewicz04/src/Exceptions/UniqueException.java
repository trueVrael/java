package Exceptions;

public class UniqueException extends Exception {

    public UniqueException(String atr, Class<?> c) {
        super("Atribute " + atr + " has to be unique in class " + c);
    }
}
