package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class UpdateEquityBean extends Request {

    /**
     *权益数量
     */
    private String quantity;


    /**
     *权益id
     */
    private Long id;





}
