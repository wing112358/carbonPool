package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.AssetsEquity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 资产权益表(AssetsEquity)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:35:02
 */
@Mapper
public interface AssetsEquityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AssetsEquity queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param assetsEquity 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AssetsEquity> queryAllByLimit(AssetsEquity assetsEquity, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param assetsEquity 查询条件
     * @return 总行数
     */
    long count(AssetsEquity assetsEquity);

    /**
     * 新增数据
     *
     * @param assetsEquity 实例对象
     * @return 影响行数
     */
    int insert(AssetsEquity assetsEquity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssetsEquity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AssetsEquity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssetsEquity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AssetsEquity> entities);

    /**
     * 修改数据
     *
     * @param assetsEquity 实例对象
     * @return 影响行数
     */
    int update(AssetsEquity assetsEquity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

