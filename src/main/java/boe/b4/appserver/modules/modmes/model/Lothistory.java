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
@TableName("LOTHISTORY")
@ApiModel(value="Lothistory对象", description="")
public class Lothistory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("LOTNAME")
    private String lotname;

    @TableField("TIMEKEY")
    private String timekey;

    @TableField("EVENTTIME")
    private Date eventtime;

    @TableField("EVENTNAME")
    private String eventname;

    @TableField("OLDPRODUCTIONTYPE")
    private String oldproductiontype;

    @TableField("PRODUCTIONTYPE")
    private String productiontype;

    @TableField("OLDPRODUCTSPECNAME")
    private String oldproductspecname;

    @TableField("PRODUCTSPECNAME")
    private String productspecname;

    @TableField("OLDPRODUCTSPECVERSION")
    private String oldproductspecversion;

    @TableField("PRODUCTSPECVERSION")
    private String productspecversion;

    @TableField("OLDPRODUCTSPEC2NAME")
    private String oldproductspec2name;

    @TableField("PRODUCTSPEC2NAME")
    private String productspec2name;

    @TableField("OLDPRODUCTSPEC2VERSION")
    private String oldproductspec2version;

    @TableField("PRODUCTSPEC2VERSION")
    private String productspec2version;

    @TableField("PROCESSGROUPNAME")
    private String processgroupname;

    @TableField("PRODUCTREQUESTNAME")
    private String productrequestname;

    @TableField("ORIGINALLOTNAME")
    private String originallotname;

    @TableField("SOURCELOTNAME")
    private String sourcelotname;

    @TableField("DESTINATIONLOTNAME")
    private String destinationlotname;

    @TableField("ROOTLOTNAME")
    private String rootlotname;

    @TableField("PARENTLOTNAME")
    private String parentlotname;

    @TableField("CARRIERNAME")
    private String carriername;

    @TableField("OLDPRODUCTTYPE")
    private String oldproducttype;

    @TableField("PRODUCTTYPE")
    private String producttype;

    @TableField("OLDSUBPRODUCTTYPE")
    private String oldsubproducttype;

    @TableField("SUBPRODUCTTYPE")
    private String subproducttype;

    @TableField("SUBPRODUCTUNITQUANTITY1")
    private BigDecimal subproductunitquantity1;

    @TableField("SUBPRODUCTUNITQUANTITY2")
    private BigDecimal subproductunitquantity2;

    @TableField("OLDPRODUCTQUANTITY")
    private BigDecimal oldproductquantity;

    @TableField("PRODUCTQUANTITY")
    private BigDecimal productquantity;

    @TableField("OLDSUBPRODUCTQUANTITY")
    private BigDecimal oldsubproductquantity;

    @TableField("SUBPRODUCTQUANTITY")
    private BigDecimal subproductquantity;

    @TableField("OLDSUBPRODUCTQUANTITY1")
    private BigDecimal oldsubproductquantity1;

    @TableField("SUBPRODUCTQUANTITY1")
    private BigDecimal subproductquantity1;

    @TableField("OLDSUBPRODUCTQUANTITY2")
    private BigDecimal oldsubproductquantity2;

    @TableField("SUBPRODUCTQUANTITY2")
    private BigDecimal subproductquantity2;

    @TableField("LOTGRADE")
    private String lotgrade;

    @TableField("DUEDATE")
    private Date duedate;

    @TableField("PRIORITY")
    private BigDecimal priority;

    @TableField("OLDFACTORYNAME")
    private String oldfactoryname;

    @TableField("FACTORYNAME")
    private String factoryname;

    @TableField("OLDDESTINATIONFACTORYNAME")
    private String olddestinationfactoryname;

    @TableField("DESTINATIONFACTORYNAME")
    private String destinationfactoryname;

    @TableField("OLDAREANAME")
    private String oldareaname;

    @TableField("AREANAME")
    private String areaname;

    @TableField("LOTSTATE")
    private String lotstate;

    @TableField("LOTPROCESSSTATE")
    private String lotprocessstate;

    @TableField("LOTHOLDSTATE")
    private String lotholdstate;

    @TableField("EVENTUSER")
    private String eventuser;

    @TableField("EVENTCOMMENT")
    private String eventcomment;

    @TableField("EVENTFLAG")
    private String eventflag;

    @TableField("LASTLOGGEDINTIME")
    private Date lastloggedintime;

    @TableField("LASTLOGGEDINUSER")
    private String lastloggedinuser;

    @TableField("LASTLOGGEDOUTTIME")
    private Date lastloggedouttime;

    @TableField("LASTLOGGEDOUTUSER")
    private String lastloggedoutuser;

    @TableField("REASONCODETYPE")
    private String reasoncodetype;

    @TableField("REASONCODE")
    private String reasoncode;

    @TableField("OLDPROCESSFLOWNAME")
    private String oldprocessflowname;

    @TableField("PROCESSFLOWNAME")
    private String processflowname;

    @TableField("OLDPROCESSFLOWVERSION")
    private String oldprocessflowversion;

    @TableField("PROCESSFLOWVERSION")
    private String processflowversion;

    @TableField("OLDPROCESSOPERATIONNAME")
    private String oldprocessoperationname;

    @TableField("PROCESSOPERATIONNAME")
    private String processoperationname;

    @TableField("OLDPROCESSOPERATIONVERSION")
    private String oldprocessoperationversion;

    @TableField("PROCESSOPERATIONVERSION")
    private String processoperationversion;

    @TableField("NODESTACK")
    private String nodestack;

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

    @TableField("BRANCHENDNODEID")
    private String branchendnodeid;

    @TableField("CONSUMERLOTNAME")
    private String consumerlotname;

    @TableField("CONSUMERTIMEKEY")
    private String consumertimekey;

    @TableField("CONSUMEDLOTNAME")
    private String consumedlotname;

    @TableField("CONSUMEDDURABLENAME")
    private String consumeddurablename;

    @TableField("CONSUMEDCONSUMABLENAME")
    private String consumedconsumablename;

    @TableField("SYSTEMTIME")
    private Date systemtime;

    @TableField("CANCELFLAG")
    private String cancelflag;

    @TableField("CANCELTIMEKEY")
    private String canceltimekey;

    @TableField("GROUPNAME")
    private String groupname;

    @TableField("CHECKINCODE")
    private String checkincode;

    @TableField("REVISIONCODE")
    private String revisioncode;

    @TableField("MODULENAME")
    private String modulename;

    @TableField("OQALOTNAME")
    private String oqalotname;

    @TableField("OQAINSPECTRESULT")
    private String oqainspectresult;

    @TableField("STOCKINTIME")
    private Date stockintime;

    @TableField("STOCKINUSER")
    private String stockinuser;

    @TableField("INVOICENO")
    private String invoiceno;

    @TableField("SHIPTIME")
    private Date shiptime;

    @TableField("SHIPUSER")
    private String shipuser;

    @TableField("LEVELNO")
    private String levelno;

    @TableField("AGINGPALLETNAME")
    private String agingpalletname;

    @TableField("FALABELPRINTCOUNT")
    private BigDecimal falabelprintcount;

    @TableField("RECEIVETYPE")
    private String receivetype;

    @TableField("FAREASONCODE")
    private String fareasoncode;

    @TableField("FAREASONCODESIZE")
    private String fareasoncodesize;

    @TableField("FALEVEL")
    private String falevel;

    @TableField("FAREASONCODETYPE")
    private String fareasoncodetype;

    @TableField("LINENAME")
    private String linename;

    @TableField("ADDRESS")
    private String address;

    @TableField("ADDRESSPOINT")
    private String addresspoint;

    @TableField("OQADEFECTSIZEWIDTH")
    private String oqadefectsizewidth;

    @TableField("OQADEFECTSIZELENGTH")
    private String oqadefectsizelength;

    @TableField("OQADEFECTDIAMETER")
    private String oqadefectdiameter;

    @TableField("REASONCODESIZE")
    private String reasoncodesize;

    @TableField("FAADDRESS")
    private String faaddress;

    @TableField("FAADDRESSPOINT")
    private String faaddresspoint;

    @TableField("OQADEFECTDOTQUANTITY")
    private String oqadefectdotquantity;

    @TableField("FAENGINEERNAME")
    private String faengineername;

    @TableField("FATIME")
    private Date fatime;

    @TableField("FAINSPECTRESULT")
    private String fainspectresult;

    @TableField("INVOICEDETAILNO")
    private String invoicedetailno;

    @TableField("OLDMODULENAME")
    private String oldmodulename;

    @TableField("ETCSTATE")
    private String etcstate;

    @TableField("ETCLOCATION")
    private String etclocation;

    @TableField("ETCRETURNMODE")
    private String etcreturnmode;

    @TableField("OQARESULT")
    private String oqaresult;

    @TableField("WBLOTGRADE")
    private String wblotgrade;

    @TableField("CELLGRADE")
    private String cellgrade;

    @TableField("ASSYGRADE")
    private String assygrade;

    @TableField("PSJUDGE")
    private String psjudge;

    @TableField("CFJUDGE")
    private String cfjudge;

    @TableField("ARRAYGRADE")
    private String arraygrade;

    @TableField("LOTPOSITION")
    private String lotposition;

    @TableField("CELLMACHINENAME")
    private String cellmachinename;

    @TableField("PPID")
    private String ppid;

    @TableField("SUBPRODUCTDETAILGRADES1")
    private String subproductdetailgrades1;

    @TableField("ORIGINALPRODUCTIONTYPE")
    private String originalproductiontype;

    @TableField("RMANUMBER")
    private String rmanumber;

    @TableField("FAILUREMODE")
    private String failuremode;

    @TableField("VERIFYRESULT")
    private String verifyresult;

    @TableField("RMAMODULENAME")
    private String rmamodulename;

    @TableField("CELLSHIPTIME")
    private String cellshiptime;

    @TableField("REWORKSTARTSTEP")
    private String reworkstartstep;

    @TableField("CELLLOTNAME")
    private String celllotname;

    @TableField("RECEIVEFROM")
    private String receivefrom;

    @TableField("PRODUCTCODE")
    private String productcode;

    @TableField("POL_TFT")
    private String polTft;

    @TableField("POL_CF")
    private String polCf;

    @TableField("ACFT")
    private String acft;

    @TableField("COFS")
    private String cofs;

    @TableField("COFG")
    private String cofg;

    @TableField("PCB_LEFT")
    private String pcbLeft;

    @TableField("PCB_RIGHT")
    private String pcbRight;

    @TableField("ACF")
    private String acf;

    @TableField("PCB_LEFT_MMT")
    private String pcbLeftMmt;

    @TableField("PCB_RIGHT_MMT")
    private String pcbRightMmt;

    @TableField("ACF_MMT")
    private String acfMmt;

    @TableField("BL")
    private String bl;

    @TableField("CONTROL_BOARD")
    private String controlBoard;

    @TableField("OQAJUDGE")
    private String oqajudge;

    @TableField("DEFECTSIZE")
    private String defectsize;

    @TableField("LOTTYPE")
    private String lottype;

    @TableField("MODULESTARTFLAG")
    private String modulestartflag;

    @TableField("LOTDETAILGRADE")
    private String lotdetailgrade;

    @TableField("OPERATORCOMMENT")
    private String operatorcomment;

    @TableField("ARRAYREPAIR")
    private String arrayrepair;

    @TableField("ARRAYSHIPGRADE")
    private String arrayshipgrade;

    @TableField("CELLREPAIR")
    private String cellrepair;

    @TableField("CELLSHIPGRADE")
    private String cellshipgrade;

    @TableField("OLDLOTGRADE")
    private String oldlotgrade;

    @TableField("POSITION")
    private String position;

    @TableField("AP01_ACF1")
    private String ap01Acf1;

    @TableField("AP01_COF1")
    private String ap01Cof1;

    @TableField("AP01_ACF2")
    private String ap01Acf2;

    @TableField("AP01_COF2")
    private String ap01Cof2;

    @TableField("AP02_ACF1")
    private String ap02Acf1;

    @TableField("AP02_COF1")
    private String ap02Cof1;

    @TableField("AP02_ACF2")
    private String ap02Acf2;

    @TableField("AP02_COF2")
    private String ap02Cof2;

    @TableField("PB01_PCBL")
    private String pb01Pcbl;

    @TableField("PB01_PCBR")
    private String pb01Pcbr;

    @TableField("PB01_ACFL1")
    private String pb01Acfl1;

    @TableField("PB01_ACFL2")
    private String pb01Acfl2;

    @TableField("PB01_ACFR1")
    private String pb01Acfr1;

    @TableField("PB01_ACFR2")
    private String pb01Acfr2;

    @TableField("PI01_PCBL")
    private String pi01Pcbl;

    @TableField("PI01_PCBR")
    private String pi01Pcbr;

    @TableField("CONSUMABLE_SEQ")
    private String consumableSeq;

    @TableField("PANELTYPE")
    private String paneltype;

    @TableField("TV_PRODUCTID")
    private String tvProductid;

    @TableField("TV_BOX_MODELCODE")
    private String tvBoxModelcode;

    @TableField("TVSET_SAMPLINGFLAG")
    private String tvsetSamplingflag;

    @TableField("AD_BOARD")
    private String adBoard;

    @TableField("POWER_BOARD")
    private String powerBoard;

    @TableField("OPERATORID")
    private String operatorid;

    @TableField("INSPECTEDOQASTEP")
    private String inspectedoqastep;

    @TableField("STOCKTOFGMS")
    private String stocktofgms;

    @TableField("OCRTOQAJUDGE")
    private String ocrtoqajudge;

    @TableField("FAORDER")
    private String faorder;

    @TableField("PAIRLOTNAME")
    private String pairlotname;

    @TableField("CT_FACTORYNAME")
    private String ctFactoryname;

    @TableField("OLDPRODUCTREQUESTNAME")
    private String oldproductrequestname;

    @TableField("RISKTYPE")
    private String risktype;


}
