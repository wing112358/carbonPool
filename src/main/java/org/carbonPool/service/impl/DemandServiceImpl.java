package org.carbonPool.service.impl;

import org.carbonPool.entity.Demand;
import org.carbonPool.dao.DemandDao;
import org.carbonPool.service.DemandService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 交易需求表(Demand)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:08:43
 */
@Service("demandService")
public class DemandServiceImpl implements DemandService {
    @Resource
    private DemandDao demandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Demand queryById(Long id) {
        return this.demandDao.queryById(id);
    }

    @Override
    public Demand queryByDate(Integer customerId, String startTime, String endTime, String assetType, String energyType,String customerName) {
        return this.demandDao.queryByDate(customerId,startTime,endTime,assetType, energyType,customerName);
    }

    /**
     * 分页查询
     *
     * @param demand 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Demand> queryByPage(Demand demand, PageRequest pageRequest) {
        long total = this.demandDao.count(demand);
        return new PageImpl<>(this.demandDao.queryAllByLimit(demand, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param demand 实例对象
     * @return 实例对象
     */
    @Override
    public Demand insert(Demand demand) {
        this.demandDao.insert(demand);
        return demand;
    }

    /**
     * 修改数据
     *
     * @param demand 实例对象
     * @return 实例对象
     */
    @Override
    public Demand update(Demand demand) {
        this.demandDao.update(demand);
        return this.queryById(demand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.demandDao.deleteById(id) > 0;
    }
}
