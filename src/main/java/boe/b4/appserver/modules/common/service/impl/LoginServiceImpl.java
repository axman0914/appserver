package boe.b4.appserver.modules.common.service.impl;

import boe.b4.appserver.modules.common.service.LoginService;
import boe.b4.appserver.utils.JSMethods;
import boe.b4.appserver.utils.JavaScriptProvider;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.io.FileNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {

    private static Logger log = Logger.getLogger(LoginServiceImpl.class);

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
}
