package com.demo.controller;

import com.demo.util.WxUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author xyd
 * @version V1.0
 * @Package com.demo.controller
 * @Description:
 * @date 2018/8/6 17:19
 */
@RestController
@RequestMapping("/wx")
public class DemoController {
    public static final String TOKEN = "xiaoyue_login_token";

    @PostMapping("/login")
    public String login(String code, String state, HttpServletRequest request) throws Exception {
        return WxUtils.getLoginAcessToken("wxb27d690ac51c11e6", "e1a28143baaa5da6a237aa152f93625e", code);
    }

    @PostMapping("/loginOpen")
    public String loginOpen(String code, String state, HttpServletRequest request) throws Exception {
        return WxUtils.getLoginAcessToken("wxb27d690ac51c11e6", "e1a28143baaa5da6a237aa152f93625e", code);
    }

    @GetMapping("/get")
    public void get(String signature,String timestamp,String nonce,String echostr, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        // 将token、timestamp、nonce三个参数进行字典序排序
        System.out.println("签名signature:"+signature);
        System.out.println("生成签名时间戳timestamp:"+timestamp);
        System.out.println("生成签名随机串nonceStr:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("TOKEN:"+TOKEN);
        String[] params = new String[] { TOKEN, timestamp, nonce };
        Arrays.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String clearText = params[0] + params[1] + params[2];
        String algorithm = "SHA-1";
        String sign = new String(
                org.apache.commons.codec.binary.Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (signature.equals(sign)) {
            response.getWriter().print(echostr);
        }
    }

}
