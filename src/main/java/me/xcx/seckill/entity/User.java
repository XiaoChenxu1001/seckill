package me.xcx.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
@Getter
@Setter
@TableName("t_user")
@Schema(name = "User", description = "$!{table.comment}")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID，手机号码")
    private Long id;

    private String nickname;

    @Schema(description = "MD5(MD5(pass明文+固定salt)+salt)")
    private String password;

    private String salt;

    @Schema(description = "头像")
    private String head;

    @Schema(description = "注册时间")
    private LocalDateTime registerData;

    @Schema(description = "最后一次登录时间")
    private LocalDateTime lastLoginData;

    @Schema(description = "登录次数")
    private Integer loginCount;
}
