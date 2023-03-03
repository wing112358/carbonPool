package org.carbonPool.Bean.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

/**
 * 接口返回实体
 * @author wing
 */

@Data
@Slf4j
@AllArgsConstructor
public class Response {
    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 返回体内容
     */
    private String responseContent;

    /**
     * 返回cookie
     */
    private CookieStore cookies;

    /**
     * 返回header
     */
    private Header[] headers;

    /**
     * 赋值方法及打印
     */

}
