package com.yishuailuo.iTest.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by luoyishuai on 17/7/30.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    public static final String RESP_CODE_ERROR = "1001";

    private String respCode;
    private String respMsg;

}
