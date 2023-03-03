package org.carbonPool.service;

import org.carbonPool.entity.Demand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 交易需求表(Demand)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:08:43
 */
public interface DemandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Demand queryById(Long id);

    /**
     * 通过条件查询单条数据
     *
     * @param customerId 主键
     * @return 实例对象
     */
    Demand queryByDate(Integer customerId,String startTime,String endTime,String assetType, String energyType,String customerName);

    /**
     * 分页查询
     *
     * @param demand 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Demand> queryByPage(Demand demand, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param demand 实例对象
     * @return 实例对象
     */
    Demand insert(Demand demand);

    /**
     * 修改数据
     *
     * @param demand 实例对象
     * @return 实例对象
     */
    Demand update(Demand demand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
