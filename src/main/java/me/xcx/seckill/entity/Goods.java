package me.xcx.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_goods")
@Schema(name = "Goods", description = "$!{table.comment}")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "商品ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "商品名称")
    private String goodsName;

    @Schema(description = "商品标题")
    private String goodsTitle;

    @Schema(description = "商品图片")
    private String goodsImg;

    @Schema(description = "商品详情")
    private String goodsDetail;

    @Schema(description = "商品价格")
    private BigDecimal goodsPrice;

    @Schema(description = "商品库存，-1表示没有限制")
    private Integer goodsStock;
}
