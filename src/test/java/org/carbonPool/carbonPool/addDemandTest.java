package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddAssetBean;
import org.carbonPool.Bean.CarbonPool.AddDemandBean;
import org.carbonPool.Utils.RandomUtil;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Assets;
import org.carbonPool.entity.Demand;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class addDemandTest extends BaseTest {


    public Header[] headers;

    public Long demandId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndProjectid(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");

    }

    @AfterGroups(groups = {"adddemand"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("demandId", this.demandId);
        log.info("请求放置的需求id："+this.demandId);
    }




    @Test(dataProvider = "addparam",description = "新增需求测试",groups = "adddemand",dependsOnGroups = {"addasset"})
    public Long addDemandTest(AddDemandBean addDemandBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.transactionWorkService.adddemand(addDemandBean, result, this.headers,this.signFlag);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //根据条件查询需求ID
        Demand demand=this.demandService.queryByDate(21,"2022-04-01 00:00:00","2022-09-01 00:00:00",addDemandBean.getAssetsType(),addDemandBean.getEnergyType(),addDemandBean.getCustomerName());

        this.demandId=demand.getId();

        return this.demandId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","adddemandData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        AddDemandBean addDemandBean=param.toJavaObject(AddDemandBean.class);

        //自动生成买家名称
        Integer random=new RandomUtil().randomString(8);
        String customername="Robot买家"+random;
        addDemandBean.setCustomerName(customername);




        return new Object[][]{{
            addDemandBean,
            expectedresult
        },};

    }



}
