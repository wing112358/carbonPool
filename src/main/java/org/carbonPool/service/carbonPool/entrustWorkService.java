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

        return this.baseMethod(addEntrustBean,result,headers,ADD_ENTRUST_URL);
    }

    public JSONObject examineEntrust(ExamineEntrustBean examineEntrustBean, String result, Header[] headers) throws Exception {


        return this.baseMethod(examineEntrustBean,result,headers,EXAMINE_ENTRUST_URL);
    }




}
