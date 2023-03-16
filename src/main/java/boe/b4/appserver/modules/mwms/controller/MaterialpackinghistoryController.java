package boe.b4.appserver.modules.mwms.controller;


import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.model.Materialpackinghistory;
import boe.b4.appserver.modules.mwms.service.MaterialpackinghistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/mwms/materialpackinghistory")
@Api(tags = "MWMSController",description = "MWMS Materialpackinghistory模块")
@CrossOrigin
public class MaterialpackinghistoryController {

    @Autowired
    MaterialpackinghistoryService mhService;

    @ApiOperation("登录密码加密")
    @RequestMapping(value = "/queryOneBoxHis",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryOneBoxHis(String materialpackingname) throws Exception{
        List<Materialpackinghistory> materialpackingHisList = mhService.queryOneBoxHis(materialpackingname);
        return CommonResult.success(materialpackingHisList);
    }
}

