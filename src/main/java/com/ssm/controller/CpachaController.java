package com.ssm.controller;

import com.ssm.util.CpachaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 11:49
 */
@Controller
@RequestMapping("cpacha")
public class CpachaController {
    /**
     * 获取登陆验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("loginCapcha")
    public void loginCapcha(HttpServletRequest request, HttpServletResponse response)throws IOException {
        CpachaUtil cpachaUtil = new CpachaUtil();
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("loginCapcha", generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
    }
}
