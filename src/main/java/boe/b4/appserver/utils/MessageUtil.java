package boe.b4.appserver.utils;

import boe.b4.appserver.utils.domain.ConnectionInfo;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.hibernate.internal.util.xml.XmlDocument;
import org.omg.IOP.Encoding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageUtil {

    private static String xmlElementMessage = "Message";
    private static String xmlElementMessageHeader = "Header";
    private static String xmlElementMessageBody = "Body";
    private static String xmlElementReturnCode = "RETURNCODE";
    private static String xmlElementReturnMessage = "RETURNMESSAGE";
    
    private static String xmlElementMessageName = "MESSAGENAME";
    private static String xmlElementFactoryName = "SHOPNAME";
    private static String xmlElementMachineName = "MACHINENAME";
    private static String xmlElementTransactionID = "TRANSACTIONID";
    private static String xmlElementSourceSubject = "SOURCESUBJECTNAME";
    private static String xmlElementTargetSubject = "TARGETSUBJECTNAME";
    private static String xmlElementEventUser = "EVENTUSER";
    private static String xmlElementEventComment = "EVENTCOMMENT";
    private static String xmlElementInputSet = "INPUTSET";
    private static String xmlElementLanguage = "LANGUAGE";

    public <T> String SendQueryMessage(String queryName, String queryVersion, T objPara, boolean requestFlag) {
        try
        {
            ConnectionInfo.MessageName = "GetQueryResult";
            DateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmssSSSSSS");
            ConnectionInfo.TransactionID = dateformat.format(new Date());

            //  QueryId, Version
            ConnectionInfo.QueryName = queryName;
            ConnectionInfo.QueryVersion = queryVersion;

            String sendMessage = this.CreateQueryMessage(objPara);

            if (requestFlag)
            {
                // Log.
                //UILogger.This.Log(UILogger.Query, true, queryName, sendMessage);
                //String replyMessage = WebMessageService.SendRequest(sendMessage);  //Webservice通信
                String replyMessage = MessageService.SendRequest(sendMessage);  //Tibco通信

                // Log.
                //UILogger.This.Log(UILogger.Query, false, queryName, replyMessage);

                // Raises a exception when the server can't reply properly or the response has problems we can't handle.
                if (replyMessage == null || replyMessage.length() < 0)
                {
                    throw new RuntimeException("The reply message that MES server has sent is empty.");
                }
                else
                {
                    return replyMessage;
                }
            }
        }
        catch (Exception messageex)
        {
            throw messageex;
        }
        finally
        {
            ConnectionInfo.EventComment = "";
        }

        return null;
    }

    private <T> String CreateQueryMessage(T objPara)
    {
        // 1、创建document对象
        Document document = DocumentHelper.createDocument();
        // 2、创建根节点root
        Element root = document.addElement("Message");
        Element header = root.addElement("Header");




        return null;
    }


}
