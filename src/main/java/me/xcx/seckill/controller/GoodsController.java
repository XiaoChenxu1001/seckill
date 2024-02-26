package me.xcx.seckill.controller;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import me.xcx.seckill.entity.User;
import me.xcx.seckill.exception.GlobalException;
import me.xcx.seckill.utils.CookieUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
@Controller
public class GoodsController {

    @GetMapping("/goods")
    public String goodsList(Model model, HttpServletRequest request) {
        String userTicket = CookieUtils.getCookieValue(request, "userTicket");
        User user = (User) request.getSession().getAttribute(userTicket);
        if (null == user) {
            return "login";
        }
        return "goodsList";
    }

}
