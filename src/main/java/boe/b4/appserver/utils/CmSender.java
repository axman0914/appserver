package boe.b4.appserver.utils;

import boe.b4.appserver.modules.common.model.AppConfigTibco;
import boe.b4.appserver.modules.common.model.query.MWMS_QueryObj;
import boe.b4.appserver.modules.common.service.impl.TibQueryServiceImpl;
import boe.b4.appserver.utils.domain.Message;
import com.tibco.tibrv.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
//@Scope(value = "prototype")
//public class CmSender implements ApplicationContextAware {
public class CmSender{

    private static Logger log = Logger.getLogger(CmSender.class);

    private String listenerSubjectName = "";
    private String service = "";
    private String network = "";
    //private String daemon = "10.90.248.100:7500";
    private String daemon = "";
    private String cmName = "";


    private int sendRequestTimeout = 20;
    private TibrvRvdTransport rvdTransport = null;
    private TibrvCmTransport cmTransport = null;
    private String dataField_TAG="xmlData";

    Object lockSeqno = new Object();
    TibrvDispatcher disp=null;

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private TibcoUtils tibcoUtils;


    public CmSender() {

    }

    @PostConstruct
    private void initialize() {
        try {
            Tibrv.open(Tibrv.IMPL_NATIVE);
            rvdTransport = new TibrvRvdTransport(service, network, daemon);
            cmTransport = new TibrvCmTransport(rvdTransport, cmName, true);
            disp = new TibrvDispatcher(Tibrv.defaultQueue());
        } catch (TibrvException e) {
            e.printStackTrace();
        }
    }

    public Message sendRequest(String source, AppConfigTibco tibco) throws Exception{
        try {
            Tibrv.open(Tibrv.IMPL_NATIVE);
            //TibrvRvdTransport rvdTransport = new TibrvRvdTransport(tibco.getService(), tibco.getNetwork(), tibco.getDaemon());;
            //TibrvCmTransport cmTransport = new TibrvCmTransport(rvdTransport, tibco.getCmname(), true);
            TibrvCmTransport cmTransport = tibcoUtils.getCNMtibrvCmTransportMap(tibco.getTibName());
            String returnString="";
            String returnMsg = "";
            TibrvMsg replyMsg=null;
            TibrvMsgField tibrvMsgField=null;
            Message message = new Message();
            TibrvMsg msg = new TibrvMsg();
            TibrvMsg.setStringEncoding("utf-8");
            msg.setSendSubject(tibco.getListenersubjectname());
            TibrvCmMsg.setTimeLimit(msg, 5.0);
            msg.add(tibco.getDatafieldTag(), source);
            System.out.println(tibco.getSendrequesttimeout());
            synchronized (lockSeqno) {
                // Send message into the queue
                replyMsg = cmTransport.sendRequest( msg,tibco.getSendrequesttimeout());
            }
            if(replyMsg!=null){
                tibrvMsgField = replyMsg.getField(tibco.getDatafieldTag());
            }
            if(tibrvMsgField!=null){
                returnString=tibrvMsgField.data.toString();
            }
            message = XMLUtils.CheckErrorMessage(returnString);
            return message;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            //Tibrv.close();
        }

    }

    public List<MWMS_QueryObj> sendQRYRequest(String source, AppConfigTibco tibco) throws Exception{
        try {
            Tibrv.open(Tibrv.IMPL_NATIVE);
            //TibrvRvdTransport rvdTransport = new TibrvRvdTransport(tibco.getService(), tibco.getNetwork(), tibco.getDaemon());;
            //TibrvCmTransport cmTransport = new TibrvCmTransport(rvdTransport, tibco.getCmname(), true);
            TibrvCmTransport cmTransport = tibcoUtils.getQRYtibrvCmTransportMap(tibco.getTibName());
            String returnString="";
            String returnMsg = "";
            TibrvMsg replyMsg=null;
            TibrvMsgField tibrvMsgField=null;
            List<MWMS_QueryObj> message = new ArrayList<MWMS_QueryObj>();
            TibrvMsg msg = new TibrvMsg();
            TibrvMsg.setStringEncoding("utf-8");
            msg.setSendSubject(tibco.getListenersubjectname());
            TibrvCmMsg.setTimeLimit(msg, 5.0);
            msg.add(tibco.getDatafieldTag(), source);
            System.out.println(tibco.getSendrequesttimeout());
            synchronized (lockSeqno) {
                // Send message into the queue
                replyMsg = cmTransport.sendRequest( msg,tibco.getSendrequesttimeout());
            }
            if(replyMsg!=null){
                tibrvMsgField = replyMsg.getField(tibco.getDatafieldTag());
            }
            if(tibrvMsgField!=null){
                returnString=tibrvMsgField.data.toString();
                log.info(returnString);
            }
            Class<?> aClass = Class.forName("boe.b4.appserver.modules.common.model.query."+tibco.getTibName()+"_QueryObj");
            List<MWMS_QueryObj> o = XMLUtils.convertXmlStrToObjectList(aClass, returnString);
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            //Tibrv.close();
        }

    }

    public String getListenerSubjectName() {
        return listenerSubjectName;
    }

    public void setListenerSubjectName(String listenerSubjectName) {
        this.listenerSubjectName = listenerSubjectName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDaemon() {
        return daemon;
    }

    public void setDaemon(String daemon) {
        this.daemon = daemon;
    }

    public int getSendRequestTimeout() {
        return sendRequestTimeout;
    }

    public void setSendRequestTimeout(int sendRequestTimeout) {
        this.sendRequestTimeout = sendRequestTimeout;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public TibrvCmTransport getCmTransport() {
        return cmTransport;
    }

    public void setCmTransport(TibrvCmTransport cmTransport) {
        this.cmTransport = cmTransport;
    }

    public String getDataField_TAG() {
        return dataField_TAG;
    }

    public void setDataField_TAG(String dataField_TAG) {
        this.dataField_TAG = dataField_TAG;
    }



}

