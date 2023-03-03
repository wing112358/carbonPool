package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class AddAssetBean extends Request {

    /**
     *所属时间段
     */
    private List<String> equity;


    /**
     *权益列表
     */
    private List<Long> equityIds;


    /**
     *权益数量类型
     */
    private List<String> equityQuantityTypeList;


    /**
     *项目ID
     */
    private Long projectId;


    /**
     *资产总数
     */
    private String totalQuantity;

    /**
     *资产类型
     */
    private String type;

    /**
     *结束时间
     */
    private String timeEnd;

    /**
     *开始时间
     */
    private String timeStart;



}
