package org.carbonPool.service.carbonPool;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.carbonPool.Bean.CarbonPool.AddAssetBean;
import org.carbonPool.Bean.CarbonPool.AddEntrustBean;
import org.carbonPool.Bean.CarbonPool.ExamineEntrustBean;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.HttprequestUtil;
import org.carbonPool.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 项目新增接口调用
 */

@Service
public class assetWorkService extends BaseService {

    String ADD_ASSET_URL="/api/assets/create";


    public JSONObject addasset(AddAssetBean assetBean, String result, Header[] headers,Integer flag) throws Exception {

        return this.baseMethod(assetBean,result,headers,flag,ADD_ASSET_URL);
    }





}
