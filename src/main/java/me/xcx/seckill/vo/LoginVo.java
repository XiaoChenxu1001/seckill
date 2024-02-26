package me.xcx.seckill.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginVo {

    @NotNull
    @Pattern(regexp = "^1[345789]\\d{9}$", message = "手机号码格式不正确")
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;

}
