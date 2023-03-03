package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class AddProjectBean extends Request {

    /**
     *消纳人户号
     */
    private String absorptionAccount;


    /**
     *消纳方式
     */
    private List<String> absorptionTypeList;


    /**
     *项目区县
     */
    private String addressArea;


    /**
     *项目城市
     */
    private String addressCity;


    /**
     *项目详细地址
     */
    private String addressNum;


    /**
     *项目所在省
     */
    private String addressProvince;


    /**
     *项目所在街道
     */
    private String addressStreet;


    /**
     *装机容量
     */
    private String capacity;


    /**
     *投运时间
     */
    private String deliveryDate;


    /**
     *是否纳入绿电交易
     */
    private String greenTransaction;


    /**
     *并网电压
     */
    private String gridConnectedVoltageType;


    /**
     *项目持有人
     */
    private String holderName;


    /**
     *项目名称
     */
    private String name;


    /**
     *发电客户号
     */
    private String powerAccount;


    /**
     *电网运营方
     */
    private String powerGridOperatorName;


    /**
     *项目地址
     */
    private List<String> projectAddress;


    /**
     *自消纳类型
     */
    private String selfAbsorptionType;


    /**
     *现场消纳人
     */
    private String siteAbsorptionName;


    /**
     *技术类型
     */
    private String technologyType;


    /**
     *项目类型
     */
    private String type;
}
