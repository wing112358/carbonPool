package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddDemandBean;
import org.carbonPool.Bean.CarbonPool.UpdatePriceBean;
import org.carbonPool.Utils.RandomUtil;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Assets;
import org.carbonPool.entity.Demand;
import org.carbonPool.entity.Transaction;
import org.carbonPool.entity.TransactionAssets;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class updatePriceTest extends BaseTest {


    public Header[] headers;

    public Long transactionId;

    public Long demandId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");
        this.transactionId=(Long)ctx.getAttribute("transactionId");
        this.demandId=(Long)ctx.getAttribute("demandId");

    }


    @Test(dataProvider = "addparam",description = "交易回填测试",groups = "updateprice")
    public void updatePriceTest(UpdatePriceBean updatePriceBean, String result) throws InterruptedException {

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.transactionWorkService.updatePrice(updatePriceBean, result, this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        //校验交易状态和金额
        Transaction transaction=this.transactionService.queryById(this.transactionId);
        Assert.assertEquals(transaction.getStatus().intValue(),1,"回填交易金额-状态校验不通过");

        Assert.assertEquals(transaction.getUnitPrice().toString(),updatePriceBean.getUnitPrice(),"回填交易金额-单价校验不通过");

        //校验需求

        Demand demand=this.demandService.queryById(this.demandId);
        Assert.assertEquals(demand.getStatus().intValue(),2,"需求分析确认-需求状态校验不通过");

        //资产
        List<TransactionAssets> transactionAssetslist=this.transactionAssetsService.queryByTransactionId(this.transactionId);
        List<Integer> temp=new ArrayList<>();
        temp.add(2);
        temp.add(3);

        for(TransactionAssets tr:transactionAssetslist){
            Assets temp1=this.assetsService.queryById(tr.getAssetsId());
            if(!temp.contains(temp1.getStatus())){
               System.out.println("项目"+temp1.getId()+"状态校验错误");
            }
        }






    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","updatePriceData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        UpdatePriceBean updatePriceBean=param.toJavaObject(UpdatePriceBean.class);

        updatePriceBean.setId(this.transactionId);



        return new Object[][]{{
            updatePriceBean,
            expectedresult
        },};

    }



}
