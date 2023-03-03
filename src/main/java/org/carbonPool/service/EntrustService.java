package org.carbonPool.service;

import org.carbonPool.entity.Entrust;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 委托表(Entrust)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:08:52
 */
public interface EntrustService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Entrust queryById(Long id);

    /**
     * 分页查询
     *
     * @param entrust 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Entrust> queryByPage(Entrust entrust, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param entrust 实例对象
     * @return 实例对象
     */
    Entrust insert(Entrust entrust);

    /**
     * 修改数据
     *
     * @param entrust 实例对象
     * @return 实例对象
     */
    Entrust update(Entrust entrust);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
