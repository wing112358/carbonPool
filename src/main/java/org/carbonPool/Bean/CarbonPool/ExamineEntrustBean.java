package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class ExamineEntrustBean extends Request {

    /**
     *委托记录id
     */
    private Long id;


    /**
     *审核状态
     */
    private String status;


    /**
     *委托类型
     */
    private Integer type;






}
