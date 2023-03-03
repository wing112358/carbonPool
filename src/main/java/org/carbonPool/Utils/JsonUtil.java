package org.carbonPool.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


/**
 * JSon相关格式转换工具类
 */
@Slf4j
public class JsonUtil {

    /**
     * 转换
     * @param object
     * @return
     */

    public static JSONObject object2Jsonobject(Object object){
        JSONObject result=(JSONObject) JSONObject.toJSON(object);
        log.info("转换结果:"+result);
        return result ;
    }

    public static String object2Jsonstring(Object object){
        String result=JSONObject.toJSONString(object);
        log.info("转换结果:"+result);
        return result;
    }

    public static String jsonobject2Jsonstring(JSONObject jsonObject){
        String result=JSONObject.toJSONString(jsonObject);
        log.info("转换结果:"+result);
        return result;
    }


    public static JSONObject jsonstring2Jsonobject(String  text){
        JSONObject result= JSONObject.parseObject(text);
        log.info("转换结果:"+result);
        return result;
    }

    public  static JSONObject map2Jsonobject(Map<String, Object>  map){
        JSONObject result= JSONObject.parseObject(JSON.toJSONString(map));
        log.info("转换结果:"+result);
        return result;
    }

    public  static Map<String, Object> jsonobject2map(JSONObject  jsonObject){
        Map<String, Object> result= JSONObject.toJavaObject(jsonObject, Map.class);
        log.info("转换结果:"+result);
        return result;
    }

    public static <T> JSONArray list2Jsonarry(List<T> list){
        JSONArray result= JSONArray.parseArray(JSON.toJSONString(list));
        log.info("转换结果:"+result);
        return result;
    }

    public static  List<String> Jsonarry2stringlist(JSONArray  jsonArray){
        String js=JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<String> result= JSONObject.parseArray(js,String.class);
        log.info("转换结果:"+result);
        return result;
    }

    public static List<Integer> Jsonarry2intlist(JSONArray  jsonArray){
        String js=JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Integer> result= JSONObject.parseArray(js,Integer.class);
        log.info("转换结果:"+result);
        return result;
    }

    /**
     * 取值
     */
    public static String getString(JSONObject json, String key) {
        if (json == null)
            return null;
        if (json.get(key) == null)
            return null;

        else
            return json.get(key).toString();
    }







}
