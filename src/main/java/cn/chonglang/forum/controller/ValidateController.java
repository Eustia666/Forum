package cn.chonglang.forum.controller;

import cn.chonglang.forum.cache.IpLimitCache;
import cn.chonglang.forum.dto.ValidateDTO;
import cn.chonglang.forum.provider.VaptchaProvider;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*       ├─cn.chonglang.forum         应用目录
               │  ├─controller         控制器目录         <----------
               │  ├─dto                数据传输层
               │  ├─provider           提供类
               │  ├─service            业务逻辑层
               │  ├─advice             异常处理
               │  ├─exception          自定义异常
               │  ├─dao                数据访问层
               │  ├─utils              工具类
               │__├─config             配置类
*/

@Controller
public class ValidateController {

    @Autowired
    private IpLimitCache ipLimitCache;

    @ResponseBody//@ResponseBody返回json格式的数据
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public Object post(@RequestParam(name = "token", required = false) String token,
                       @RequestParam(name = "scene", required = false) int scene,
                       @RequestParam(name = "ip", required = false) String ip) {
        System.out.println("token:"+token+"scene:"+scene+"ip:"+ip);
        if(ipLimitCache.putInterval(ip, token)==0) {   //验证失败
            ipLimitCache.addIpScores(ip,10);
            ValidateDTO validateDTO = new ValidateDTO();
            validateDTO.setMsg("验证频繁，需至少间隔30S");
            validateDTO.setSocre(100);
            validateDTO.setSuccess(0);
            return validateDTO;
        }

/*        创建验证单元，获取VID和Key 。点击创建。
        将https://v-cn.vaptcha.com/v3.js引入到你的页面。
        将 VAPTCHA 初始化到你需要的位置
        用户验证通过得到token，与表单数据一同提交到服务端。
        服务端得到token后，向VAPTCHA 服务器验证token的有效性，验证通过说明此次请求有效*/

        String json = VaptchaProvider.getValidateResult(token,scene,ip);  //Vaptcha第三方提供服务

        JSONObject obj = JSONObject.parseObject(json);     //将第三方服务获取到的json赋给JSONObject的obj对象
        Integer success = obj.getInteger("success");       //将json里的信息分别赋值给三个变量
        Integer score = obj.getInteger("score");
        String msg = obj.getString("msg");
        ValidateDTO validateDTO = new ValidateDTO();
        validateDTO.setMsg(msg);
        validateDTO.setSocre(score);
        validateDTO.setSuccess(success);
     //   System.out.println("result:"+success+score+msg);
        //return ResultDTO.okOf("验证成功！");
        return validateDTO;
    }

    @Deprecated
    @ResponseBody//@ResponseBody返回json格式的数据
    @RequestMapping(value = "/getIp", method = RequestMethod.GET)
    public String getIp() { //搜狐
        // System.out.println("3333"+token);
        /*ValidateDTO validateDTO = new ValidateDTO();
        validateDTO.setId("5d807776fc650fd878051c24");
        validateDTO.setSecretkey("0758d7dab2674d5c8e4e003cf16c4558");
        validateDTO.setToken(token);*/
        String returnCitySN = VaptchaProvider.getIp();
        String json = returnCitySN.split("=")[1].split(";")[0];
        JSONObject obj = JSONObject.parseObject(json);
        String cip = obj.getString("cip");
        String cid = obj.getString("cid");
        String cname = obj.getString("cname");

       /* ValidateDTO validateDTO = new ValidateDTO();
        validateDTO.setMsg(msg);
        validateDTO.setSocre(score);
        validateDTO.setSuccess(success);*/
        //   System.out.println("result:"+success+score+msg);
        //return ResultDTO.okOf("验证成功！");
        return cip;
    }

}
