package me.xcx.seckill.config;

import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import me.xcx.seckill.entity.User;
import me.xcx.seckill.exception.GlobalException;
import me.xcx.seckill.service.IUserService;
import me.xcx.seckill.utils.CookieUtils;
import me.xcx.seckill.vo.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


    @Autowired
    private IUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    // 简化从ticket获取User对象的步骤
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                    NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String userTicket = CookieUtils.getCookieValue(request, "userTicket");
        if (StringUtils.isBlank(userTicket)) {
//            return null;
            throw new GlobalException(ApiResponseStatus.NOT_AUTHENTICATED);
        }

        User user = userService.getUserByTicket(userTicket, request);
        if (user == null) {
            throw new GlobalException(ApiResponseStatus.NOT_AUTHENTICATED);
        }
        return user;
    }
}
