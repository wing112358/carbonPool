package org.carbonPool.service.carbonPool;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.carbonPool.Bean.CarbonPool.AddProjectBean;
import org.carbonPool.Bean.common.Response;
import org.carbonPool.Utils.HttprequestUtil;
import org.carbonPool.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 项目新增接口调用
 */

@Service
public class projectWorkService extends BaseService {

    String ADD_PROJECT_URL="/api/project/create";


    public JSONObject addproject(AddProjectBean addProjectBean, String result, Header[] headers) throws Exception {

        return this.baseMethod(addProjectBean,result,headers,ADD_PROJECT_URL);
    }


}
