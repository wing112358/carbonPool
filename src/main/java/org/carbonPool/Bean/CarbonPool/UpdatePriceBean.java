package org.carbonPool.Bean.CarbonPool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Data
public class UpdatePriceBean extends Request {

    /**
     *资产单价
     */
    private String unitPrice;

    /**
     *交易id
     */
    private Long id;






}
