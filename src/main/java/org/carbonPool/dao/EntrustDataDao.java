package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.EntrustData;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 委托数据表(EntrustData)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:35:43
 */
@Mapper
public interface EntrustDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EntrustData queryById(Long id);

    /**
     * 通过数据ID查询单条数据
     *
     * @param dataId 主键
     * @return 实例对象
     */
    EntrustData queryByDataId(Long dataId);

    /**
     * 查询指定行数据
     *
     * @param entrustData 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<EntrustData> queryAllByLimit(EntrustData entrustData, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param entrustData 查询条件
     * @return 总行数
     */
    long count(EntrustData entrustData);

    /**
     * 新增数据
     *
     * @param entrustData 实例对象
     * @return 影响行数
     */
    int insert(EntrustData entrustData);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EntrustData> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EntrustData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EntrustData> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EntrustData> entities);

    /**
     * 修改数据
     *
     * @param entrustData 实例对象
     * @return 影响行数
     */
    int update(EntrustData entrustData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

