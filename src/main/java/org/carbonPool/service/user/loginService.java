package org.carbonPool.service.user;


import com.alibaba.fastjson.JSONObject;
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


        //发送请求
        Response response=new HttprequestUtil().postJson(CreditBaseurl+LOGIN_URL,loginBean,null,null);


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }

    public JSONObject loginByParam(String account,String code, String result) throws Exception {

        BaseService base=new BaseService();

        //写入请求参数
        LoginBean loginBean=new LoginBean(account,code);


        //发送请求
        Response response=new HttprequestUtil().postJson(CreditBaseurl+LOGIN_URL,loginBean,null,null);


        //校验返回
        JSONObject jsonresult=assertMsgAndData(response,result,Thread.currentThread().getStackTrace()[1].getMethodName());

        return jsonresult;
    }
}
