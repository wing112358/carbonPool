package org.carbonPool.service;

import org.carbonPool.entity.TransactionAssets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 交易资产关联表(TransactionAssets)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:09:38
 */
public interface TransactionAssetsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TransactionAssets queryById(Long id);

    /**
     * 分页查询
     *
     * @param transactionAssets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TransactionAssets> queryByPage(TransactionAssets transactionAssets, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param transactionAssets 实例对象
     * @return 实例对象
     */
    TransactionAssets insert(TransactionAssets transactionAssets);

    /**
     * 修改数据
     *
     * @param transactionAssets 实例对象
     * @return 实例对象
     */
    TransactionAssets update(TransactionAssets transactionAssets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
