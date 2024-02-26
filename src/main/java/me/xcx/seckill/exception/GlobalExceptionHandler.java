package me.xcx.seckill.exception;

import me.xcx.seckill.vo.ApiResponse;
import me.xcx.seckill.vo.ApiResponseStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    org.springframework.web.bind.MethodArgumentNotValidException
    2024-02-26T17:27:22.042+08:00  WARN 31396 --- [nio-8888-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public me.xcx.seckill.vo.ApiResponse me.xcx.seckill.controller.LoginController.login(me.xcx.seckill.vo.LoginVo,jakarta.servlet.http.HttpServletRequest) with 2 errors: [Field error in object 'loginVo' on field 'mobile': rejected value [12700000000]; codes [Pattern.loginVo.mobile,Pattern.mobile,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [loginVo.mobile,mobile]; arguments []; default message [mobile],[Ljakarta.validation.constraints.Pattern$Flag;@47d3e823,^1[345789]\d{9}$]; default message [需要匹配正则表达式"^1[345789]\d{9}$"]] [Field error in object 'loginVo' on field 'password': rejected value [d3b1294a61a07da9b49b6e22b2cbd7f9]; codes [Length.loginVo.password,Length.password,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [loginVo.password,password]; arguments []; default message [password],20,6]; default message [长度需要在6和20之间]] ]
     */
//    @ResponseBody

    // 灵活的捕获异常进行分类统一处理
    @ExceptionHandler(Exception.class)
    public ApiResponse exceptionHandler(Exception e) {
        if (e instanceof BindException except) {
            ApiResponse<String> apiResponse = ApiResponse.error(ApiResponseStatus.VALID_ERROR);
            apiResponse.setMessage(ApiResponseStatus.VALID_ERROR.getMessage() + ": "
                    + except.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
            return apiResponse;
        }
        return ApiResponse.error(ApiResponseStatus.ERROR);
    }

    @ExceptionHandler(GlobalException.class)
    public ApiResponse globalExceptionHandler(GlobalException e) {
        return ApiResponse.error(e.getApiResponseStatus());
    }
}
