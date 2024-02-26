package me.xcx.seckill.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.xcx.seckill.vo.ApiResponseStatus;

@Getter
@Setter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private ApiResponseStatus apiResponseStatus;
}
