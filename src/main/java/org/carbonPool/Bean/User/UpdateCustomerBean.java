package org.carbonPool.Bean.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class UpdateCustomerBean extends Request {
    /**
     *账号
     */
    private String account;


    /**
     *头像
     */
    private String address;

    /**
     *企业名称
     */
    private String annualIncome;


    /**
     *密码
     */
    private String attachmentList;

    /**
     *父级Id
     */
    private Integer bindingCustomer;


    /**
     *套餐ID
     */
    private Integer businessLicenseResources;

    /**
     *终端类型 1pc 1h5
     */
    private Integer contactName;


    /**
     *用户类型：空为c端用户，ordinary_enterprise为一般企业账户，rating为评级机构企业账户
     */
    private String contactPhone;

    /**
     *用户名
     */
    private String createTime;


    /**
     *验证码
     */
    private String creditRating;



}
