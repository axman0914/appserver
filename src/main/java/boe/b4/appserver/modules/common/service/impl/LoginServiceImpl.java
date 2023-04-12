package boe.b4.appserver.modules.common.service.impl;

import boe.b4.appserver.modules.common.mapper.LoginMapper;
import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.model.AppUmsLoginLog;
import boe.b4.appserver.modules.common.model.UserLoginParam;
import boe.b4.appserver.modules.common.service.LoginService;
import boe.b4.appserver.utils.CmSender;
import boe.b4.appserver.utils.JSMethods;
import boe.b4.appserver.utils.JavaScriptProvider;
import boe.b4.appserver.utils.XMLUtils;
import boe.b4.appserver.utils.domain.Message;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private static Logger log = Logger.getLogger(LoginServiceImpl.class);

    @Resource
    private CmSender cmSender;



    @Autowired
    LoginMapper loginMapper;

    private List<UserLoginParam> loadLogin(Integer key) {
        return null;
    }

    public String rsaPwd(String pwd){
        log.info(pwd);
        String result = "";
        try {
            JavaScriptProvider<JSMethods> jsProvider = new JavaScriptProvider<>();
            JSMethods jsMethods = jsProvider.loadJs("security.js",JSMethods.class);
            result = jsMethods.encodeInp(pwd);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

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
        loginMapper.insert(appUmsLoginLog);
    }

    @Override
    public Message login(String userName, String pwd,  AppConfigTibco tibco) throws Exception{
        String msg = XMLUtils.createLoginMessage(userName, pwd, tibco.getTibName());
        log.info(msg);
        String currentTime1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") .format(new Date());
        System.err.println("Start time："+currentTime1);
        log.error(msg);
        Message returnMsg=cmSender.sendRequest(msg,tibco);
        System.out.println(returnMsg);
        log.info("-----pda returnMsg-----");
        log.info(returnMsg);
        String currentTime2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") .format(new Date());
        System.out.println("End time："+currentTime2);
        return  returnMsg;
    }

}
