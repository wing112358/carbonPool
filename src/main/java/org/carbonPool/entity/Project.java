package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 项目表(Project)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:36:14
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 103832936827801457L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 项目编号
     */
    private String serialnumber;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目持有人
     */
    private String holderName;
    /**
     * 项目地址（省）
     */
    private String addressProvince;
    /**
     * 项目地址（市）
     */
    private String addressCity;
    /**
     * 项目地址（区县）
     */
    private String addressArea;
    /**
     * 项目地址（街道）
     */
    private String addressStreet;
    /**
     * 项目地址（门牌号、楼栋、房间号）
     */
    private String addressNum;
    /**
     * 项目类型（见字典表projectType）
     */
    private String type;
    /**
     * 技术类型（见字典表technologyType）
     */
    private String technologyType;
    /**
     * 项目状态（0未开发，1已开发）
     */
    private Integer status;
    /**
     * 委托状态（见字典表entrustStatus）
     */
    private Integer entrustStatus;
    /**
     * 投运日期
     */
    private Date deliveryDate;
    /**
     * 装机容量（KW）
     */
    private Double capacity;
    /**
     * 消纳方式（见字典表absorptionType）
     */
    private String absorptionType;
    /**
     * 是否并网（0否 1是）
     */
    private Integer gridConnectedFlag;
    /**
     * 并网电压（见字典表gridConnectedVoltageType）
     */
    private String gridConnectedVoltageType;
    /**
     * 电网运营方
     */
    private String powerGridOperatorName;
    /**
     * 自消纳类型（见字典表selfAbsorptionType）
     */
    private String selfAbsorptionType;
    /**
     * 现场消纳人
     */
    private String siteAbsorptionName;
    /**
     * 消纳人户号
     */
    private String absorptionAccount;
    /**
     * 发电客户号
     */
    private String powerAccount;
    /**
     * 绿电交易（0未纳入 1已纳入）
     */
    private Integer greenTransaction;
    /**
     * 权益配置的开始时间
     */
    private Date equityStartTime;
    /**
     * 权益配置开启的组织id
     */
    private Long equityEnableCustomerId;
    /**
     * 开发时间（关联资产）
     */
    private Date developedTime;
    /**
     * 项目持有组织id
     */
    private Long customerId;
    /**
     * 项目委托组织id
     */
    private Long entrustCustomerId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(String technologyType) {
        this.technologyType = technologyType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEntrustStatus() {
        return entrustStatus;
    }

    public void setEntrustStatus(Integer entrustStatus) {
        this.entrustStatus = entrustStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getAbsorptionType() {
        return absorptionType;
    }

    public void setAbsorptionType(String absorptionType) {
        this.absorptionType = absorptionType;
    }

    public Integer getGridConnectedFlag() {
        return gridConnectedFlag;
    }

    public void setGridConnectedFlag(Integer gridConnectedFlag) {
        this.gridConnectedFlag = gridConnectedFlag;
    }

    public String getGridConnectedVoltageType() {
        return gridConnectedVoltageType;
    }

    public void setGridConnectedVoltageType(String gridConnectedVoltageType) {
        this.gridConnectedVoltageType = gridConnectedVoltageType;
    }

    public String getPowerGridOperatorName() {
        return powerGridOperatorName;
    }

    public void setPowerGridOperatorName(String powerGridOperatorName) {
        this.powerGridOperatorName = powerGridOperatorName;
    }

    public String getSelfAbsorptionType() {
        return selfAbsorptionType;
    }

    public void setSelfAbsorptionType(String selfAbsorptionType) {
        this.selfAbsorptionType = selfAbsorptionType;
    }

    public String getSiteAbsorptionName() {
        return siteAbsorptionName;
    }

    public void setSiteAbsorptionName(String siteAbsorptionName) {
        this.siteAbsorptionName = siteAbsorptionName;
    }

    public String getAbsorptionAccount() {
        return absorptionAccount;
    }

    public void setAbsorptionAccount(String absorptionAccount) {
        this.absorptionAccount = absorptionAccount;
    }

    public String getPowerAccount() {
        return powerAccount;
    }

    public void setPowerAccount(String powerAccount) {
        this.powerAccount = powerAccount;
    }

    public Integer getGreenTransaction() {
        return greenTransaction;
    }

    public void setGreenTransaction(Integer greenTransaction) {
        this.greenTransaction = greenTransaction;
    }

    public Date getEquityStartTime() {
        return equityStartTime;
    }

    public void setEquityStartTime(Date equityStartTime) {
        this.equityStartTime = equityStartTime;
    }

    public Long getEquityEnableCustomerId() {
        return equityEnableCustomerId;
    }

    public void setEquityEnableCustomerId(Long equityEnableCustomerId) {
        this.equityEnableCustomerId = equityEnableCustomerId;
    }

    public Date getDevelopedTime() {
        return developedTime;
    }

    public void setDevelopedTime(Date developedTime) {
        this.developedTime = developedTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEntrustCustomerId() {
        return entrustCustomerId;
    }

    public void setEntrustCustomerId(Long entrustCustomerId) {
        this.entrustCustomerId = entrustCustomerId;
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

