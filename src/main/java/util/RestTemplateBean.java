package util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBean {

    @Value("wx5c558cad54db1d4d")
    private String appid;

    private String code;//code需要从微信前段获取

    @Value("7ec69b2c84e51162a26f9557a93415f3")
    private String secret;

    @Value("authorization_code")
    private String grant_type;

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }


    @Override
    public String toString() {
        return "RestTemplateBean{" +
                "appid='" + appid + '\'' +
                ", code='" + code + '\'' +
                ", secret='" + secret + '\'' +
                ", grant_type='" + grant_type + '\'' +
                '}';
    }
}
