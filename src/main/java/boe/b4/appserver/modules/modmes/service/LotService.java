package boe.b4.appserver.modules.modmes.service;

import boe.b4.appserver.modules.modmes.model.Lot;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XuShu
 * @since 2023-03-22
 */
public interface LotService extends IService<Lot> {

    List<Lot> queryLotList(String lotName);
    Integer updateLotInfo(Lot lotData);

    List<Map<String,Object>> getLotInfo(String lotName);
}
