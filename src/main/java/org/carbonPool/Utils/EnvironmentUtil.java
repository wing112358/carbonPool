package org.carbonPool.Utils;

import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Environment;

import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * 获取配置不同环境域名
 */
@Slf4j
public class EnvironmentUtil {

    public String getUrl(Environment envir, String service){
        String baseurl="";
        ResourceBundle bundle = ResourceBundle.getBundle("application");

        switch(envir)
        {
            case Dev :
                String devurlkey= MessageFormat.format("{0}_dev", service);
                baseurl =bundle.getString(devurlkey);
                log.info("开发环境域名："+ baseurl);
                break;
            case Test :
                String testurlkey= MessageFormat.format("{0}_test", service);
                baseurl =bundle.getString(testurlkey);;
                log.info("测试环境域名："+ baseurl);
                break;
            case Pre :
                String preurlkey= MessageFormat.format("{}_pre", service);
                baseurl =bundle.getString(preurlkey);
                log.info("预发环境域名："+ baseurl);
                break;
            case Production :
                String productionurlkey= MessageFormat.format("{0}_production", service);
                baseurl =bundle.getString(productionurlkey);
                log.info("生产环境域名："+ baseurl);
                break;
            default :
                log.info("未知环境");
        }

        return baseurl;
    }

}
