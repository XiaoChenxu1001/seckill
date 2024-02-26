package me.xcx.seckill.vo;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class ApiResponse<T> implements Serializable {


    // 状态码，通常使用HTTP状态码，但也可以自定义
    private int code;

    // 消息，用于描述操作的结果
    private String message;

    // 数据，可能包含返回的具体内容
    private T data;

    // 构造函数，用于创建错误的响应，通常不包含数据
    public ApiResponse(int code, String message) {
        this(code, message, null);
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法，用于创建成功的响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    // 静态方法，用于创建成功的响应，但不带数据
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(200, "Success", null);
    }

    // TODO 错误的原因可能各有不同
    // 静态方法，用于创建错误的响应
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public static <T> ApiResponse<T> error(ApiResponseStatus status) {
        return new ApiResponse<>(status.getCode(), status.getMessage(), null);
    }

    public static <T> ApiResponse<T> error(ApiResponseStatus status, T data) {
        return new ApiResponse<>(status.getCode(), status.getMessage(), data);
    }


}
