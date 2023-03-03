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


        //发送请求
        Response response=new HttprequestUtil().postJson(CreditBaseurl+ADD_PROJECT_URL,addProjectBean,null,headers);


        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }


}
