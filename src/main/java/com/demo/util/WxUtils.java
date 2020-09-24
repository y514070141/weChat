package com.demo.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xyd
 * @version V1.0
 * @Package com.demo.util
 * @Description:
 * @date 2018/8/6 17:24
 */
public class WxUtils {
    /**
     * 获取Openid
     * @param appid
     * @param secret
     * @param code
     * @return
     * @throws Exception
     */
    public static String getLoginAcessToken(String  appid, String secret, String code) throws Exception{
        HttpClient httpclient =  HttpClients.createDefault();
        //静默授权
        String smsUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb27d690ac51c11e6&redirect_uri=http%3a%2f%2f94xaqa.natappfree.cc%2f&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
//        String smsUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=http%3a%2f%2fc8vhdy.natappfree.cc%2findex.jsp&response_type="+code+"&scope=snsapi_userinfo&state=123#wechat_redirect";
        HttpGet httpGet = new HttpGet(smsUrl);
        String strResult = "";

        HttpResponse response = httpclient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            strResult = EntityUtils.toString(response
                    .getEntity(),"UTF-8");
        }

          System.out.println(strResult);
        return strResult;
    }
}
