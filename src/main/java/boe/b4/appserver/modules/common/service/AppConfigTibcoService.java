package boe.b4.appserver.modules.common.service;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author B4CIM
 * @since 2023-03-27
 */
public interface AppConfigTibcoService extends IService<AppConfigTibco> {

    AppConfigTibco getCNMTibcoConfig(String shopName);

    List<AppConfigTibco> getShopName();

    AppConfigTibco getQRYTibcoConfig(String shopName);

}
