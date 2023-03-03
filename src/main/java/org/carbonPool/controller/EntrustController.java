package org.carbonPool.controller;

import org.carbonPool.entity.Entrust;
import org.carbonPool.service.EntrustService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 委托表(Entrust)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:08:52
 */
@RestController
@RequestMapping("entrust")
public class EntrustController {
    /**
     * 服务对象
     */
    @Resource
    private EntrustService entrustService;

    /**
     * 分页查询
     *
     * @param entrust 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Entrust>> queryByPage(Entrust entrust, PageRequest pageRequest) {
        return ResponseEntity.ok(this.entrustService.queryByPage(entrust, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Entrust> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.entrustService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param entrust 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Entrust> add(Entrust entrust) {
        return ResponseEntity.ok(this.entrustService.insert(entrust));
    }

    /**
     * 编辑数据
     *
     * @param entrust 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Entrust> edit(Entrust entrust) {
        return ResponseEntity.ok(this.entrustService.update(entrust));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.entrustService.deleteById(id));
    }

}

