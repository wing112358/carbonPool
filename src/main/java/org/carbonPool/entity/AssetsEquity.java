package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 资产权益表(AssetsEquity)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:35:02
 */
public class AssetsEquity implements Serializable {
    private static final long serialVersionUID = 218323532980985319L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 资产id
     */
    private Long assetsId;
    /**
     * 权益id
     */
    private Long equityId;
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

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public Long getEquityId() {
        return equityId;
    }

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
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

