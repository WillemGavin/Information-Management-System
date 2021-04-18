package io.volunteer.modules.app.controller;

import com.alibaba.fastjson.JSONObject;
import io.volunteer.common.utils.R;
import io.volunteer.modules.app.entity.AppUserEntity;
import io.volunteer.modules.app.service.AppUserService;
import io.volunteer.modules.app.utils.HttpClientUtils;
import io.volunteer.modules.app.utils.JwtUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @ClassName WxLoginController
 * Description TODO
 * @Author WillemGavin
 * @Date 2021/4/2 18:58
 * Version 0.0.1
 */
@Controller
@RequestMapping("wx")
public class WxLoginController {
    @Value("${spring.wechat.appid}")
    private String appid;

    @Value("${spring.wechat.appsecret}")
    private String appsecret;

    @Value("${spring.wechat.callback}")
    private String http;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AppUserService appUserService;


    @GetMapping("/login")
    public String wxlogin() {
        // 第一步：用户同意授权，获取code
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid +
                "&redirect_uri=" + http +
                "&response_type=code" +
                "&scope=snsapi_base" +
                "&state=STATE#wechat_redirect";
        return "redirect:" + url;
    }

    @GetMapping("/wxcallback")
    public String wxcallback(String code, ModelMap map) throws IOException {
        // 第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                "&secret=" + appsecret +
                "&code=" + code +
                "&grant_type=authorization_code";

        JSONObject jsonObject = HttpClientUtils.httpGet(url);

        String openId = jsonObject.getString("openid");
        String access_Token = jsonObject.getString("access_token");

        System.out.println("access_Token"+ access_Token);

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_Token +
                "&openid=" + openId +
                "&lang=zh_CN";
        JSONObject userInfoJson = HttpClientUtils.httpGet(url);
        System.out.println("UserInfo:" + userInfoJson);

//        AppUserEntity appUserEntity = appUserService.queryByOpenId(openId);
        // 微信帐号做来一个关联，来关联我们的账号体系
//        if(appUserEntity == null){
//
//            AppUserEntity user = new AppUserEntity();
//            user.setOpenid(openId);
//            user.setState(0);
//            //保存用户信息
//            appUserService.saveOrUpdate(user);
//        }
//        Long userId = appUserService.login(openId);
//        String token = jwtUtils.generateToken(appUserService.login(openId));
        // 此处实现自己的保存用户信息逻辑
//        return "redirect:http://biki.wiki/?userId=" + userId + "&token=" + token;
        return "";
    }

//    @GetMapping("/gohome")
//    public R gohome(String openid, ModelMap map) {
//        //生成token
//        String token = jwtUtils.generateToken(appUserService.login(openid));
//            return R.ok().put("token", token).put("expire", jwtUtils.getExpire()).put("home", "/");  // 打开首页
////        }
//    }
//
//    @GetMapping("/register")
//    public String register(String openid, ModelMap map) {
//        map.put("openid", openid);
//        return "/upload";  // 我这里是打开上传页面，可根据自己业务需要实际来跳转
//    }
//    @GetMapping("/success")
//    public String register() {
//        return "/success";  // 打开注册成功页面
//    }
}
