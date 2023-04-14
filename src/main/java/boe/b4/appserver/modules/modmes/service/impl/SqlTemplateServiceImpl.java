package boe.b4.appserver.modules.modmes.service.impl;

import com.cim.idm.framework.orm.SqlTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SqlTemplateServiceImpl {

    private static SqlTemplate jdbcTemplate = getSqlTemplateService();

    public static SqlTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void setJdbcTemplate(SqlTemplate jdbcTemplate) {
        SqlTemplateServiceImpl.jdbcTemplate = jdbcTemplate;
    }

    private static SqlTemplate getSqlTemplateService(){

        ApplicationContext ac = new FileSystemXmlApplicationContext("config/modmesconfig.xml");

        SqlTemplate jdbcTemplate = (SqlTemplate) ac.getBean("SqlTemplate");

        return jdbcTemplate;

    }
}
