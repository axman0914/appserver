package boe.b4.appserver.modules.common.service.impl;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.mapper.AppConfigTibcoMapper;
import boe.b4.appserver.modules.common.service.AppConfigTibcoService;
import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.utils.SpringProfileService;
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
 * @author B4CIM
 * @since 2023-03-27
 */
@Service
public class AppConfigTibcoServiceImpl extends ServiceImpl<AppConfigTibcoMapper, AppConfigTibco> implements AppConfigTibcoService {

    @Autowired
    AppConfigTibcoMapper mapper;
    @Autowired
    SpringProfileService profileService;

    @Override
    public AppConfigTibco getCNMTibcoConfig(String shopName) {

        System.out.println(profileService.getProfile());
        QueryWrapper<AppConfigTibco> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AppConfigTibco::getTibName,shopName)
        .eq(AppConfigTibco::getTibMode,profileService.getProfile())
        .eq(AppConfigTibco::getTibSvr,"CNMsvr");
        List<AppConfigTibco> tibList = this.list(wrapper);
        if(tibList != null && tibList.size() > 0){
            return tibList.get(0);
        }
        return null;
    }

    @Override
    public List<AppConfigTibco> getShopName() {
        QueryWrapper<AppConfigTibco> wrapper = new QueryWrapper<>();
        wrapper.select("distinct tib_name")
                .orderByAsc("tib_name");
        List<AppConfigTibco> tibList = this.list(wrapper);
        if(tibList != null && tibList.size() > 0){
            return tibList;
        }
        return null;
    }

    @Override
    public AppConfigTibco getQRYTibcoConfig(String shopName) {
        System.out.println(profileService.getProfile());
        QueryWrapper<AppConfigTibco> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AppConfigTibco::getTibName,shopName)
                .eq(AppConfigTibco::getTibMode,profileService.getProfile())
                .eq(AppConfigTibco::getTibSvr,"QRYsvr");
        List<AppConfigTibco> tibList = this.list(wrapper);
        if(tibList != null && tibList.size() > 0){
            return tibList.get(0);
        }
        return null;
    }

}
