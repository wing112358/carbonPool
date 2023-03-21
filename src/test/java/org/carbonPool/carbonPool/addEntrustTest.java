package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddEntrustBean;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Entrust;
import org.carbonPool.entity.EntrustData;
import org.carbonPool.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Listeners({TestngListener.class})
public class addEntrustTest extends BaseTest {


    public Header[] headers;

    public long projectId;

    public long entrustId;

    @BeforeClass(alwaysRun = true)
    public void setHeaderAndProjectid(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("businessHeaders");

        this.projectId=(Long)ctx.getAttribute("projectId");


    }

    @AfterGroups(groups = {"addentrust"}, alwaysRun=true)
    public void setCompanyId(ITestContext ctx){
        ctx.setAttribute("entrustId", this.entrustId);
        log.info("请求放置的项目id："+this.entrustId);
    }




    @Test(dataProvider = "addparam",description = "项目委托测试",groups = "addentrust" ,dependsOnGroups = {"addproject"})
    public Long addEntrustTest(AddEntrustBean addEntrustBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.entrustWorkService.addentrust(addEntrustBean,result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //根据项目id查询委托记录
        EntrustData entrustdata =this.entrustDataService.queryByDataId(this.projectId);

        //校验委托信息
        System.out.println("新增委托Id为："+entrustdata.getEntrustId());

        this.entrustId=entrustdata.getEntrustId();

        Entrust entrust=this.entrustService.queryById(this.entrustId);

        Assert.assertEquals(entrust.getStatus().intValue(),1,"新增委托-委托状态校验不通过");
        Project project=this.projectService.queryById(this.projectId);

        Assert.assertEquals(project.getEntrustStatus().intValue(),1,"新增委托-项目委托状态校验不通过");

        return this.entrustId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","addentrustData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        AddEntrustBean addEntrustBean=param.toJavaObject(AddEntrustBean.class);

        //放置项目id
        List<Long> datalist=new ArrayList<>();

        datalist.add(this.projectId);

        addEntrustBean.setDataIdList(datalist);



        return new Object[][]{{
            addEntrustBean,
            expectedresult
        },};

    }



}
