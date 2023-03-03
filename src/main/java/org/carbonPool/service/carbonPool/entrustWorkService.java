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
public class entrustWorkService extends BaseService {

    String ADD_ENTRUST_URL="/api/entrust/create";

    String EXAMINE_ENTRUST_URL="/api/entrust/audit";


    public JSONObject addentrust(AddEntrustBean addEntrustBean, String result, Header[] headers) throws Exception {


        //发送请求
        Response response=new HttprequestUtil().postJson(CreditBaseurl+ADD_ENTRUST_URL,addEntrustBean,null,headers);


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }

    public JSONObject examineEntrust(ExamineEntrustBean examineEntrustBean, String result, Header[] headers) throws Exception {


        //发送请求
        Response response=new HttprequestUtil().postJson(CreditBaseurl+EXAMINE_ENTRUST_URL,examineEntrustBean,null,headers);


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }




}
