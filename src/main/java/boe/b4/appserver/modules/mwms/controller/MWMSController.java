package boe.b4.appserver.modules.mwms.controller;

import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.service.MaterialpackingService;
import boe.b4.appserver.modules.mwms.service.impl.MaterialpackingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "MWMSController",description = "MWMS Materialpacking模块")
@RequestMapping("/mwms/materialpacking")
@CrossOrigin
public class MWMSController {

    @Autowired
    MaterialpackingService materialpackingService;

    @ApiOperation("登录密码加密")
    @RequestMapping(value = "/queryOneBox",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryOneBox(String materialpackingname) throws Exception{
        List<Materialpacking> materialpackingList = materialpackingService.queryOneBox(materialpackingname);
        return CommonResult.success(materialpackingList);
    }
}
