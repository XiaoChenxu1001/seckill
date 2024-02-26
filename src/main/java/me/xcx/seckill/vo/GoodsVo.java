package me.xcx.seckill.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.xcx.seckill.entity.Goods;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class GoodsVo extends Goods {

    @Schema(description = "秒杀价")
    private BigDecimal seckillPrice;

    @Schema(description = "库存数量")
    private Integer stockCount;

    @Schema(description = "秒杀开始时间")
    private LocalDateTime startDate;

    @Schema(description = "秒杀结束时间")
    private LocalDateTime endDate;
}
