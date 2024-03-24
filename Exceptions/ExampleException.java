package org.example.ExceptionsFinalTask.Exceptions;

public class ExampleException extends RuntimeException {
    public ExampleException(String message) {
        super(message);
    }

    public ExampleException() {
        super("Ошибка соответствия шаблону");
    }
}
