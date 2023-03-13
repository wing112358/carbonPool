package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.ExamineEntrustBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Entrust;
import org.carbonPool.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;



@Slf4j
@Listeners({TestngListener.class})
public class examineEntrustTest extends BaseTest {


    public Header[] headers;

    public long entrustId;

    public long projectId;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkid(ITestContext ctx){
        //获取header
        this.headers= new BaseLoginTest().loginnormaltest("18100000001","A147258");

        this.entrustId=(Long)ctx.getAttribute("entrustId");

        this.projectId=(Long)ctx.getAttribute("projectId");



    }

    @AfterGroups(groups = {"examineentrust"}, alwaysRun=true)
    public void setEntrustId(ITestContext ctx){
        ctx.setAttribute("entrustId", this.entrustId);
        ctx.setAttribute("serverHeaders",this.headers);
        log.info("请求放置的委托id："+this.entrustId);
    }




    @Test(dataProvider = "addparam",description = "项目委托通过测试",groups = "examineentrust")
    public Long examineEntrustTest(ExamineEntrustBean examineEntrustBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.entrustWorkService.examineEntrust(examineEntrustBean,result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //校验委托记录
        Entrust entrust =this.entrustService.queryById(this.entrustId);

        System.out.println("委托记录状态为："+entrust.getStatus());

        Assert.assertEquals((int)entrust.getStatus(),2,"委托审核-委托记录校验不通过");

        //校验项目状态变更
        Project project=this.projectService.queryById(this.projectId);
        System.out.println("项目委托状态为："+project.getEntrustStatus());

        Assert.assertEquals((int)project.getEntrustStatus(),2,"托审核-项目委托状态校验不通过");


        return this.entrustId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","examineentrustData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        ExamineEntrustBean examineEntrustBean=param.toJavaObject(ExamineEntrustBean.class);

        //放置委托id
        examineEntrustBean.setId(this.entrustId);



        return new Object[][]{{
                examineEntrustBean,
            expectedresult
        },};

    }



}
