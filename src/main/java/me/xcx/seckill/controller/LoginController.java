package me.xcx.seckill.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import me.xcx.seckill.service.IUserService;
import me.xcx.seckill.vo.ApiResponse;
import me.xcx.seckill.vo.ApiResponseStatus;
import me.xcx.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    @Qualifier(value = "userServiceImpl")
    private IUserService userService;

    // TODO "" 和 "/" 是有去别的，字符串匹配
    @GetMapping("")
    public String login() {
        log.debug("login...");

        return "login";
    }

    @ResponseBody
    @PostMapping("")
    public ApiResponse login(@Valid LoginVo loginVo, HttpServletRequest request) {
        log.debug("login: {}", loginVo);
        return userService.login(loginVo, request);
    }
}
