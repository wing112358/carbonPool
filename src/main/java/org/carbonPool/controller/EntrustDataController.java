package org.carbonPool.controller;

import org.carbonPool.entity.EntrustData;
import org.carbonPool.service.EntrustDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 委托数据表(EntrustData)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:09:04
 */
@RestController
@RequestMapping("entrustData")
public class EntrustDataController {
    /**
     * 服务对象
     */
    @Resource
    private EntrustDataService entrustDataService;

    /**
     * 分页查询
     *
     * @param entrustData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EntrustData>> queryByPage(EntrustData entrustData, PageRequest pageRequest) {
        return ResponseEntity.ok(this.entrustDataService.queryByPage(entrustData, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EntrustData> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.entrustDataService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param entrustData 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<EntrustData> add(EntrustData entrustData) {
        return ResponseEntity.ok(this.entrustDataService.insert(entrustData));
    }

    /**
     * 编辑数据
     *
     * @param entrustData 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<EntrustData> edit(EntrustData entrustData) {
        return ResponseEntity.ok(this.entrustDataService.update(entrustData));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.entrustDataService.deleteById(id));
    }

}

