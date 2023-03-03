package org.carbonPool.service;

import org.carbonPool.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 交易表(Transaction)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:09:30
 */
public interface TransactionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Transaction queryById(Long id);

    Transaction queryByDemandId(Long demandId);

    /**
     * 分页查询
     *
     * @param transaction 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Transaction> queryByPage(Transaction transaction, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param transaction 实例对象
     * @return 实例对象
     */
    Transaction insert(Transaction transaction);

    /**
     * 修改数据
     *
     * @param transaction 实例对象
     * @return 实例对象
     */
    Transaction update(Transaction transaction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
