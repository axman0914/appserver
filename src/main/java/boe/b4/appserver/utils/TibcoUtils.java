package boe.b4.appserver.utils;

import boe.b4.appserver.modules.common.mapper.AppConfigTibcoMapper;
import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.service.AppConfigTibcoService;
import boe.b4.appserver.utils.domain.Tibco;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tibco.tibrv.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TibcoUtils {

    @Autowired
    AppConfigTibcoService tibcoService;

    Map<String, AppConfigTibco> CNMtibcoMap = new HashMap<>();
    Map<String, TibrvRvdTransport> CNMtibrvRvdTransportMap = new HashMap<>();
    Map<String, TibrvCmTransport> CNMtibrvCmTransportMap = new HashMap<>();

    Map<String, AppConfigTibco> QRYtibcoMap = new HashMap<>();
    Map<String, TibrvRvdTransport> QRYtibrvRvdTransportMap = new HashMap<>();
    Map<String, TibrvCmTransport> QRYtibrvCmTransportMap = new HashMap<>();

    public AppConfigTibco getCNMTibcoMap(String shopName){
        if(!CNMtibcoMap.containsKey(shopName)){
            AppConfigTibco appConfigTibco = tibcoService.getCNMTibcoConfig(shopName);
            CNMtibcoMap.put(shopName,appConfigTibco);
        }
        return CNMtibcoMap.get(shopName);
    }

    public TibrvRvdTransport getCNMtibrvRvdTransportMap(String shopName) throws Exception{
        if(!CNMtibrvRvdTransportMap.containsKey(shopName)){
            AppConfigTibco tibco = getCNMTibcoMap(shopName);
            TibrvRvdTransport rvdTransport = new TibrvRvdTransport(tibco.getService(), tibco.getNetwork(), tibco.getDaemon());
            CNMtibrvRvdTransportMap.put(shopName,rvdTransport);
        }
        return  CNMtibrvRvdTransportMap.get(shopName);
    }

    public TibrvCmTransport getCNMtibrvCmTransportMap(String shopName) throws Exception{
        if(!CNMtibrvCmTransportMap.containsKey(shopName)){
            TibrvRvdTransport tibrvRvdTransport = getCNMtibrvRvdTransportMap(shopName);
            TibrvCmTransport cmTransport = new TibrvCmTransport(tibrvRvdTransport, CNMtibcoMap.get(shopName).getCmname(), true);
            CNMtibrvCmTransportMap.put(shopName,cmTransport);
        }
        return CNMtibrvCmTransportMap.get(shopName);
    }

    public AppConfigTibco getQRYTibcoMap(String shopName){
        if(!QRYtibcoMap.containsKey(shopName)){
            AppConfigTibco appConfigTibco = tibcoService.getQRYTibcoConfig(shopName);
            QRYtibcoMap.put(shopName,appConfigTibco);
        }
        return QRYtibcoMap.get(shopName);
    }

    public TibrvRvdTransport getQRYtibrvRvdTransportMap(String shopName) throws Exception{
        if(!QRYtibrvRvdTransportMap.containsKey(shopName)){
            AppConfigTibco tibco = getQRYTibcoMap(shopName);
            TibrvRvdTransport rvdTransport = new TibrvRvdTransport(tibco.getService(), tibco.getNetwork(), tibco.getDaemon());
            QRYtibrvRvdTransportMap.put(shopName,rvdTransport);
        }
        return  QRYtibrvRvdTransportMap.get(shopName);
    }

    public TibrvCmTransport getQRYtibrvCmTransportMap(String shopName) throws Exception{
        if(!QRYtibrvCmTransportMap.containsKey(shopName)){
            TibrvRvdTransport tibrvRvdTransport = getQRYtibrvRvdTransportMap(shopName);
            TibrvCmTransport cmTransport = new TibrvCmTransport(tibrvRvdTransport, QRYtibcoMap.get(shopName).getCmname(), true);
            QRYtibrvCmTransportMap.put(shopName,cmTransport);
        }
        return QRYtibrvCmTransportMap.get(shopName);
    }
}
