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
import java.util.Map;

/**
 * @author xyd
 * @version V1.0
 * @Package com.demo.controller
 * @Description:
 * @date 2018/8/6 17:19
 */
@RestController("demo")
@RequestMapping("/wx")
public class DemoController {

    @PostMapping("/login")
    public Map<String, String> login(String code, String state, HttpServletRequest request) throws Exception {
        return WxUtils.getLoginAcessToken("", "", "");
    }

    @GetMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("signature:" + signature);
        System.out.println("timestamp:" + timestamp);
        System.out.println("nonce:" + nonce);
        System.out.println("echostr:" + echostr);
        PrintWriter pw = response.getWriter();
        pw.append(echostr);
        pw.flush();
    }
}
