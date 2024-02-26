package me.xcx.seckill.service;

import me.xcx.seckill.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import me.xcx.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> queryGoodsVoList();
}
