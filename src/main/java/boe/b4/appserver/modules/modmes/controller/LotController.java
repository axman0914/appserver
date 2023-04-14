package boe.b4.appserver.modules.modmes.controller;


import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.modmes.model.Lot;
import boe.b4.appserver.modules.modmes.service.LotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2023-03-22
 */
@Controller
@CrossOrigin
@RequestMapping("/modmes/lot")
public class LotController {
    @Autowired
    LotService lotService;

    @ApiOperation("查询Lot信息")
    @RequestMapping(value = "/queryLotList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryLotInfoList(String lotName) throws Exception{
        List<Lot> lotList = lotService.queryLotList(lotName);
        return CommonResult.success(lotList);
    }

    @ApiOperation("更新Lot信息")
    @RequestMapping(value = "/updateLotInfo",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateLotInfo(Lot lotData) throws Exception{
        int update = lotService.updateLotInfo(lotData);
        return CommonResult.success(update);
    }

    /*@ApiOperation("查询Lot信息")
    @RequestMapping(value = "/getLotInfo",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getLotInfo(String lotName) throws Exception{
        List<Map<String,Object>> lotList = lotService.getLotInfo(lotName);
        return CommonResult.success(lotList);
    }*/
}

