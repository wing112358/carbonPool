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
public class transactionWorkService extends BaseService {

    String ADD_DEMAND_URL="/api/demand/create";

    String ANALYSIS_DEMAND_URL="/api/demand/analysis";

    String CONFIRM_DEMAND_URL="/api/demand/confirm";

    String UPDATE_PRICE_URL="/api/transaction/updateUnitPrice";


    public JSONObject adddemand(AddDemandBean addDemandBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){
            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+ADD_DEMAND_URL,addDemandBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+ADD_DEMAND_URL,addDemandBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }

    public JSONObject analysisdemand(AnalysisDemandBean analysisDemandBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+ANALYSIS_DEMAND_URL,analysisDemandBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+ANALYSIS_DEMAND_URL,analysisDemandBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }

    public JSONObject confirmdemand(ConfirmDemandBean confirmDemandBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+CONFIRM_DEMAND_URL,confirmDemandBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+CONFIRM_DEMAND_URL,confirmDemandBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }

    public JSONObject updatePrice(UpdatePriceBean updatePriceBean, String result, Header[] headers,Integer flag) throws Exception {


        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(flag==1){
            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+UPDATE_PRICE_URL,updatePriceBean,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+UPDATE_PRICE_URL,updatePriceBean,null,headers);
        }


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName,flag));

        return jsonresult;
    }





}
