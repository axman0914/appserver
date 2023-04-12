package boe.b4.appserver.utils;

import boe.b4.appserver.modules.common.model.query.MWMS_QueryObj;
import com.alibaba.fastjson.JSONObject;
import boe.b4.appserver.utils.domain.Message;
import cn.hutool.core.util.XmlUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.StringWriter;

public class XMLUtils {
    private static Logger log = Logger.getLogger(XMLUtils.class);

    public static String createLoginMessage(String userName, String pwd, String shopName) {
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点root-Message
            Element root = document.addElement("Message");
            //3.header-Header
            Element header = root.addElement("Header");
            Element message = header.addElement("MESSAGENAME");
            message.setText("UserLogin");
            Element shopname = header.addElement("SHOPNAME");
            shopname.setText(shopName);
            Element machinename = header.addElement("MACHINENAME");
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssssssss");
            String dateString = formatter.format(currentTime);
            Element transactionid = header.addElement("TRANSACTIONID");
            transactionid.setText(dateString);
            Element originalsourcesubjectname = header.addElement("ORIGINALSOURCESUBJECTNAME");
            Element sourcesubjectname = header.addElement("SOURCESUBJECTNAME");
            Element targetsubectname = header.addElement("TARGETSUBECTNAME");
            Element eventuser = header.addElement("EVENTUSER");
            Element eventcomment = header.addElement("EVENTCOMMENT");
            Element inputset = header.addElement("INPUTSET");
            Element language = header.addElement("LANGUAGE");
            language.setText("zh-CN");

            //4.Body
            Element body = root.addElement("Body");
            Element userid = body.addElement("USERID");
            userid.setText(userName);
            Element password = body.addElement("PASSWORD");
            password.setText(pwd);
            Element uiname = body.addElement("UINAME");
            uiname.setText("OIC");
            Element workstationname = body.addElement("WORKSTATIONNAME");
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            workstationname.setText(request.getRemoteAddr());
            Element loggedinuiversion = body.addElement("LOGGEDINUIVERSION");
            loggedinuiversion.setText("1.0.0.0");

            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");
            // 7、生成xml字符串
            StringWriter sw = new StringWriter();
            XMLWriter xmlWriter = new XMLWriter(sw, format);
            // 设置是否转义，默认使用转义字符
            xmlWriter.setEscapeText(false);
            xmlWriter.write(document);
            xmlWriter.close();
            return sw.toString();
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

    }

