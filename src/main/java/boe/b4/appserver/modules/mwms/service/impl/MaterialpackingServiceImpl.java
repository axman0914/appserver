package boe.b4.appserver.modules.mwms.service.impl;

import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.mapper.MaterialpackingMapper;
import boe.b4.appserver.modules.mwms.service.MaterialpackingService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-16
 */
@Service
@DS("mwms")
public class MaterialpackingServiceImpl extends ServiceImpl<MaterialpackingMapper, Materialpacking> implements MaterialpackingService {

    private static final Logger log = LoggerFactory.getLogger(MaterialpackingServiceImpl.class);
    @Autowired
    private MaterialpackingMapper mp;

    @Override
    public List<Materialpacking> queryOneBox(String materialpackingname) {
        QueryWrapper<Materialpacking> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Materialpacking::getMaterialpackingname,materialpackingname);
        List<Materialpacking> mpList = this.list(wrapper);
        if(mpList != null && mpList.size() > 0){
            return mpList;
        }
        return null;
    }
}
