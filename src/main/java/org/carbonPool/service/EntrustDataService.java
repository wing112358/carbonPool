package org.carbonPool.service;

import org.carbonPool.entity.EntrustData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 委托数据表(EntrustData)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:09:04
 */
public interface EntrustDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EntrustData queryById(Long id);

    EntrustData queryByDataId(Long dataId);

    /**
     * 分页查询
     *
     * @param entrustData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<EntrustData> queryByPage(EntrustData entrustData, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param entrustData 实例对象
     * @return 实例对象
     */
    EntrustData insert(EntrustData entrustData);

    /**
     * 修改数据
     *
     * @param entrustData 实例对象
     * @return 实例对象
     */
    EntrustData update(EntrustData entrustData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
