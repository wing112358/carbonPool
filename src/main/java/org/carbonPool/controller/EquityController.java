package org.carbonPool.controller;

import org.carbonPool.entity.Equity;
import org.carbonPool.service.EquityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权益表(Equity)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:09:11
 */
@RestController
@RequestMapping("equity")
public class EquityController {
    /**
     * 服务对象
     */
    @Resource
    private EquityService equityService;

    /**
     * 分页查询
     *
     * @param equity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Equity>> queryByPage(Equity equity, PageRequest pageRequest) {
        return ResponseEntity.ok(this.equityService.queryByPage(equity, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Equity> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.equityService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param equity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Equity> add(Equity equity) {
        return ResponseEntity.ok(this.equityService.insert(equity));
    }

    /**
     * 编辑数据
     *
     * @param equity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Equity> edit(Equity equity) {
        return ResponseEntity.ok(this.equityService.update(equity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.equityService.deleteById(id));
    }

}

