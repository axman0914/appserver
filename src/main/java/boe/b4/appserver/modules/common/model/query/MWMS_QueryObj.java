package boe.b4.appserver.modules.common.model.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DATALIST")
public class MWMS_QueryObj {

    @XmlElement(name = "DATA")
    private List<MWMS_QueryObj> MWMSQueryObjList;

    @NotEmpty
    @ApiModelProperty(value = "queryId",required = true)
    private String queryId;

    @NotEmpty
    @ApiModelProperty(value = "version",required = true)
    private String version;

    @NotEmpty
    @ApiModelProperty(value = "shopName",required = true)
    private String shopName;

    private String sitename;

    @XmlElement(name = "MATERIALSPECNAME")
    private String materialspecname;

    private String starttime;

    private String endtime;

    private String eventtime;

    @XmlElement(name = "ERPFACTORY")
    private String erpfactory;

    @XmlElement(name = "ERPLOCATION")
    private String erplocation;

    private String charge;

    private String receiverequestname;

    private String receiveactno;

    @XmlElement(name = "MATERIALPACKINGNAME")
    private String materialpackingname;

    @XmlElement(name = "STOCKSTATE")
    private String stockstate;

    @XmlElement(name = "MATERIALQUANTITY")
    private String materialquantity;

}
