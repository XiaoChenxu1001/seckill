package me.xcx.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_seckill_order")
@Schema(name = "SeckillOrder", description = "$!{table.comment}")
public class SeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "秒杀订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "订单ID")
    private Long orderId;

    @Schema(description = "商品ID")
    private Long goodsId;
}
