package ru.tkachenko.deposit.exception;

public class DepositServiceException extends RuntimeException{
    public DepositServiceException(String message) {
        super(message);
    }
}
