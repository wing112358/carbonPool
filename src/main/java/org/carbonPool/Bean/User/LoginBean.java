package org.carbonPool.Bean.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.carbonPool.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class LoginBean extends Request {
    /**
     *登录手机号
     */
    private String username;


    /**
     *验证码
     */
    private String password;



}
