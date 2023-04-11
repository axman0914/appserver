package boe.b4.appserver.modules.modmes.service.impl;


import boe.b4.appserver.modules.modmes.model.Lothistory;
import boe.b4.appserver.modules.modmes.mapper.LothistoryMapper;
import boe.b4.appserver.modules.modmes.service.LothistoryService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cim.idm.framework.orm.SqlTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
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
public class LothistoryServiceImpl extends ServiceImpl<LothistoryMapper, Lothistory> implements LothistoryService {
    private static final Logger log = LoggerFactory.getLogger(LotServiceImpl.class);
    private static SqlTemplate jdbcTemplate = new SqlTemplate();
    @Override
    public List<Lothistory> queryLothist(String lotName) {
        QueryWrapper<Lothistory> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Lothistory::getLotname,lotName);
        List<Lothistory> mpList = this.list(wrapper);
        if(mpList != null && mpList.size() > 0){
            log.info(mpList.toString());
            return mpList;
        }
        return null;
    }

    public  List<Map<Object,Object>> getLotHist(){
        String sql = "";
        Map<String,Object> bind = new HashMap<String,Object>();
        List<Map<Object,Object>> result = jdbcTemplate.queryForList(sql,bind);
        return result;
    }
}
