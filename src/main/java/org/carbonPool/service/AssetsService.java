package org.carbonPool.service;

import org.carbonPool.entity.Assets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 资产表(Assets)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:08:22
 */
public interface AssetsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Assets queryById(Long id);

    /**
     * 通过项目ID查询单条数据
     *
     * @param projectId 主键
     * @return 实例对象
     */
    Assets queryByProjectId(Long projectId,String startTime,String endTime);

    /**
     * 分页查询
     *
     * @param assets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Assets> queryByPage(Assets assets, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param assets 实例对象
     * @return 实例对象
     */
    Assets insert(Assets assets);

    /**
     * 修改数据
     *
     * @param assets 实例对象
     * @return 实例对象
     */
    Assets update(Assets assets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
