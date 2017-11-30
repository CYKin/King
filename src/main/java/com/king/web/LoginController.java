package com.king.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.king.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;


/**
 * @author King
 * @date 2017/11/9
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private Producer captchaProducer;

    /**
     * 获取验证码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getKaptcha")
    public String getKaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        //生成验证码
        String code = NumberUtil.stringRandom(4);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, code);

        //生产图片
        BufferedImage bi = captchaProducer.createImage(code);
        //ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);

        //图片base64
        //String param = "data:image/jpg;base64,"+new BASE64Encoder().encode(bao.toByteArray());
        return null;
    }


    /**
     * 校验验证码
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/checkKaptcha")
    public String checkKaptcha(HttpServletRequest request, String checkCode) throws Exception {

        String sessionCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        String isSuccess = "";
        if (checkCode != null && checkCode.equalsIgnoreCase(sessionCode)) {
            isSuccess = "恭喜您，验证码输入成功";
        } else {
            isSuccess = "验证码输入失败啦，囧";
        }
        return isSuccess;
    }


}
