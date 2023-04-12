package boe.b4.appserver.modules.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("APP_UMS_LOGIN_LOG")
@ApiModel(value="AppUmsLoginLog对象", description="")
public class AppUmsLoginLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("USERID")
    private String userid;

    @TableField("CREATETIMEKEY")
    private String createtimekey;

    @TableField("CREATETIME")
    private Date createtime;

    @TableField("IP")
    private String ip;

    @TableField("ADDRESS")
    private String address;

    @TableField("USER_AGENT")
    private String userAgent;


}

