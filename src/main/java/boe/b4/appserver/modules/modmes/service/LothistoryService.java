package boe.b4.appserver.modules.modmes.service;

import boe.b4.appserver.modules.modmes.model.Lothistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HanLei
 * @since 2023-04-06
 */
public interface LothistoryService extends IService<Lothistory> {

    List<Lothistory> queryLothist(String lotName);
}
