package boe.b4.appserver.utils.domain;

import lombok.Data;

@Data
public class XMLHeader {
    private String message;
    private String shopname;
    private String machinename;
    private String trasactionid;
    private String originalsourcesubjectname;
    private String sourcesubjectname;
    private String targetsubjectname;
    private String eventuser;
    private String eventcomment;
    private String inputset;
    private String language;
}
