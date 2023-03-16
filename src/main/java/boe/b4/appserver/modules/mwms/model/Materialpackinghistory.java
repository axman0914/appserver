package boe.b4.appserver.modules.mwms.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author XuShu
 * @since 2023-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("MATERIALPACKINGHISTORY")
@ApiModel(value="Materialpackinghistory对象", description="")
public class Materialpackinghistory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SITENAME")
    private String sitename;

    @TableField("MATERIALPACKINGNAME")
    private String materialpackingname;

    @TableId("TIMEKEY")
    private String timekey;

    @TableField("REASONCODETYPE")
    private String reasoncodetype;

    @TableField("REASONCODE")
    private String reasoncode;

    @TableField("MATERIALPACKINGTYPE")
    private String materialpackingtype;

    @TableField("CONTENTMATERIALTYPE")
    private String contentmaterialtype;

    @TableField("MATERIALTYPE")
    private String materialtype;

    @TableField("MATERIALSPECNAME")
    private String materialspecname;

    @TableField("SUPERMATERIALPACKINGNAME")
    private String supermaterialpackingname;

    @TableField("MAKEDATE")
    private Date makedate;

    @TableField("PACKINGGRADE")
    private String packinggrade;

    @TableField("SUBPACKINGQUANTITY")
    private BigDecimal subpackingquantity;

    @TableField("MATERIALCREATEQUANTITY")
    private BigDecimal materialcreatequantity;

    @TableField("MATERIALQUANTITY")
    private BigDecimal materialquantity;

    @TableField("OLDPACKINGSTATE")
    private String oldpackingstate;

    @TableField("PACKINGSTATE")
    private String packingstate;

    @TableField("STOCKSTATE")
    private String stockstate;

    @TableField("OLDSTOCKSTATE")
    private String oldstockstate;

    @TableField("HOLDSTATE")
    private String holdstate;

    @TableField("AREANAME")
    private String areaname;

    @TableField("LOCATIONNAME")
    private String locationname;

    @TableField("DURABLENAME")
    private String durablename;

    @TableField("MATERIALPROCESSGROUPNAME")
    private String materialprocessgroupname;

    @TableField("CREATETIME")
    private Date createtime;

    @TableField("CREATEUSER")
    private String createuser;

    @TableField("RECEIVEREQUESTNAME")
    private String receiverequestname;

    @TableField("RECEIVEREQUESTDETAILNAME")
    private String receiverequestdetailname;

    @TableField("RECEIVEACTNO")
    private String receiveactno;

    @TableField("RECEIVETIME")
    private Date receivetime;

    @TableField("RECEIVEUSER")
    private String receiveuser;

    @TableField("SHIPREQUESTNAME")
    private String shiprequestname;

    @TableField("SHIPREQUESTDETAILNAME")
    private String shiprequestdetailname;

    @TableField("SHIPTIME")
    private Date shiptime;

    @TableField("SHIPUSER")
    private String shipuser;

    @TableField("ERPLOCATION")
    private String erplocation;

    @TableField("ETCSTATE")
    private String etcstate;

    @TableField("ERPFACTORY")
    private String erpfactory;

    @TableField("STOCKINTYPE")
    private String stockintype;

    @TableField("OQARESULTSTATE")
    private String oqaresultstate;

    @TableField("OQARESULT")
    private String oqaresult;

    @TableField("UNDOID")
    private String undoid;

    @TableField("SUPPLIERNAME")
    private String suppliername;

    @TableField("CHARGE")
    private String charge;

    @TableField("UNDODETAILNAME")
    private String undodetailname;

    @TableField("ERPEVENTTIME")
    private Date erpeventtime;

    @TableField("EVENTNAME")
    private String eventname;

    @TableField("EVENTTIME")
    private Date eventtime;

    @TableField("EVENTUSER")
    private String eventuser;

    @TableField("EVENTCOMMENT")
    private String eventcomment;

    @TableField("NPFLAG")
    private String npflag;

    @TableField("ERPSTATE")
    private String erpstate;

    @TableField("MESSAGEID")
    private String messageid;

    @TableField("REMARK")
    private String remark;

    @TableField("PROCESSSTATE")
    private String processstate;

    @TableField("OQAMETHOD")
    private String oqamethod;

    @TableField("IMPROVMENTFLAG")
    private String improvmentflag;

    @TableField("EXPIRINGDATE")
    private Date expiringdate;

    @TableField("ETCOUTQUANTITY")
    private BigDecimal etcoutquantity;

    @TableField("MESRECEIVEFLAG")
    private String mesreceiveflag;

    @TableField("MESRECEIVETIME")
    private Date mesreceivetime;

    @TableField("RECEIPTOR")
    private String receiptor;


}
