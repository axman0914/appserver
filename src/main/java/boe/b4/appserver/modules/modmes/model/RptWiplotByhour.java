package boe.b4.appserver.modules.modmes.model;

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
 * @author HanLei
 * @since 2023-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("RPT_WIPLOT_BYHOUR")
@ApiModel(value="RptWiplotByhour对象", description="")
public class RptWiplotByhour implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("FACTORYNAME")
    private String factoryname;

    @TableField("FACTORYDATE")
    private String factorydate;

    @TableField("FACTORYSHIFT")
    private String factoryshift;

    @TableField("FACTORYHOUR")
    private String factoryhour;

    @TableField("LOTNAME")
    private String lotname;

    @TableField("PRODUCTIONTYPE")
    private String productiontype;

    @TableField("PRODUCTSPECNAME")
    private String productspecname;

    @TableField("PRODUCTREQUESTNAME")
    private String productrequestname;

    @TableField("PROCESSGROUPNAME")
    private String processgroupname;

    @TableField("CARRIERNAME")
    private String carriername;

    @TableField("PRODUCTTYPE")
    private String producttype;

    @TableField("LOTTYPE")
    private String lottype;

    @TableField("PANELTYPE")
    private String paneltype;

    @TableField("SUBPRODUCTTYPE")
    private String subproducttype;

    @TableField("SUBPRODUCTUNITQUANTITY1")
    private BigDecimal subproductunitquantity1;

    @TableField("SUBPRODUCTUNITQUANTITY2")
    private BigDecimal subproductunitquantity2;

    @TableField("PRODUCTQUANTITY")
    private BigDecimal productquantity;

    @TableField("SUBPRODUCTQUANTITY")
    private BigDecimal subproductquantity;

    @TableField("LOTGRADE")
    private String lotgrade;

    @TableField("DUEDATE")
    private Date duedate;

    @TableField("PRIORITY")
    private BigDecimal priority;

    @TableField("DESTINATIONFACTORYNAME")
    private String destinationfactoryname;

    @TableField("AREANAME")
    private String areaname;

    @TableField("LOTSTATE")
    private String lotstate;

    @TableField("LOTPROCESSSTATE")
    private String lotprocessstate;

    @TableField("LOTHOLDSTATE")
    private String lotholdstate;

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

    @TableField("LASTEVENTFLAG")
    private String lasteventflag;

    @TableField("CREATETIME")
    private Date createtime;

    @TableField("CREATEUSER")
    private String createuser;

    @TableField("RELEASETIME")
    private Date releasetime;

    @TableField("RELEASEUSER")
    private String releaseuser;

    @TableField("REASONCODETYPE")
    private String reasoncodetype;

    @TableField("REASONCODE")
    private String reasoncode;

    @TableField("PROCESSFLOWNAME")
    private String processflowname;

    @TableField("PROCESSOPERATIONNAME")
    private String processoperationname;

    @TableField("MACHINENAME")
    private String machinename;

    @TableField("MACHINERECIPENAME")
    private String machinerecipename;

    @TableField("REWORKSTATE")
    private String reworkstate;

    @TableField("REWORKCOUNT")
    private BigDecimal reworkcount;

    @TableField("REWORKNODEID")
    private String reworknodeid;

    @TableField("CHECKINCODE")
    private String checkincode;

    @TableField("REVISIONCODE")
    private String revisioncode;

    @TableField("MODULENAME")
    private String modulename;

    @TableField("OQALOTNAME")
    private String oqalotname;

    @TableField("LINENAME")
    private String linename;

    @TableField("RECEIVETYPE")
    private String receivetype;

    @TableField("RECEIVEFROM")
    private String receivefrom;

    @TableField("ETCSTATE")
    private String etcstate;

    @TableField("ETCLOCATION")
    private String etclocation;

    @TableField("ETCRETURNMODE")
    private String etcreturnmode;

    @TableField("CELLLOTNAME")
    private String celllotname;

    @TableField("PRODUCTCODE")
    private String productcode;

    @TableField("OQAJUDGE")
    private String oqajudge;

    @TableField("DEFECTSIZE")
    private String defectsize;

    @TableField("ARRIVETIME")
    private Date arrivetime;

    @TableField("GROUPNAME")
    private String groupname;

    @TableField("UPDATETIME")
    private Date updatetime;

    @TableField("MODULESTARTFLAG")
    private String modulestartflag;

    @TableField("STOCKTOFGMS")
    private String stocktofgms;

    @TableField("CT_FACTORYNAME")
    private String ctFactoryname;


}
