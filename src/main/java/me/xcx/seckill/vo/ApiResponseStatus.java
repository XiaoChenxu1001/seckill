package me.xcx.seckill.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ApiResponseStatus {

    SUCCESS(200, "成功"),
    ERROR(500, "服务器异常"),

    // 登录功能 5001xx
    LOGIN_ERROR(500100, "账号或密码错误"),

    VALID_ERROR(5001001, "参数校验异常"),
    NOT_LOGIN_ERROR(500102, "用户未登录"),
    NOT_AUTHENTICATED(500103, "未通过身份验证")
    ;

    private final int code;
    private final String message;

}
