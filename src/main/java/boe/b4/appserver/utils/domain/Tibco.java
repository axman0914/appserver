package boe.b4.appserver.utils.domain;

public class Tibco {
    private String company;
    private String factory;
    private String cim;
    private String mode;
    private String svr;
    private String service;
    private String network;
    private String daemon;
    private String sendrequesttimeout;
    private String cmname;
    private String dataField_TAG;
    private String listenersubjectname;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSvr() {
        return svr;
    }

    public void setSvr(String svr) {
        this.svr = svr;
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

    public String getSendrequesttimeout() {
        return sendrequesttimeout;
    }

    public void setSendrequesttimeout(String sendrequesttimeout) {
        this.sendrequesttimeout = sendrequesttimeout;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public String getDataField_TAG() {
        return dataField_TAG;
    }

    public void setDataField_TAG(String dataField_TAG) {
        this.dataField_TAG = dataField_TAG;
    }

    public String getListenersubjectname() {
        return listenersubjectname;
    }

    public void setListenersubjectname(String listenersubjectname) {
        this.listenersubjectname = listenersubjectname;
    }

    @Override
    public String toString() {
        return "Tibco{" +
                "company='" + company + '\'' +
                ", factory='" + factory + '\'' +
                ", cim='" + cim + '\'' +
                ", mode='" + mode + '\'' +
                ", svr='" + svr + '\'' +
                ", service='" + service + '\'' +
                ", network='" + network + '\'' +
                ", daemon='" + daemon + '\'' +
                ", sendrequesttimeout='" + sendrequesttimeout + '\'' +
                ", cmname='" + cmname + '\'' +
                ", dataField_TAG='" + dataField_TAG + '\'' +
                ", listenersubjectname='" + listenersubjectname + '\'' +
                '}';
    }
}
