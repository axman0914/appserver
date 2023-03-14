package boe.b4.appserver.utils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaScriptProvider<T> {

    public T loadJs(String jsName,Class<T> clazz) throws FileNotFoundException, ScriptException {
        //创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        //获取一个指定的名称的脚本管理器
        ScriptEngine engine = manager.getEngineByName("js");
        //获取js文件所在的目录的路径
        //String path = JavaScriptProvider.class.getResource("").getPath()+"/js/";
        String path = this.getClass().getClassLoader().getResource("js/").getPath();
        engine.eval(new FileReader(path+jsName));
        //engine.eval(new FileReader(jsName));
        //从脚本引擎中返回一个给定接口的实现
        Invocable invocable = (Invocable) engine;
        return invocable.getInterface(clazz);
    }


    public static void main(String[] args) {
        try {
            JavaScriptProvider<JSMethods> jsProvider = new JavaScriptProvider<>();
            JSMethods jsMethods = jsProvider.loadJs("security.js",JSMethods.class);
            System.out.println(jsMethods.encodeInp("020406Ax#!-#!-#!1678456886557"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }

}
