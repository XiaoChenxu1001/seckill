package me.xcx.seckill.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import me.xcx.seckill.MD5Utils;
import me.xcx.seckill.entity.User;
import me.xcx.seckill.exception.GlobalException;
import me.xcx.seckill.mapper.UserMapper;
import me.xcx.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.xcx.seckill.vo.ApiResponse;
import me.xcx.seckill.vo.ApiResponseStatus;
import me.xcx.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public ApiResponse<String> login(LoginVo loginVo, HttpServletRequest request) {
        // 根据手机号获取用户
        User user = userMapper.selectById(loginVo.getMobile());
        if (null == user) {
            throw new GlobalException(ApiResponseStatus.LOGIN_ERROR);
//            return ApiResponse.error(ApiResponseStatus.LOGIN_ERROR);
        }
        String password = loginVo.getPassword();
        String saltPassword = MD5Utils.plaintextToCiphertext(password, user.getSalt());
        // 检查密码
        if (!StringUtils.equals(saltPassword, user.getPassword())) {
            throw new GlobalException(ApiResponseStatus.LOGIN_ERROR);
//            return ApiResponse.error(ApiResponseStatus.LOGIN_ERROR);
        }
        // 作为分布式唯一标识
        String ticket = UUID.randomUUID().toString();
        request.getSession().setAttribute(ticket, user);
        return ApiResponse.success(ticket); // 返回ticket
    }
}
