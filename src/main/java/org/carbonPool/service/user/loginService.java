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


    public JSONObject login(LoginBean loginBean, String result) throws Exception {

        Header[] headers={};

        return this.baseMethod(loginBean,result,headers,LOGIN_URL);
    }

    public JSONObject loginByParam(String account,String code, String result) throws Exception {


        Header[] headers={};
        BaseService base=new BaseService();

        //写入请求参数
        LoginBean loginBean=new LoginBean(account,code);


        return this.baseMethod(loginBean,result,headers,LOGIN_URL);
    }
}
