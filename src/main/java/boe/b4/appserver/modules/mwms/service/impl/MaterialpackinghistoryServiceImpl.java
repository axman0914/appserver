package boe.b4.appserver.modules.mwms.service.impl;

import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.model.Materialpackinghistory;
import boe.b4.appserver.modules.mwms.mapper.MaterialpackinghistoryMapper;
import boe.b4.appserver.modules.mwms.service.MaterialpackinghistoryService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
@DS("mwms_prd")
public class MaterialpackinghistoryServiceImpl extends ServiceImpl<MaterialpackinghistoryMapper, Materialpackinghistory> implements MaterialpackinghistoryService {

    @Autowired
    MaterialpackinghistoryMapper mhMapper;

    @Override
    public List<Materialpackinghistory> queryOneBoxHis(String materialpackingname) {
        QueryWrapper<Materialpackinghistory> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Materialpackinghistory::getMaterialpackingname, materialpackingname);
        List<Materialpackinghistory> mpList = this.list(wrapper);
        if (mpList != null && mpList.size() > 0) {
            return mpList;
        }
        return null;
    }
}
