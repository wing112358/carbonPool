package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AnalysisDemandBean;
import org.carbonPool.Bean.CarbonPool.ConfirmDemandBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Transaction;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class confirmDemandTest extends BaseTest {


    public Header[] headers;

    public Long demandId;

    public List<Long> assetList;

    public Long transactionId;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");
        this.demandId=(Long)ctx.getAttribute("demandId");
        this.assetList=(List<Long>)ctx.getAttribute("assetList");

    }

    @AfterGroups(groups = {"confirmdemand"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("transactionId", this.transactionId);
        log.info("请求放置的交易："+this.transactionId);
    }




    @Test(dataProvider = "addparam",description = "确认需求测试",groups = "confirmdemand")
    public Long confirmDemandTest(ConfirmDemandBean confirmDemandBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.transactionWorkService.confirmdemand(confirmDemandBean, result, this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //根据需求Id获取交易Id
        Transaction transaction=this.transactionService.queryByDemandId(this.demandId);
        this.transactionId=transaction.getId();



        return this.transactionId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","confirmdemandData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        ConfirmDemandBean confirmDemandBean=new ConfirmDemandBean(this.assetList,this.demandId);







        return new Object[][]{{
            confirmDemandBean,
            expectedresult
        },};

    }



}
