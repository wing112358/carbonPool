package org.carbonPool.service;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import org.carbonPool.Bean.common.Environment;
import org.carbonPool.Bean.common.Request;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.testng.Assert;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * 服务基类
 */

@Configuration
public class BaseService {

    /**
     *设置环境方法
     */

    public String setUrl( String servicename){

        String BASEURL=new EnvironmentUtil().getUrl(Environment.Test,servicename);
//        String BASEURL="http://web.corp-sit.lvtanlian.com";
        return BASEURL;
    }

    public String getValue( String key){

        ResourceBundle bundle = ResourceBundle.getBundle("application");
        String value=bundle.getString(key);

        return value;
    }
    /**
     *获取请求基础域名
     */
    public String Baseurl=this.setUrl("carbonPool");


    public String PRIVATEKEY=getValue("PRIVATEKEY");


    public String PUBLICKEY=getValue("PUBLICKEY");







    /**
     * 校验返回
     * @param response
     * @param result
     * @param methodName
     * @return
     */
    public JSONObject  assertMsgAndData(Response response, String result, String methodName,Integer flag) {

        Integer code=response.getStatusCode();

        JSONObject resultcontent=new JSONObject();

        if(flag==1){
            String decresult=AESUtil.decrypt(response.getResponseContent().replace("\"",""),PRIVATEKEY);
            resultcontent= JsonUtil.jsonstring2Jsonobject(decresult);
        }else{
            resultcontent= JsonUtil.jsonstring2Jsonobject(response.getResponseContent());
        }



        if(code.equals(200)) {
            if (resultcontent.get("status").equals(200)) {
                Assert.assertEquals(JsonUtil.getString(resultcontent, "message"), result);
            } else {
                Assert.fail(methodName+"接口调用失败，响应为:" + resultcontent);
            }
        }else{
            //失败则打印失败状态码
            Assert.fail(methodName+"接口调用失败，响应为:" + response.getStatusCode());
        }


        return resultcontent;


    }

    public static void main(String[] args) throws Exception {
//        LoginBean loginBean=new LoginBean("13111111111","8888");
//        String body=new BaseService().aesbody(loginBean);
//        System.out.println(body);
    }

}
