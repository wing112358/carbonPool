package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 委托数据表(EntrustData)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:35:43
 */
public class EntrustData implements Serializable {
    private static final long serialVersionUID = 909294341737811250L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 委托id
     */
    private Long entrustId;
    /**
     * 数据id（项目或资产id）
     */
    private Long dataId;
    /**
     * 是否删除（0未删除，1已删除）
     */
    private Integer isDelete;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 创建时间
     */
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

