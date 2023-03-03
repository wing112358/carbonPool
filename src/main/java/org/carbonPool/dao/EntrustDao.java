package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.Entrust;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 委托表(Entrust)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:35:29
 */
@Mapper
public interface EntrustDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Entrust queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param entrust 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Entrust> queryAllByLimit(Entrust entrust, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param entrust 查询条件
     * @return 总行数
     */
    long count(Entrust entrust);

    /**
     * 新增数据
     *
     * @param entrust 实例对象
     * @return 影响行数
     */
    int insert(Entrust entrust);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Entrust> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Entrust> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Entrust> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Entrust> entities);

    /**
     * 修改数据
     *
     * @param entrust 实例对象
     * @return 影响行数
     */
    int update(Entrust entrust);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

