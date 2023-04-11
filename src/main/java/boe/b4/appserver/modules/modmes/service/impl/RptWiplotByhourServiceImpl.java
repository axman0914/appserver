package boe.b4.appserver.modules.modmes.service.impl;

import boe.b4.appserver.modules.modmes.model.RptWiplotByhour;
import boe.b4.appserver.modules.modmes.mapper.RptWiplotByhourMapper;
import boe.b4.appserver.modules.modmes.service.RptWiplotByhourService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cim.idm.framework.IDMFrameServiceProxy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HanLei
 * @since 2023-04-06
 */
@Service
@DS("modmes")
public class RptWiplotByhourServiceImpl extends ServiceImpl<RptWiplotByhourMapper, RptWiplotByhour> implements RptWiplotByhourService {
    @Override
    public List<Map<Object,Object>> getWIPList(){
        IDMFrameServiceProxy nanoFrameServiceProxy;
        List<Map<Object,Object>> sqlResult = null;
        return sqlResult;
    }

}
