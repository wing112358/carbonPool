package org.carbonPool.service.carbonPool;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.carbonPool.Bean.CarbonPool.*;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.HttprequestUtil;
import org.carbonPool.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 项目新增接口调用
 */

@Service
public class equityWorkService extends BaseService {

    String CONFIG_EQUITY_URL="/api/project/configEquity";

    String UPDATE_EQUITY_URL="/api/equity/update";


    public JSONObject configEquity(ConfigEquityBean equityBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+CONFIG_EQUITY_URL,equityBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+CONFIG_EQUITY_URL,equityBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }

    public JSONObject updateEquity(UpdateEquityBean updateEquityBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){
            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+UPDATE_EQUITY_URL,updateEquityBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+UPDATE_EQUITY_URL,updateEquityBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }


}
