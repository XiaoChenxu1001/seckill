package me.xcx.seckill.controller;

import jakarta.servlet.http.HttpServletRequest;
import me.xcx.seckill.entity.Goods;
import me.xcx.seckill.entity.User;
import me.xcx.seckill.service.IGoodsService;
import me.xcx.seckill.utils.CookieUtils;
import me.xcx.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xcx
 * @since 2024-02-26
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    IGoodsService goodsService;

    @GetMapping("")
    public String goodsList(Model model, User user, HttpServletRequest request) {
        List<GoodsVo> goodsList = goodsService.queryGoodsVoList();
        model.addAttribute("goodsList", goodsList);
        return "goodsList";
    }

    @GetMapping("/datail")
    public String goodsDetail(Model model, User user, HttpServletRequest request) {
        return "goodsDetail";
    }


}
