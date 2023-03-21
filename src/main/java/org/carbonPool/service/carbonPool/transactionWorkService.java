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


        return this.baseMethod(addDemandBean,result,headers,flag,ADD_DEMAND_URL);
    }

    public JSONObject analysisdemand(AnalysisDemandBean analysisDemandBean, String result, Header[] headers,Integer flag) throws Exception {


        return this.baseMethod(analysisDemandBean,result,headers,flag,ANALYSIS_DEMAND_URL);
    }

    public JSONObject confirmdemand(ConfirmDemandBean confirmDemandBean, String result, Header[] headers,Integer flag) throws Exception {


        return this.baseMethod(confirmDemandBean,result,headers,flag,CONFIRM_DEMAND_URL);
    }

    public JSONObject updatePrice(UpdatePriceBean updatePriceBean, String result, Header[] headers,Integer flag) throws Exception {


        return this.baseMethod(updatePriceBean,result,headers,flag,UPDATE_PRICE_URL);
    }





}
