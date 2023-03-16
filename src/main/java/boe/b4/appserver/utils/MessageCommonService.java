package boe.b4.appserver.utils;

public class MessageCommonService {

    MessageUtil msgUtil = new MessageUtil();

    public <T> T GetQueryInfo(T objPara, String queryid, String version){
        String replyMessage = msgUtil.SendQueryMessage(queryid, version, objPara, true);
        return objPara;
    }
}
