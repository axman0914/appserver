package boe.b4.appserver.modules.common.controller;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.model.UserLoginParam;
import boe.b4.appserver.modules.common.service.AppConfigTibcoService;
import boe.b4.appserver.modules.common.service.LoginService;
import boe.b4.appserver.modules.common.service.impl.LoginServiceImpl;
import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.ums.service.impl.AppUmsLoginLogServiceImpl;
import boe.b4.appserver.utils.domain.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "LoginController",description = "登录密码加密")
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private static Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    AppUmsLoginLogServiceImpl appUmsLoginLogService;
    @Autowired
    AppConfigTibcoService appConfigTibcoService;

    @ApiOperation("登录密码加密")
    @RequestMapping(value = "/rsaPwd",method = RequestMethod.GET)
    @ResponseBody
    public String rsaPwd(String userid, String pwd) throws Exception{
        String result = loginService.rsaPwd(pwd);
        appUmsLoginLogService.insertLoginLog(userid);
        return result;
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult login(@Validated UserLoginParam userLoginParam) throws Exception{
        AppConfigTibco tibco = appConfigTibcoService.getCNMTibcoConfig(userLoginParam.getShopName());
        Message message = loginService.login(userLoginParam.getUsername(), userLoginParam.getPwd(), tibco);
        if(message.getReturnCode().equals("0")){
            return CommonResult.success(message);
        }
        else{
            return  CommonResult.failed(message.getReturnMsg());
        }
    }

    @ApiOperation("查找ShopName")
    @RequestMapping(value = "/getShopName",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getShopName() throws Exception{
        List<AppConfigTibco> tibcoList =  appConfigTibcoService.getShopName();
        log.info(tibcoList.toString());
        return CommonResult.success(tibcoList);
    }
}
