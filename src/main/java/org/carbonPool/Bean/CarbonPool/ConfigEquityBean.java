package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class ConfigEquityBean extends Request {

    /**
     *权益开始时间
     */
    private String equityStartTime;


    /**
     *项目id
     */
    private Long id;





}
