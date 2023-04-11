package boe.b4.appserver.modules.modmes.service.impl;

import boe.b4.appserver.modules.modmes.model.Lot;
import boe.b4.appserver.modules.modmes.mapper.LotMapper;
import boe.b4.appserver.modules.modmes.service.LotService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cim.idm.framework.orm.SqlTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-22
 */
@Service
@DS("modmes")
public class LotServiceImpl extends ServiceImpl<LotMapper, Lot> implements LotService {
    private static final Logger log = LoggerFactory.getLogger(LotServiceImpl.class);
    private static SqlTemplate jdbcTemplate = new SqlTemplate();
    @Autowired
    private LotMapper lp;

    @Override
    public List<Lot> queryLotList(String lotName) {
        QueryWrapper<Lot> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Lot::getLotname,lotName);
        List<Lot> mpList = this.list(wrapper);
        if(mpList != null && mpList.size() > 0){
            log.info(mpList.toString());
            return mpList;
        }
        return null;
    }

    @Override
    public Integer updateLotInfo(Lot lotData){
        String lotName = lotData.getLotname();
        String step = lotData.getProcessoperationname();
        UpdateWrapper<Lot> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Lot::getLotname,lotName);
        wrapper.lambda().set(Lot::getProcessoperationname,step);
        int update = lp.update(null,wrapper);
        return update;
    }

    @Override
    @Autowired(required = false)
    public List<Map<String,Object>> getLotInfo(String lotName){
        String sql = "SELECT lotname FROM LOT WHERE LOTNAME = :LOTNAME ";
        Map<String,Object> bind = new HashMap<String,Object>();
        bind.put("LOTNAME",lotName);
        List<Map<String,Object>> result = jdbcTemplate.queryForList(sql,bind);
//        List bind = new ArrayList();
//        bind.add(lotName);
//        List<Map<String,Object>> result = this.jdbcTemplate.query(sql,bind);

        if(result.size() > 0)
            log.info(result.get(0).get("LOTNAME").toString());
        return result;
    }

}
