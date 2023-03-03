package org.carbonPool.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;

/**
 * 读取yaml文件方法类
 */
public class YamlDataHelper {

    /**
     * 根据文件名获取对应数据
     */

    public JSONObject getYamlDataByFilename(String packagename,String filename){
        JSONObject jsonObject=new JSONObject();

        String filepath= MessageFormat.format("./src/test/java/org/carbonpool/Data/{0}/{1}.yaml",packagename,filename);


        try{
            File file=new File(filepath);
            Yaml yaml = new Yaml();
            jsonObject=(JSONObject)JSON.toJSON(yaml.load(new FileInputStream(file)));


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        return jsonObject;

    }


    /**
     * 根据文件名以及属性获取对应数据
     */
    public JSONObject getYamlDataByCase(String packagename,String filename,String casename){
        JSONObject jsonObject=new JSONObject();
        JSONObject resultjson=new JSONObject();

        String filepath= MessageFormat.format("./src/test/java/org/carbonpool/Data/{0}/{1}.yaml",packagename,filename);


        try{
            File file=new File(filepath);
            Yaml yaml = new Yaml();
            jsonObject=(JSONObject)JSON.toJSON(yaml.load(new FileInputStream(file)));
            resultjson=jsonObject.getJSONObject(casename);


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        return resultjson;

    }






}
