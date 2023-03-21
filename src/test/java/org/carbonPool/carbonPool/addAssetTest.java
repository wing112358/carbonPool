package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddAssetBean;
import org.carbonPool.Bean.CarbonPool.AddEntrustBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Assets;
import org.carbonPool.entity.EntrustData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class addAssetTest extends BaseTest {


    public Header[] headers;

    public Long projectId;

    public List<Long> baseEquityList;

    public Long assetId;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndProjectid(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("serverHeaders");

        this.baseEquityList=(List<Long>)ctx.getAttribute("baseEquityList");
        this.projectId=(Long)ctx.getAttribute("projectId");


    }

    @AfterGroups(groups = {"addasset"}, alwaysRun=true)
    public void setCompanyId(ITestContext ctx){
        ctx.setAttribute("assetId", this.assetId);
        log.info("请求放置的资产id："+this.assetId);
    }




    @Test(dataProvider = "addparam",description = "新增资产测试",groups = "addasset",dependsOnGroups = {"updateequity"})
    public Long addAssetTest(AddAssetBean addAssetBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.assetWorkService.addasset(addAssetBean, result, this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //根据项目id以及所属时间段查询资产id
        Assets assets =this.assetsService.queryByProjectId(this.projectId,"2022-05-01 00:00:00","2022-07-01 00:00:00");

        System.out.println("新增资产Id为："+assets.getId());
        this.assetId=assets.getId();

        Assert.assertEquals((int)assets.getStatus(),0,"新增资产-状态校验不通过");


        return this.assetId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","addassetData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        AddAssetBean addAssetBean=param.toJavaObject(AddAssetBean.class);

        //放置项目id以及权益id
        addAssetBean.setProjectId(this.projectId);
        addAssetBean.setEquityIds(this.baseEquityList);



        return new Object[][]{{
            addAssetBean,
            expectedresult
        },};

    }



}
