package boe.b4.appserver.modules.mwms.service;

import boe.b4.appserver.modules.mwms.model.Materialpacking;
import boe.b4.appserver.modules.mwms.model.Materialpackinghistory;
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
public interface MaterialpackinghistoryService extends IService<Materialpackinghistory> {

    List<Materialpackinghistory> queryOneBoxHis(String materialpackingname);
}
