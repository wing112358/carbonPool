package org.carbonPool.service;

import org.carbonPool.entity.Equity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 权益表(Equity)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 16:09:11
 */
public interface EquityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equity queryById(Long id);

    List<Long> queryIdById(Long projectId);

    List<Long> queryIdByLimit(Long projectId, Integer limit);

    /**
     * 分页查询
     *
     * @param equity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Equity> queryByPage(Equity equity, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param equity 实例对象
     * @return 实例对象
     */
    Equity insert(Equity equity);

    Long countByProjectId(Long projectID);

    /**
     * 修改数据
     *
     * @param equity 实例对象
     * @return 实例对象
     */
    Equity update(Equity equity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
