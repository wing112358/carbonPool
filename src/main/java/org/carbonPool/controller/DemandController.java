package org.carbonPool.controller;

import org.carbonPool.entity.Demand;
import org.carbonPool.service.DemandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易需求表(Demand)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:08:43
 */
@RestController
@RequestMapping("demand")
public class DemandController {
    /**
     * 服务对象
     */
    @Resource
    private DemandService demandService;

    /**
     * 分页查询
     *
     * @param demand 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Demand>> queryByPage(Demand demand, PageRequest pageRequest) {
        return ResponseEntity.ok(this.demandService.queryByPage(demand, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Demand> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.demandService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param demand 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Demand> add(Demand demand) {
        return ResponseEntity.ok(this.demandService.insert(demand));
    }

    /**
     * 编辑数据
     *
     * @param demand 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Demand> edit(Demand demand) {
        return ResponseEntity.ok(this.demandService.update(demand));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.demandService.deleteById(id));
    }

}

