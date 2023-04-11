package boe.b4.appserver.modules.modmes.service;

import boe.b4.appserver.modules.modmes.model.RptWiplotByhour;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HanLei
 * @since 2023-04-06
 */
public interface RptWiplotByhourService extends IService<RptWiplotByhour> {
List<Map<Object,Object>> getWIPList();
}
