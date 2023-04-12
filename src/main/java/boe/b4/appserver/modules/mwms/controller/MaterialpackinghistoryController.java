package boe.b4.appserver.modules.mwms.controller;


import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.model.Materialpackinghistory;
import boe.b4.appserver.modules.mwms.service.MaterialpackinghistoryService;
import boe.b4.appserver.modules.mwms.service.impl.MaterialpackingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(MaterialpackinghistoryController.class);

    @Autowired
    MaterialpackinghistoryService mhService;

    @ApiOperation("登录密码加密")
    @RequestMapping(value = "/queryOneBoxHis",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult queryOneBoxHis(String materialpackingname) throws Exception{
        List<Materialpackinghistory> materialpackingHisList = mhService.queryOneBoxHis(materialpackingname);
        log.info(materialpackingHisList.toString());
        return CommonResult.success(materialpackingHisList);
    }
}

