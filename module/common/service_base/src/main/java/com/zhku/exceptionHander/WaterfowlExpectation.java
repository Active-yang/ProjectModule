package com.zhku.exceptionHander;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WaterfowlExpectation extends RuntimeException {
    private Integer code;
    private String msg;
}
