package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class AddEntrustBean extends Request {

    /**
     *委托内容
     */
    private List<Long> dataIdList;


    /**
     *被委托方
     */
    private Integer entrustCustomerId;


    /**
     *委托期限
     */
    private String limitTime;


    /**
     *项目类型
     */
    private String projectType;


    /**
     *委托类型
     */
    private Integer type;



}
