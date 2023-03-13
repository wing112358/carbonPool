package org.carbonPool.service.impl;

import org.carbonPool.entity.TransactionAssets;
import org.carbonPool.dao.TransactionAssetsDao;
import org.carbonPool.service.TransactionAssetsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易资产关联表(TransactionAssets)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:09:38
 */
@Service("transactionAssetsService")
public class TransactionAssetsServiceImpl implements TransactionAssetsService {
    @Resource
    private TransactionAssetsDao transactionAssetsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TransactionAssets queryById(Long id) {
        return this.transactionAssetsDao.queryById(id);
    }

    /**
     * 通过交易ID查询多条数据
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    @Override
    public List<TransactionAssets> queryByTransactionId(Long transactionId) {
        return this.transactionAssetsDao.queryByTransactionId(transactionId);
    }

    /**
     * 分页查询
     *
     * @param transactionAssets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TransactionAssets> queryByPage(TransactionAssets transactionAssets, PageRequest pageRequest) {
        long total = this.transactionAssetsDao.count(transactionAssets);
        return new PageImpl<>(this.transactionAssetsDao.queryAllByLimit(transactionAssets, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param transactionAssets 实例对象
     * @return 实例对象
     */
    @Override
    public TransactionAssets insert(TransactionAssets transactionAssets) {
        this.transactionAssetsDao.insert(transactionAssets);
        return transactionAssets;
    }

    /**
     * 修改数据
     *
     * @param transactionAssets 实例对象
     * @return 实例对象
     */
    @Override
    public TransactionAssets update(TransactionAssets transactionAssets) {
        this.transactionAssetsDao.update(transactionAssets);
        return this.queryById(transactionAssets.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.transactionAssetsDao.deleteById(id) > 0;
    }
}
