package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.Demand;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 交易需求表(Demand)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:35:14
 */
@Mapper
public interface DemandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Demand queryById(Long id);

    /**
     * 通过条件查询单条数据
     *
     * @param customerId 主键
     * @return 实例对象
     */
    Demand queryByDate(Integer customerId,String startTime,String endTime,String assetType, String energyType,String customerName);

    /**
     * 查询指定行数据
     *
     * @param demand 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Demand> queryAllByLimit(Demand demand, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param demand 查询条件
     * @return 总行数
     */
    long count(Demand demand);

    /**
     * 新增数据
     *
     * @param demand 实例对象
     * @return 影响行数
     */
    int insert(Demand demand);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Demand> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Demand> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Demand> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Demand> entities);

    /**
     * 修改数据
     *
     * @param demand 实例对象
     * @return 影响行数
     */
    int update(Demand demand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

