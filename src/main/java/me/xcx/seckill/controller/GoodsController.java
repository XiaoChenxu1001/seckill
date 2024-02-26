package me.xcx.seckill.controller;

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
    public String goodsList() {
        return "goodsList";
    }

}
