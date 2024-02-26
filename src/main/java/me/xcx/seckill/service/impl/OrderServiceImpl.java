package me.xcx.seckill.service.impl;

import me.xcx.seckill.entity.Order;
import me.xcx.seckill.mapper.OrderMapper;
import me.xcx.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
