package org.carbonPool.service.impl;

import org.carbonPool.entity.Assets;
import org.carbonPool.dao.AssetsDao;
import org.carbonPool.service.AssetsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 资产表(Assets)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:08:22
 */
@Service("assetsService")
public class AssetsServiceImpl implements AssetsService {
    @Resource
    private AssetsDao assetsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Assets queryById(Long id) {
        return this.assetsDao.queryById(id);
    }

    @Override
    public Assets queryByProjectId(Long projectId, String startTime, String endTime) {
        return this.assetsDao.queryByProjectId(projectId,startTime,endTime);
    }

    /**
     * 分页查询
     *
     * @param assets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Assets> queryByPage(Assets assets, PageRequest pageRequest) {
        long total = this.assetsDao.count(assets);
        return new PageImpl<>(this.assetsDao.queryAllByLimit(assets, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param assets 实例对象
     * @return 实例对象
     */
    @Override
    public Assets insert(Assets assets) {
        this.assetsDao.insert(assets);
        return assets;
    }

    /**
     * 修改数据
     *
     * @param assets 实例对象
     * @return 实例对象
     */
    @Override
    public Assets update(Assets assets) {
        this.assetsDao.update(assets);
        return this.queryById(assets.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.assetsDao.deleteById(id) > 0;
    }
}
