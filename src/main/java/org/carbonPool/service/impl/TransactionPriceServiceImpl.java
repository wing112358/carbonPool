package org.carbonPool.service.impl;

import org.carbonPool.entity.TransactionPrice;
import org.carbonPool.dao.TransactionPriceDao;
import org.carbonPool.service.TransactionPriceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 交易价格表(TransactionPrice)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:09:45
 */
@Service("transactionPriceService")
public class TransactionPriceServiceImpl implements TransactionPriceService {
    @Resource
    private TransactionPriceDao transactionPriceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TransactionPrice queryById(Long id) {
        return this.transactionPriceDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param transactionPrice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TransactionPrice> queryByPage(TransactionPrice transactionPrice, PageRequest pageRequest) {
        long total = this.transactionPriceDao.count(transactionPrice);
        return new PageImpl<>(this.transactionPriceDao.queryAllByLimit(transactionPrice, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param transactionPrice 实例对象
     * @return 实例对象
     */
    @Override
    public TransactionPrice insert(TransactionPrice transactionPrice) {
        this.transactionPriceDao.insert(transactionPrice);
        return transactionPrice;
    }

    /**
     * 修改数据
     *
     * @param transactionPrice 实例对象
     * @return 实例对象
     */
    @Override
    public TransactionPrice update(TransactionPrice transactionPrice) {
        this.transactionPriceDao.update(transactionPrice);
        return this.queryById(transactionPrice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.transactionPriceDao.deleteById(id) > 0;
    }
}
