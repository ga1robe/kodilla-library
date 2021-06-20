package com.crud.library.controller;

import java.sql.Timestamp;

public class NotFoundRecordException extends Exception {
    public NotFoundRecordException(Exception e) {
        super(e.toString());
        System.out.println(new Timestamp(System.currentTimeMillis()) + " [NotFoundRecordException]: " + e.toString());
    }
}
