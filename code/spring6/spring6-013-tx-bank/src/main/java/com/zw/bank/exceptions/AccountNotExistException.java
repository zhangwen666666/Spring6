package com.zw.bank.exceptions;

public class AccountNotExistException extends Exception{
    public AccountNotExistException(String message) {
        super(message);
    }

    public AccountNotExistException() {
    }
}
