package ru.sidorov.rest.RestApp.util;

public class UserNotCreatedException extends RuntimeException {

    public UserNotCreatedException(String msg) {
        super(msg);
    }
}
