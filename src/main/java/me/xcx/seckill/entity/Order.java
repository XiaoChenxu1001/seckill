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
@TableName("t_order")
@Schema(name = "Order", description = "$!{table.comment}")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "订单ID")
    private Long userId;

    @Schema(description = "商品ID")
    private Long goodsId;

    @Schema(description = "收货地址ID")
    private Long deliveryAddrId;

    @Schema(description = "冗余过来的商品名称，方便查询")
    private String goodsName;

    @Schema(description = "商品数量")
    private Integer goodsCount;

    @Schema(description = "商品价格")
    private BigDecimal goodsPrice;

    @Schema(description = "1PC,2android,3ios")
    private Byte orderChannerl;

    @Schema(description = "订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成")
    private Byte status;

    @Schema(description = "订单的创建时间")
    private LocalDateTime createDate;

    @Schema(description = "支付时间")
    private LocalDateTime payDate;
}
