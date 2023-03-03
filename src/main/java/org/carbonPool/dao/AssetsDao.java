package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.Assets;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 资产表(Assets)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:34:38
 */
@Mapper
public interface AssetsDao {

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
     * 查询指定行数据
     *
     * @param assets 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Assets> queryAllByLimit(Assets assets, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param assets 查询条件
     * @return 总行数
     */
    long count(Assets assets);

    /**
     * 新增数据
     *
     * @param assets 实例对象
     * @return 影响行数
     */
    int insert(Assets assets);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Assets> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Assets> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Assets> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Assets> entities);

    /**
     * 修改数据
     *
     * @param assets 实例对象
     * @return 影响行数
     */
    int update(Assets assets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

