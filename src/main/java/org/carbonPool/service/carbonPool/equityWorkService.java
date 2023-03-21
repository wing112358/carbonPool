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


        return this.baseMethod(equityBean,result,headers,flag,CONFIG_EQUITY_URL);
    }

    public JSONObject updateEquity(UpdateEquityBean updateEquityBean, String result, Header[] headers,Integer flag) throws Exception {


        return this.baseMethod(updateEquityBean,result,headers,flag,UPDATE_EQUITY_URL);
    }


}
