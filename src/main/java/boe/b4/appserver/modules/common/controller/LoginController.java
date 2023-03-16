package boe.b4.appserver.modules.common.controller;

import boe.b4.appserver.modules.common.service.LoginService;
import boe.b4.appserver.modules.ums.service.AppUmsLoginLogService;
import boe.b4.appserver.modules.ums.service.impl.AppUmsLoginLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "LoginController",description = "登录密码加密")
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    AppUmsLoginLogServiceImpl appUmsLoginLogService;

    @ApiOperation("登录密码加密")
    @RequestMapping(value = "/rsaPwd",method = RequestMethod.GET)
    @ResponseBody
    public String rsaPwd(String userid, String pwd) throws Exception{
        String result = loginService.rsaPwd(pwd);
        appUmsLoginLogService.insertLoginLog(userid);
        return result;
    }
}
