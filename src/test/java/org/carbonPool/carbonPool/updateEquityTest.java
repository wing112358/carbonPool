package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.ConfigEquityBean;
import org.carbonPool.Bean.CarbonPool.UpdateEquityBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Equity;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class updateEquityTest extends BaseTest {


    public Header[] headers;

    public List<Long> equityList;

    public Long projectId;

    public List<Long> baseEquityList;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkid(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");

        this.equityList=(List<Long>)ctx.getAttribute("equityList");

        this.projectId=(Long)ctx.getAttribute("projectId");


    }
    @AfterGroups(groups = {"updateequity"}, alwaysRun=true)
    public void setEntrustId(ITestContext ctx){
        ctx.setAttribute("baseEquityList", this.baseEquityList);
        log.info("已更新的权益id列表："+this.baseEquityList);
    }


    @Test(dataProvider = "addparam",description = "更新权益测试",groups = "updateequity")
    public List<Long> updateEquityTest(UpdateEquityBean updateEquityBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");

            //获取时间最早的3条权益
            this.baseEquityList=this.equityService.queryIdByLimit(this.projectId,3);

            //循环更新3条权益
            for(int i=0;i<3;i++){
                updateEquityBean.setId(baseEquityList.get(i));
                response=this.equityWorkService.updateEquity(updateEquityBean,result,this.headers);
            }
            response=this.equityWorkService.updateEquity(updateEquityBean,result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //校验权益记录
        for(int j=0;j<3;j++){
            Equity equity=this.equityService.queryById(baseEquityList.get(j));
            Assert.assertEquals( equity.getStatus().intValue(),1,"更新权益-状态校验不通过");
        }



        return this.baseEquityList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","updateequityData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        UpdateEquityBean updateEquityBean=param.toJavaObject(UpdateEquityBean.class);



        return new Object[][]{{
            updateEquityBean,
            expectedresult
        },};

    }



}
