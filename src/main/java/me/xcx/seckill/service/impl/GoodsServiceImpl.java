package me.xcx.seckill.service.impl;

import me.xcx.seckill.entity.Goods;
import me.xcx.seckill.mapper.GoodsMapper;
import me.xcx.seckill.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.xcx.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> queryGoodsVoList() {
        return goodsMapper.queryGoodsVoList();
    }
}
