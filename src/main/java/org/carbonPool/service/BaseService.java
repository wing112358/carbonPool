package org.carbonPool.service;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import org.carbonPool.Bean.common.Environment;
import org.carbonPool.Bean.common.Request;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.*;
import org.testng.Assert;

import java.util.Date;
import java.util.TreeMap;

/**
 * 服务基类
 */
public class BaseService {

    /**
     *设置环境方法
     */

    public String setUrl( String servicename){

        String BASEURL=new EnvironmentUtil().getUrl(Environment.Test,servicename);
//        String BASEURL="http://web.corp-sit.lvtanlian.com";
        return BASEURL;
    }
    /**
     *获取请求基础域名
     */
    public String CreditBaseurl=this.setUrl("corboncredit");

    public String PRIVATEKEY="VuL0fSCfWeQzl7yUcYasqhOLlO80M365";

    public String PUBLICKEY="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMbFUgBEsev1lURtNFgfr0jtz4IDJ6MEyIkA2WMG57bPfSsT4Pei7bxsXUCyMTXQbaxV0SThX802gxrpTEBAbJsCAwEAAQ==";


    /**
     * 处理Header
     */

    public Header[]  encryptheader(Request request) throws Exception {

        String body=aesbody(request);

        String X_TIMESTAMP=String.valueOf(new Date().getTime());
        String X_NONCE=X_TIMESTAMP;
        byte [] bytekey  =  PRIVATEKEY.getBytes("UTF-8");;
        byte[] rsakey= RSAUtil.encrypt(bytekey,PUBLICKEY);
        String X_EAK= Base64Util.encode(rsakey);
        TreeMap<String, String> params = new TreeMap<>();
        params.put("timestamp", X_TIMESTAMP);
        params.put("nonce", X_NONCE);
        params.put("aesKey", PRIVATEKEY);
//        params.put("id", "99");
        params.put("body", body);
        String X_SIGN = SignUtil.sign(params);

        Header[] headers={

                new BasicHeader("X_TIMESTAMP", X_TIMESTAMP)

                ,new BasicHeader("X_NONCE", X_NONCE)

                ,new BasicHeader("X_EAK", X_EAK)

                ,new BasicHeader("X_SIGN", X_SIGN)
        };

        return headers;

    }

    /**
     * 处理请求加密
     */

    public String aesbody(Request request)  throws Exception {
        String aesresult="";

        String body=new ObjectMapper().writeValueAsString(request);

        aesresult= AESUtil.encrypt(body,PRIVATEKEY);

        return aesresult;

    }

    /**
     * 校验返回
     * @param response
     * @param result
     * @param methodName
     * @return
     */
    public JSONObject  assertMsgAndData(Response response, String result, String methodName) {

        Integer code=response.getStatusCode();

//        String decresult=AESUtil.decrypt(response.getResponseContent().replace("\"",""),PRIVATEKEY);

        JSONObject resultcontent= JsonUtil.jsonstring2Jsonobject(response.getResponseContent());

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
