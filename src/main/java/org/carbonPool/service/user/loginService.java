package org.carbonPool.service.user;


import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.Headers;
import org.apache.http.Header;
import org.carbonPool.Bean.User.LoginBean;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.HttprequestUtil;
import org.carbonPool.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 登录接口调用
 */

@Service
public class loginService extends BaseService {

    String LOGIN_URL="/api/uaa/user/login";


    public JSONObject login(LoginBean loginBean, String result,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);
        Header[] headers= {};

        if(flag==1){
            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+LOGIN_URL,loginBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+LOGIN_URL,loginBean,null,null);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }

    public JSONObject loginByParam(String account,String code, String result,Integer flag) throws Exception {


        BaseService base=new BaseService();

        //写入请求参数
        LoginBean loginBean=new LoginBean(account,code);


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);
        Header[] headers={};
        if(flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+LOGIN_URL,loginBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+LOGIN_URL,loginBean,null,null);
        }


        //校验返回
        JSONObject jsonresult=assertMsgAndData(response,result,Thread.currentThread().getStackTrace()[1].getMethodName(),flag);

        return jsonresult;
    }
}
