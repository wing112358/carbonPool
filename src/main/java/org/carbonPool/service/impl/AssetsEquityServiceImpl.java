package org.carbonPool.service.impl;

import org.carbonPool.entity.AssetsEquity;
import org.carbonPool.dao.AssetsEquityDao;
import org.carbonPool.service.AssetsEquityService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 资产权益表(AssetsEquity)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:08:34
 */
@Service("assetsEquityService")
public class AssetsEquityServiceImpl implements AssetsEquityService {
    @Resource
    private AssetsEquityDao assetsEquityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AssetsEquity queryById(Long id) {
        return this.assetsEquityDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param assetsEquity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AssetsEquity> queryByPage(AssetsEquity assetsEquity, PageRequest pageRequest) {
        long total = this.assetsEquityDao.count(assetsEquity);
        return new PageImpl<>(this.assetsEquityDao.queryAllByLimit(assetsEquity, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param assetsEquity 实例对象
     * @return 实例对象
     */
    @Override
    public AssetsEquity insert(AssetsEquity assetsEquity) {
        this.assetsEquityDao.insert(assetsEquity);
        return assetsEquity;
    }

    /**
     * 修改数据
     *
     * @param assetsEquity 实例对象
     * @return 实例对象
     */
    @Override
    public AssetsEquity update(AssetsEquity assetsEquity) {
        this.assetsEquityDao.update(assetsEquity);
        return this.queryById(assetsEquity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.assetsEquityDao.deleteById(id) > 0;
    }
}
