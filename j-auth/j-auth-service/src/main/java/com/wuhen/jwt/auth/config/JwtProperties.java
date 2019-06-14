package com.wuhen.jwt.auth.config;


import com.wuhen.jwt.auth.utils.RsaUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;


import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Author: 98050
 * @Time: 2018-10-23 22:20
 * @Feature: jwt配置参数
 */


@Data
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {

    /**
     * 密钥
     */
    private String secret;

    /**
     * 公钥地址
     */
    private String pubKeyPath;

    /**
     * 私钥地址
     */
    private String priKeyPath;

    /**
     * token过期时间
     */
    private int expire;

    /**
     * cookieName
     */
    private String cookieName;
    /**
     * cookieMaxAge
     */
    private int cookieMaxAge;
    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;


    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

    /**
     * @PostConstruct :在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        try {
            File pubKey = new File(pubKeyPath);
            File priKey = new File(priKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                // 生成公钥和私钥
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            logger.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }


}
