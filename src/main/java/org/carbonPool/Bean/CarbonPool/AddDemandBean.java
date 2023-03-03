package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class AddDemandBean extends Request {

    /**
     *时间段
     */
    private List<String> time;

    /**
     *资产类型
     */
    private String assetsType;


    /**
     *截止时间
     */
    private String closeTime;

    /**
     *买家名称
     */
    private String customerName;
    /**
     *能源类型
     */
    private String energyType;

    /**
     *需求数量
     */
    private String quantity;

    /**
     *结束时间
     */
    private String timeEnd;

    /**
     *开始时间
     */
    private String timeStart;



}
