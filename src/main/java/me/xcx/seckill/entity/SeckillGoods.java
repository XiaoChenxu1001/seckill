package me.xcx.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_seckill_goods")
@Schema(name = "SeckillGoods", description = "$!{table.comment}")
public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "秒杀商品ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "商品ID")
    private Long goodsId;

    @Schema(description = "秒杀价")
    private BigDecimal seckillPrice;

    @Schema(description = "库存数量")
    private Integer stockCount;

    @Schema(description = "秒杀开始时间")
    private LocalDateTime startDate;

    @Schema(description = "秒杀结束时间")
    private LocalDateTime endDate;
}