    public static Message CheckErrorMessage(String msg) throws Exception {
        if(msg == null){
            return  null;
        }
        InputStream is = new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8));
        org.w3c.dom.Document document = XmlUtil.readXML(is);
        org.w3c.dom.Element returnCode = XmlUtil.getElementByXPath("//Message/Return/RETURNCODE", document);
        org.w3c.dom.Element returnMsg = XmlUtil.getElementByXPath("//Message/Return/RETURNMESSAGE", document);
        Message message = new Message();
        message.setReturnCode(returnCode.getTextContent());
        message.setReturnMsg(returnMsg.getTextContent());
        return message;
    }


    public static String createQueryMessage(MWMS_QueryObj MWMSQueryObj) {
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点root-Message
            Element root = document.addElement("Message");
            //3.header-Header
            Element header = root.addElement("Header");
            Element message = header.addElement("MESSAGENAME");
            message.setText("GetQueryResult");
            Element shopname = header.addElement("SHOPNAME");
            shopname.setText(MWMSQueryObj.getShopName());
            Element machinename = header.addElement("MACHINENAME");
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssssssss");
            String dateString = formatter.format(currentTime);
            Element transactionid = header.addElement("TRANSACTIONID");
            transactionid.setText(dateString);
            Element originalsourcesubjectname = header.addElement("ORIGINALSOURCESUBJECTNAME");
            Element sourcesubjectname = header.addElement("SOURCESUBJECTNAME");
            Element targetsubectname = header.addElement("TARGETSUBECTNAME");
            Element eventuser = header.addElement("EVENTUSER");
            Element eventcomment = header.addElement("EVENTCOMMENT");
            Element inputset = header.addElement("INPUTSET");
            Element language = header.addElement("LANGUAGE");
            language.setText("zh-CN");

            //4.Body
            Element body = root.addElement("Body");
            Element userid = body.addElement("QUERYID");
            userid.setText(MWMSQueryObj.getQueryId());
            Element password = body.addElement("VERSION");
            password.setText(MWMSQueryObj.getVersion());
            Element bindv = body.addElement("BINDV");

            Map<String, String> map = new HashMap<String, String>();

            Field[] declaredFields = MWMSQueryObj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), (String) field.get(MWMSQueryObj));
            }

            for (String k : map.keySet()) {
                String v = map.get(k);
                if(v != null && !v.equals("")){
                    Element e = bindv.addElement(k.toUpperCase());
                    e.setText(v);
                }
            }

            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");
            // 7、生成xml字符串
            StringWriter sw = new StringWriter();
            XMLWriter xmlWriter = new XMLWriter(sw, format);
            // 设置是否转义，默认使用转义字符
            xmlWriter.setEscapeText(false);
            xmlWriter.write(document);
            xmlWriter.close();
            return sw.toString();
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

    }

    /**
     * xml字符串转集合对象
     *
     * @param classObject
     * @param xmlStr
     * @param entityStr   对象的字符串标识
     * @param <T>
     * @return
     */
    public static <T> List<T> xmlToObjectList(Class<T> classObject, String xmlStr,String listStr, String entityStr) {
        String xmlStrNew = xmlStrFormat(xmlStr, listStr);
        Document doc = null;
        List<T> list = new ArrayList<>();
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xmlStrNew);
            // 获取根节点
            Element rootElt = doc.getRootElement();
            // 获取根节点下所有content
            Iterator<Element> it = rootElt.elementIterator(entityStr);
            while (it.hasNext()) {
                Element elementGroupService = (Element) it.next();
                list.add(fromXmlToBean(elementGroupService, classObject));
            }
        } catch (Exception e) {
            log.info("数据解析错误");
        }
        return list;
    }

    /**
     * xml字符串解析成对象
     *
     * @param classObject
     * @param xmlStr
     * @param <T>
     * @return
     */
    public static <T> T xmlToObject(Class<T> classObject, String xmlStr, String entityStr) {
        xmlStr = xmlStrFormat(xmlStr, entityStr);
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        T t = null;
        try {
            // 指定编码格式为UTF-8,可根据具体情况修改
            Document document = reader.read(new InputSource(new ByteArrayInputStream(xmlStr.getBytes("UTF-8"))));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            t = fromXmlToBean(bookStore, classObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(JSONObject.toJSONString(t), classObject);
    }

    /**
     * 截取xml指定数据对象字符串
     *
     * @param xmlStr
     * @param entityStr
     * @return
     */
    public static String xmlStrFormat(String xmlStr, String entityStr) {
        String formatStr = "";
        xmlStr = xmlStr.replaceAll("&lt;", "<");
        xmlStr = xmlStr.replaceAll("&gt;", ">");
        xmlStr = xmlStr.replaceAll("(\r\n|\n)", "");
        xmlStr = xmlStr.replaceAll(" ", "");
        String s = "</" + entityStr;
        formatStr = xmlStr.substring(xmlStr.indexOf("<" + entityStr), xmlStr.lastIndexOf(s) + s.length() + 1);
        return formatStr;
    }

    /**
     * xml字符串解析成对象底层
     *
     * @param rootElt
     * @param pojo
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T fromXmlToBean(Element rootElt, Class<T> pojo) throws Exception {
        // 首先得到pojo所定义的字段
        Field[] fields = pojo.getDeclaredFields();
        // 根据传入的Class动态生成pojo对象
        Object obj = pojo.newInstance();
        for (Field field : fields) {
            // 设置字段可访问（必须，否则报错）
            field.setAccessible(true);
            // 得到字段的属性名
            String name = field.getName();
            // 这一段的作用是如果字段在Element中不存在会抛出异常，如果出异常，则跳过。
            try {
                rootElt.elementTextTrim(name);
            } catch (Exception ex) {
                continue;
            }
            if (rootElt.elementTextTrim(name) != null && !"".equals(rootElt.elementTextTrim(name))) {
                // 根据字段的类型将值转化为相应的类型，并设置到生成的对象中。
                if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                    field.set(obj, Long.parseLong(rootElt.elementTextTrim(name)));
                } else if (field.getType().equals(String.class)) {
                    field.set(obj, rootElt.elementTextTrim(name));
                } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                    field.set(obj, Double.parseDouble(rootElt.elementTextTrim(name)));
                } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                    field.set(obj, Integer.parseInt(rootElt.elementTextTrim(name)));
                } else if (field.getType().equals(java.util.Date.class)) {
                    field.set(obj, Date.parse(rootElt.elementTextTrim(name)));
                } else {
                    continue;
                }
            }
        }
        return JSONObject.parseObject(JSONObject.toJSONString(obj), pojo);
    }

    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshal = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshal.unmarshal(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    public static List<MWMS_QueryObj> convertXmlStrToObjectList(Class<?> clazz, String xmlStr) throws Exception {
        xmlStr = xmlStrFormat(xmlStr,"DATALIST");
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader strdata = new StringReader(xmlStr);
        StreamSource streamSource = new StreamSource(strdata);
        MWMS_QueryObj MWMSQueryObjList = (MWMS_QueryObj) unmarshaller.unmarshal(streamSource);
        return MWMSQueryObjList.getMWMSQueryObjList();
    }

}
