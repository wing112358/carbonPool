package org.carbonPool.service.impl;

import org.carbonPool.entity.Equity;
import org.carbonPool.dao.EquityDao;
import org.carbonPool.service.EquityService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权益表(Equity)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:09:11
 */
@Service("equityService")
public class EquityServiceImpl implements EquityService {
    @Resource
    private EquityDao equityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Equity queryById(Long id) {
        return this.equityDao.queryById(id);
    }

    /**
     * 通过项目ID查询权益列表
     *
     * @param projectId 主键
     * @return 实例对象
     */
    @Override
    public List<Long> queryIdById(Long projectId) {
        return this.equityDao.queryIdById(projectId);
    }

    /**
     * 通过项目ID查询权益列表
     *
     * @param projectId 主键
     * @return 实例对象
     */
    @Override
    public List<Long> queryIdByLimit(Long projectId,Integer limit) {
        return this.equityDao.queryIdByLimit(projectId,limit);
    }

    /**
     * 分页查询
     *
     * @param equity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Equity> queryByPage(Equity equity, PageRequest pageRequest) {
        long total = this.equityDao.count(equity);
        return new PageImpl<>(this.equityDao.queryAllByLimit(equity, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param equity 实例对象
     * @return 实例对象
     */
    @Override
    public Equity insert(Equity equity) {
        this.equityDao.insert(equity);
        return equity;
    }

    /**
     * 根据项目Id查询月份
     *
     * @param projectID 筛选条件
     * @return 实例对象
     */
    @Override
    public Long countByProjectId(Long projectID) {
        return this.equityDao.countByProjectId(projectID);
    }

    /**
     * 修改数据
     *
     * @param equity 实例对象
     * @return 实例对象
     */
    @Override
    public Equity update(Equity equity) {
        this.equityDao.update(equity);
        return this.queryById(equity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.equityDao.deleteById(id) > 0;
    }
}
