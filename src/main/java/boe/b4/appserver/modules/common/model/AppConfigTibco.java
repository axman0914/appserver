package boe.b4.appserver.modules.common.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @author B4CIM
 * @since 2023-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("APP_CONFIG_TIBCO")
@ApiModel(value="AppConfigTibco对象", description="")
public class AppConfigTibco implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("LISTENERSUBJECTNAME")
    private String listenersubjectname;

    @TableField("SERVICE")
    private String service;

    @TableField("NETWORK")
    private String network;

    @TableField("DAEMON")
    private String daemon;

    @TableField("CMNAME")
    private String cmname;

    @TableField("DATAFIELD_TAG")
    private String datafieldTag;

    @TableField("SENDREQUESTTIMEOUT")
    private Integer sendrequesttimeout;

    @TableField("TIB_MODE")
    private String tibMode;

    @TableField("TIB_NAME")
    private String tibName;

    @TableField("TIB_SVR")
    private String tibSvr;


}
