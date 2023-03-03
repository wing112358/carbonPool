package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 委托表(Entrust)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:35:29
 */
public class Entrust implements Serializable {
    private static final long serialVersionUID = 325914656012968275L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 委托编号
     */
    private String serialnumber;
    /**
     * 委托类型（1项目委托 2资产委托）
     */
    private Integer type;
    /**
     * 委托状态（见字典表entrustStatus）
     */
    private Integer status;
    /**
     * 委托期限
     */
    private String limitTime;
    /**
     * 委托到期时间
     */
    private Date closeTime;
    /**
     * 项目/资产持有组织id
     */
    private Long customerId;
    /**
     * 委托人
     */
    private String customerName;
    /**
     * 项目/资产委托组织id
     */
    private Long entrustCustomerId;
    /**
     * 受委托人
     */
    private String entrustCustomerName;
    /**
     * 创建者用户id
     */
    private Long creatorUserId;
    /**
     * 创建人姓名
     */
    private String creatorUserName;
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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getEntrustCustomerId() {
        return entrustCustomerId;
    }

    public void setEntrustCustomerId(Long entrustCustomerId) {
        this.entrustCustomerId = entrustCustomerId;
    }

    public String getEntrustCustomerName() {
        return entrustCustomerName;
    }

    public void setEntrustCustomerName(String entrustCustomerName) {
        this.entrustCustomerName = entrustCustomerName;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
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

