package boe.b4.appserver.modules.modmes.controller;


import boe.b4.appserver.modules.common.utils.CommonResult;
import boe.b4.appserver.modules.modmes.model.Lot;
import boe.b4.appserver.modules.modmes.model.Lothistory;
import boe.b4.appserver.modules.modmes.service.LothistoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author HanLei
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/modmes/lothistory")
public class LothistoryController {
    @Autowired
    LothistoryService lothistService;

    @ApiOperation("查询Lot历史")
    @RequestMapping(value = "/queryLothist",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult queryLotInfoList(String lotName) throws Exception{
        List<Lothistory> lotList = lothistService.queryLothist(lotName);
        return CommonResult.success(lotList);
    }
}

