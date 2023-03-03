package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddDemandBean;
import org.carbonPool.Bean.CarbonPool.AnalysisDemandBean;
import org.carbonPool.Utils.RandomUtil;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Demand;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class analysisDemandTest extends BaseTest {


    public Header[] headers;

    public Long demandId;

    public List<Long> assetList;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");
        this.demandId=(Long)ctx.getAttribute("demandId");

    }

    @AfterGroups(groups = {"analysisdemand"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("assetList", this.assetList);
        log.info("请求放置的资产id列表："+this.assetList);
    }




    @Test(dataProvider = "addparam",description = "分析需求测试",groups = "analysisdemand")
    public List<Long> analysisDemandTest(AnalysisDemandBean analysisDemandBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.transactionWorkService.analysisdemand(analysisDemandBean, result, this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Long> temp=new ArrayList<>();
        //获取返回的资产id
       JSONArray data=response.getJSONArray("data");
        for(int i =0;i<data.size();i++){
            Long assetId=(Long)data.getJSONObject(i).getLongValue("id");
            temp.add(assetId);
        }

        this.assetList=temp;

        return this.assetList;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","analysisdemandData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        Long temp=this.demandId;

        AnalysisDemandBean analysisDemandBean=new AnalysisDemandBean(temp);



        return new Object[][]{{
            analysisDemandBean,
            expectedresult
        },};

    }



}
