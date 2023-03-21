package org.carbonPool.carbonPool;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.ConfirmDemandBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.*;
import org.testng.Assert;
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




    @Test(dataProvider = "addparam",description = "确认需求测试",groups = "confirmdemand",dependsOnGroups = {"adddemand"})
    public Long confirmDemandTest(ConfirmDemandBean confirmDemandBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.transactionWorkService.confirmdemand(confirmDemandBean, result, this.headers,this.signFlag);
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

        //校验交易
        Assert.assertEquals(transaction.getStatus().intValue(),0,"需求分析确认-交易状态校验不通过");

        //校验需求

        Demand demand=this.demandService.queryById(this.demandId);
        Assert.assertEquals(demand.getQuantity(),transaction.getQuantity(),"需求分析确认-需求与交易数量不一致");
        Assert.assertEquals(demand.getStatus().intValue(),1,"需求分析确认-需求状态校验不通过");

        List<TransactionAssets> transactionAssetslist=this.transactionAssetsService.queryByTransactionId(this.transactionId);

        for(TransactionAssets tr:transactionAssetslist){
            Assets temp1=this.assetsService.queryById(tr.getAssetsId());
            Assert.assertEquals(temp1.getFrozenQuantity(),tr.getAssetsQuantity(),"需求分析确认-资产冻结数量核对不通过");

        }

        //资产
        for(Long id :this.assetList){
            Assets temp=this.assetsService.queryById(id);
            Assert.assertEquals(temp.getStatus().intValue(),1,"需求分析确认-资产状态校验不通过");
        }




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
