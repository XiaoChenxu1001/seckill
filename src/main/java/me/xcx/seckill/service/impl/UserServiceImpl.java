package me.xcx.seckill.service.impl;

import me.xcx.seckill.entity.User;
import me.xcx.seckill.mapper.UserMapper;
import me.xcx.seckill.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
