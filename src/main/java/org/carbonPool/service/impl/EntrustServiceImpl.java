package org.carbonPool.service.impl;

import org.carbonPool.entity.Entrust;
import org.carbonPool.dao.EntrustDao;
import org.carbonPool.service.EntrustService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 委托表(Entrust)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:08:52
 */
@Service("entrustService")
public class EntrustServiceImpl implements EntrustService {
    @Resource
    private EntrustDao entrustDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Entrust queryById(Long id) {
        return this.entrustDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param entrust 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Entrust> queryByPage(Entrust entrust, PageRequest pageRequest) {
        long total = this.entrustDao.count(entrust);
        return new PageImpl<>(this.entrustDao.queryAllByLimit(entrust, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param entrust 实例对象
     * @return 实例对象
     */
    @Override
    public Entrust insert(Entrust entrust) {
        this.entrustDao.insert(entrust);
        return entrust;
    }

    /**
     * 修改数据
     *
     * @param entrust 实例对象
     * @return 实例对象
     */
    @Override
    public Entrust update(Entrust entrust) {
        this.entrustDao.update(entrust);
        return this.queryById(entrust.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.entrustDao.deleteById(id) > 0;
    }
}
