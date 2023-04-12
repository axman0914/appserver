package boe.b4.appserver.modules.common.service.impl;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.model.query.MWMS_QueryObj;
import boe.b4.appserver.modules.common.service.AppConfigTibcoService;
import boe.b4.appserver.modules.common.service.TibQueryService;
import boe.b4.appserver.utils.CmSender;
import boe.b4.appserver.utils.XMLUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TibQueryServiceImpl implements TibQueryService {

    private static Logger log = Logger.getLogger(TibQueryServiceImpl.class);

    @Resource
    private CmSender cmSender;
    @Autowired
    AppConfigTibcoService appConfigTibcoService;

    @Override
    public List<MWMS_QueryObj> query(MWMS_QueryObj MWMSQueryObj) throws Exception {
        String msg = XMLUtils.createQueryMessage(MWMSQueryObj);
        log.info(msg);
        String currentTime1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") .format(new Date());
        System.err.println("Start time："+currentTime1);
        log.error(msg);
        AppConfigTibco tibco = appConfigTibcoService.getQRYTibcoConfig(MWMSQueryObj.getShopName());
        List<MWMS_QueryObj> returnMsg=cmSender.sendQRYRequest(msg,tibco);
        System.out.println(returnMsg.toString());
        log.info("-----pda returnMsg-----");
        log.info(returnMsg);
        String currentTime2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") .format(new Date());
        System.out.println("End time："+currentTime2);
        return  returnMsg;
    }
}
