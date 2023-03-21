package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.*;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class configEquityTest extends BaseTest {


    public Header[] headers;
    public long projectId;

    public List<Long> equityList;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkid(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");

        this.projectId=(Long)ctx.getAttribute("projectId");



    }
    @AfterGroups(groups = {"configequity"}, alwaysRun=true)
    public void setEntrustId(ITestContext ctx){
        ctx.setAttribute("equityList", this.equityList);
        log.info("请求放置的权益id列表："+this.equityList);
    }


    @Test(dataProvider = "addparam",description = "配置权益测试",groups = "configequity",dependsOnGroups = {"examineentrust"})
    public List<Long> configEquityTest(ConfigEquityBean configEquityBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.equityWorkService.configEquity(configEquityBean,result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //校验权益记录
        Long counte=this.equityService.countByProjectId(this.projectId);

        Assert.assertNotEquals(counte,0,"权益插入不成功");

        //获取权益列表
        this.equityList=this.equityService.queryIdById(this.projectId);

        return this.equityList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","configequityData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        ConfigEquityBean configEquityBean=param.toJavaObject(ConfigEquityBean.class);

        //放置项目id
        configEquityBean.setId(this.projectId);



        return new Object[][]{{
            configEquityBean,
            expectedresult
        },};

    }



}
