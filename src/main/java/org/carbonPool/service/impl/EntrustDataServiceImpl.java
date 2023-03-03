package org.carbonPool.service.impl;

import org.carbonPool.entity.EntrustData;
import org.carbonPool.dao.EntrustDataDao;
import org.carbonPool.service.EntrustDataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 委托数据表(EntrustData)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 16:09:04
 */
@Service("entrustDataService")
public class EntrustDataServiceImpl implements EntrustDataService {
    @Resource
    private EntrustDataDao entrustDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EntrustData queryById(Long id) {
        return this.entrustDataDao.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param dataId 主键
     * @return 实例对象
     */
    @Override
    public EntrustData queryByDataId(Long dataId) {
        return this.entrustDataDao.queryByDataId(dataId);
    }

    /**
     * 分页查询
     *
     * @param entrustData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<EntrustData> queryByPage(EntrustData entrustData, PageRequest pageRequest) {
        long total = this.entrustDataDao.count(entrustData);
        return new PageImpl<>(this.entrustDataDao.queryAllByLimit(entrustData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param entrustData 实例对象
     * @return 实例对象
     */
    @Override
    public EntrustData insert(EntrustData entrustData) {
        this.entrustDataDao.insert(entrustData);
        return entrustData;
    }

    /**
     * 修改数据
     *
     * @param entrustData 实例对象
     * @return 实例对象
     */
    @Override
    public EntrustData update(EntrustData entrustData) {
        this.entrustDataDao.update(entrustData);
        return this.queryById(entrustData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.entrustDataDao.deleteById(id) > 0;
    }
}
