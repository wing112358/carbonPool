package org.carbonPool.Utils;

import java.util.Random;

public class RandomUtil {

    public Integer randomString(int N){
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
//随机生成数字，并添加到字符串
        for(int i=0;i<N;i++){
            str.append(random.nextInt(10));
        }
//将字符串转换为数字并输出
        Integer num=Integer.parseInt(str.toString());
        return num;
    }

    public static void main(String[] args) throws Exception {
        Integer num=new RandomUtil().randomString(8);
        System.out.println(num);
    }

}
