package org.carbonPool.service;

import org.carbonPool.entity.TransactionPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 交易价格表(TransactionPrice)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:09:45
 */
public interface TransactionPriceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TransactionPrice queryById(Long id);

    /**
     * 分页查询
     *
     * @param transactionPrice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TransactionPrice> queryByPage(TransactionPrice transactionPrice, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param transactionPrice 实例对象
     * @return 实例对象
     */
    TransactionPrice insert(TransactionPrice transactionPrice);

    /**
     * 修改数据
     *
     * @param transactionPrice 实例对象
     * @return 实例对象
     */
    TransactionPrice update(TransactionPrice transactionPrice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
