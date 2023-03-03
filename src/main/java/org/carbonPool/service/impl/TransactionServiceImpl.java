package org.carbonPool.service.impl;

import org.carbonPool.entity.Transaction;
import org.carbonPool.dao.TransactionDao;
import org.carbonPool.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 交易表(Transaction)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:09:30
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionDao transactionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Transaction queryById(Long id) {
        return this.transactionDao.queryById(id);
    }

    /**
     * 通过需求ID查询单条数据
     *
     * @param demandId 主键
     * @return 实例对象
     */
    @Override
    public Transaction queryByDemandId(Long demandId) {
        return this.transactionDao.queryByDemandId(demandId);
    }

    /**
     * 分页查询
     *
     * @param transaction 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Transaction> queryByPage(Transaction transaction, PageRequest pageRequest) {
        long total = this.transactionDao.count(transaction);
        return new PageImpl<>(this.transactionDao.queryAllByLimit(transaction, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param transaction 实例对象
     * @return 实例对象
     */
    @Override
    public Transaction insert(Transaction transaction) {
        this.transactionDao.insert(transaction);
        return transaction;
    }

    /**
     * 修改数据
     *
     * @param transaction 实例对象
     * @return 实例对象
     */
    @Override
    public Transaction update(Transaction transaction) {
        this.transactionDao.update(transaction);
        return this.queryById(transaction.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.transactionDao.deleteById(id) > 0;
    }
}
