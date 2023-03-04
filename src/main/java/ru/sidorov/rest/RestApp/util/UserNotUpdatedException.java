package ru.sidorov.rest.RestApp.util;

public class UserNotUpdatedException extends RuntimeException {

    public UserNotUpdatedException(String msg) {
        super(msg);
    }
}
