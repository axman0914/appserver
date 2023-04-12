package boe.b4.appserver.modules.common.controller;

import boe.b4.appserver.modules.common.model.query.MWMS_QueryObj;
import boe.b4.appserver.modules.common.service.impl.TibQueryServiceImpl;
import boe.b4.appserver.modules.common.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "TibQueryController",description = "Tibco查询")
@RequestMapping("/tibquery")
@CrossOrigin
public class TibQueryController {

    private static Logger log = Logger.getLogger(TibQueryController.class);
    @Autowired
    TibQueryServiceImpl tibQueryService;

    @ApiOperation("Tibco查询")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult query(@Validated MWMS_QueryObj MWMSQueryObj) throws Exception{
        List<MWMS_QueryObj> queryList = tibQueryService.query(MWMSQueryObj);
        log.info(queryList.toString());
        return CommonResult.success(queryList);
    }
}
