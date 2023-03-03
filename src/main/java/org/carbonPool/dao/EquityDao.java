package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.Equity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 权益表(Equity)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:35:55
 */
@Mapper
public interface EquityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equity queryById(Long id);

    /**
     * 通过项目ID查询权益列表
     *
     * @param projectId 主键
     * @return 实例对象
     */
    List<Long> queryIdById(Long projectId);

    /**
     * 通过项目ID查询部分权益列表
     *
     * @param projectId 主键
     * @return 实例对象
     */
    List<Long> queryIdByLimit(Long projectId,Integer limit);

    /**
     * 查询指定行数据
     *
     * @param equity 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Equity> queryAllByLimit(Equity equity, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param equity 查询条件
     * @return 总行数
     */
    long count(Equity equity);

    /**
     * 根据项目id统计月份
     *
     * @param projectId 查询条件
     * @return 总行数
     */
    long countByProjectId(Long projectId);

    /**
     * 新增数据
     *
     * @param equity 实例对象
     * @return 影响行数
     */
    int insert(Equity equity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Equity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Equity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Equity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Equity> entities);

    /**
     * 修改数据
     *
     * @param equity 实例对象
     * @return 影响行数
     */
    int update(Equity equity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

