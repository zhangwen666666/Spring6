package com.zw.bank.exceptions;

public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(String message) {
        super(message);
    }

    public MoneyNotEnoughException() {
    }
}
