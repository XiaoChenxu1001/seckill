package me.xcx.seckill.mapper;

import me.xcx.seckill.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.xcx.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> queryGoodsVoList();

}
