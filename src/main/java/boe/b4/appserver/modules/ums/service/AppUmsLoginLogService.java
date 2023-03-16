package boe.b4.appserver.modules.ums.service;

import boe.b4.appserver.modules.ums.model.AppUmsLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-14
 */
public interface AppUmsLoginLogService extends IService<AppUmsLoginLog> {
    void insertLoginLog(String userId);
}
