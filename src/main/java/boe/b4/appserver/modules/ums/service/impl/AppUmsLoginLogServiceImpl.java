package boe.b4.appserver.modules.ums.service.impl;

import boe.b4.appserver.modules.ums.model.AppUmsLoginLog;
import boe.b4.appserver.modules.ums.mapper.AppUmsLoginLogMapper;
import boe.b4.appserver.modules.ums.service.AppUmsLoginLogService;
import boe.b4.appserver.utils.HttpUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-14
 */
@Service
public class AppUmsLoginLogServiceImpl extends ServiceImpl<AppUmsLoginLogMapper, AppUmsLoginLog> implements AppUmsLoginLogService {

    @Autowired
    AppUmsLoginLogMapper appUmsLoginLogMapper;

    @Override
    public void insertLoginLog(String userId) {
        AppUmsLoginLog appUmsLoginLog = new AppUmsLoginLog();
        appUmsLoginLog.setUserid(userId);
        DateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmssSSSSSS");
        appUmsLoginLog.setCreatetimekey(dateformat.format(new Date()));
        appUmsLoginLog.setCreatetime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        appUmsLoginLog.setIp(request.getRemoteAddr());
        //appUmsLoginLog.setAddress(HttpUtils.getMacAddrByIp(request.getRemoteAddr()));
        appUmsLoginLogMapper.insert(appUmsLoginLog);
    }
}
