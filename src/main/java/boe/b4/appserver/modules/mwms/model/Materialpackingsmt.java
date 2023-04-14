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
 * @since 2023-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("MATERIALPACKINGSMT")
@ApiModel(value="Materialpackingsmt对象", description="")
public class Materialpackingsmt implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("SITENAME")
    private String sitename;

    @TableField("MATERIALPACKINGNAME")
    private String materialpackingname;

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

    @TableField("PACKINGGRADE")
    private String packinggrade;

    @TableField("SUBPACKINGQUANTITY")
    private BigDecimal subpackingquantity;

    @TableField("MATERIALCREATEQUANTITY")
    private BigDecimal materialcreatequantity;

    @TableField("MATERIALQUANTITY")
    private BigDecimal materialquantity;

    @TableField("PACKINGSTATE")
    private String packingstate;

    @TableField("OLDPACKINGSTATE")
    private String oldpackingstate;

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

    @TableField("LASTEVENTNAME")
    private String lasteventname;

    @TableField("LASTEVENTTIMEKEY")
    private String lasteventtimekey;

    @TableField("LASTEVENTTIME")
    private Date lasteventtime;

    @TableField("LASTEVENTUSER")
    private String lasteventuser;

    @TableField("LASTEVENTCOMMENT")
    private String lasteventcomment;

    @TableField("CREATETIME")
    private Date createtime;

    @TableField("CREATEUSER")
    private String createuser;

    @TableField("RECEIVEREQUESTNAME")
    private String receiverequestname;

    @TableField("RECEIVEREQUESTDETAILNAME")
    private String receiverequestdetailname;

    @TableField("MAKEDATE")
    private Date makedate;

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

    @TableField("REASONCODETYPE")
    private String reasoncodetype;

    @TableField("REASONCODE")
    private String reasoncode;

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

    @TableField("CHARGE")
    private String charge;

    @TableField("SUPPLIERNAME")
    private String suppliername;

    @TableField("UNDOID")
    private String undoid;

    @TableField("UNDODETAILNAME")
    private String undodetailname;

    @TableField("ERPEVENTTIME")
    private Date erpeventtime;

    @TableField("NPFLAG")
    private String npflag;

    @TableField("MESSAGEID")
    private String messageid;

    @TableField("ERPSTATE")
    private String erpstate;

    @TableField("SAVEREASON")
    private String savereason;

    @TableField("ENDDATE")
    private Date enddate;

    @TableField("SMTEVENTTIME")
    private String smteventtime;

    @TableField("TRANSACTIONID")
    private String transactionid;

    @TableField("LOTNO")
    private String lotno;

    @TableField("BOESITENAME")
    private String boesitename;


}
