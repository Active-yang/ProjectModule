package com.zhku.exceptionHander;

import com.zhku.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        return R.error().message("执行了全局异常处理..");
    }

    @ExceptionHandler(WaterfowlExpectation.class)
    @ResponseBody
    public R error(WaterfowlExpectation e) {
        return R.error().message(e.getMsg()).code(e.getCode());
    }

}
