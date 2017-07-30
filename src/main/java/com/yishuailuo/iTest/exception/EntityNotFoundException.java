package com.yishuailuo.iTest.exception;

import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Created by luoyishuai on 17/7/30.
 */
public class EntityNotFoundException extends EmptyResultDataAccessException {

    private static final int EXPECTED_SIZE = 1;

    public EntityNotFoundException(String msg) {
        super(msg, EXPECTED_SIZE);
    }
}
