package me.xcx.seckill.service;

import jakarta.servlet.http.HttpServletRequest;
import me.xcx.seckill.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import me.xcx.seckill.vo.ApiResponse;
import me.xcx.seckill.vo.LoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
public interface IUserService extends IService<User> {

    ApiResponse<String> login(LoginVo loginVo, HttpServletRequest request);


    User getUserByTicket(String userTicket, HttpServletRequest request);
}
