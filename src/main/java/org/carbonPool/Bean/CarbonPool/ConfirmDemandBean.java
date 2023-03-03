package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class ConfirmDemandBean extends Request {

    /**
     *资产id列表
     */
    private List<Long> assetsIds;

    /**
     *需求id
     */
    private Long demandId;






}
