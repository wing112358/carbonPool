package org.carbonPool.Bean.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class RegiesterBean extends Request {
    /**
     *账号
     */
    private String account;


    /**
     *头像
     */
    private String avatar;

    /**
     *企业名称
     */
    private String name;


    /**
     *密码
     */
    private String password;

    /**
     *父级Id
     */
    private Integer pid;


    /**
     *套餐ID
     */
    private Integer setMealId;

    /**
     *终端类型 1pc 1h5
     */
    private Integer terminal;


    /**
     *用户类型：空为c端用户，ordinary_enterprise为一般企业账户，rating为评级机构企业账户
     */
    private String type;

    /**
     *用户名
     */
    private String username;


    /**
     *验证码
     */
    private String verificationCode;



}
