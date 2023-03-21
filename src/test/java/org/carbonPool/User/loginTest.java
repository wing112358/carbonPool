package org.carbonPool.User;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.User.LoginBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class loginTest extends BaseTest {


    @Test(dataProvider = "addparam",description = "登录测试")
    public Header[] logintest(LoginBean loginBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.loginservice.login(loginBean,result,this.signFlag);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取
        String token=response.getString("data");

        log.info("此处为返回的data:"+ token);
        String Authorization = token;
        log.info("token:"+Authorization);
        Header[] headers = {new BasicHeader("Authorization", Authorization)};
        return headers;
    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("User","loginData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        LoginBean loginBean=param.toJavaObject(LoginBean.class);



        return new Object[][]{{
            loginBean,
            expectedresult
        },};

    }



}
