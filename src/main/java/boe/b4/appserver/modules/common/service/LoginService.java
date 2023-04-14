package boe.b4.appserver.modules.common.service;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.model.UserLoginParam;
import boe.b4.appserver.utils.domain.Message;

public interface LoginService {

    String rsaPwd(String pwd);

    public void insertLoginLog(String userId);

    Message login(String userName, String pwd, AppConfigTibco tibco) throws Exception;
}
