package org.carbonPool.carbonPool;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.carbonPool.BaseLoginTest;
import org.carbonPool.BaseTest;
import org.carbonPool.Bean.CarbonPool.AddProjectBean;
import org.carbonPool.Utils.RandomUtil;
import org.carbonPool.Utils.TestngListener;
import org.carbonPool.Utils.YamlDataHelper;
import org.carbonPool.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;


@Slf4j
@Listeners({TestngListener.class})
public class addProjectTest extends BaseTest {


    public Header[] headers;


    public long projectId;

    @BeforeClass(alwaysRun = true)
    public void setHeader(){
        //获取header
        this.headers= new BaseLoginTest().loginnormaltest("17800000001","A147258");



    }

    @AfterGroups(groups = {"addproject"}, alwaysRun=true)
    public void setCompanyId(ITestContext ctx){
        ctx.setAttribute("projectId", this.projectId);
        ctx.setAttribute("businessHeaders",this.headers);
        log.info("请求放置的项目id："+this.projectId);
    }


    @Test(dataProvider = "addparam",description = "新增项目测试",groups = "addproject")
    public Long addProjectTest(AddProjectBean addProjectBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.projectWorkService.addproject(addProjectBean,result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //根据项目名称查询项目信息
        Project project =this.projectService.queryByName(addProjectBean.getName());

        //校验项目信息

        System.out.println("新增项目Id为："+project.getId());

        this.projectId=project.getId();

        return this.projectId;




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");


    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("CarbonPool","addprojectData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        AddProjectBean addProjectBean=param.toJavaObject(AddProjectBean.class);

        //随机生成项目名称
        Integer random=new RandomUtil().randomString(8);
        String projectname="Robot项目"+random;
        addProjectBean.setName(projectname);

        //随机生成装机容量
        Integer random1=new RandomUtil().randomString(3);
        String capacity=random1+"."+random1;
        addProjectBean.setCapacity(capacity);



        return new Object[][]{{
                addProjectBean,
            expectedresult
        },};

    }



}
