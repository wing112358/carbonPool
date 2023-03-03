package org.carbonPool.service;

import org.carbonPool.entity.AssetsEquity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 资产权益表(AssetsEquity)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:08:34
 */
public interface AssetsEquityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AssetsEquity queryById(Long id);

    /**
     * 分页查询
     *
     * @param assetsEquity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AssetsEquity> queryByPage(AssetsEquity assetsEquity, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param assetsEquity 实例对象
     * @return 实例对象
     */
    AssetsEquity insert(AssetsEquity assetsEquity);

    /**
     * 修改数据
     *
     * @param assetsEquity 实例对象
     * @return 实例对象
     */
    AssetsEquity update(AssetsEquity assetsEquity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
