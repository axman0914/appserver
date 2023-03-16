package boe.b4.appserver.modules.mwms.service;

import boe.b4.appserver.modules.mwms.model.Materialpacking;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-16
 */
public interface MaterialpackingService extends IService<Materialpacking> {
    List<Materialpacking> queryOneBox(String materialpackingname);
}
