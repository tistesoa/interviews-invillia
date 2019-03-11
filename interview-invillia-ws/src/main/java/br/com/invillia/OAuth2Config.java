package br.com.invillia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "invillia";
    private String clientSecret = "invillia-secret";
    private final String privateKey = "-----BEGIN RSA PRIVATE KEY-----"+
            "MIIEowIBAAKCAQEAwW0dMzmWt6c3kpLzLVc68TKvtO2LlrlIWYEBz2snvEHM453b" +
            "dHacLh+E6rULpjTRUImpO7GRltoVnn4bOZD+YsJAgJHwQfrSMGDO8fqK5TdrmYDx" +
            "uBLCQdylmm4J6NK1iEdCqWtlfdbjO8I7iWM/K7GVxGhHC1qp6bCWVzGIbcXLjIjX" +
            "ugVVU5co5VhA9W5WIrYEBgQkfBCpQ7PdhbI0OPfSymA5eiMBFKcESW4OTPuzCf09" +
            "gXbs/JI3YtkTvpL6zuIgd5CMjkiR6Sq7xgOPv9HFMcJ7yAGlN7X2ocijs3rNUJaD" +
            "Pluo7NlwKZ7sm/IpUhyIfzTmg98GHIWbQnZZjwIDAQABAoIBAQCFMynXm8HhqOKJ" +
            "Km8R+y8Y6Gm9c5Qb8G4VTNS9TLJpXvrEiHGW6xM0Y/o5UwG5rEe0aYhEFk0HEBmx" +
            "MnB3HRVBVznqEBXeqeZS8GeylXFO1fJgHD7ZHvntNxBHn51tWqUuOrx6RP34QaHs" +
            "Bh7Pxqu64Ckdvx2lgQLfbf6p/u9Pf6LTiWx+PSAb9Wl3LAqFktMeBlwWPST8OPOT" +
            "VfqrBlFZvfvCQLdjOjv6szvCxlWjKB+HVipdVeje14VpBcig0nTEO9BKzZSVZwQS" +
            "lYeUz8/sqnHxY6HWGzrzBp2SW5EfAU6kprfoOTEWE3NUncckKEX9//TTx0/4+rbE" +
            "+GzWPrZJAoGBAOO+zAeRxvfD60Ou8I46Du1G+VjtLMr95oPUPR9ziFmfYKnw3H/g" +
            "V9JrpSMVI790VQ3Yhbr63uLt3TvCpJbhHNFQ1v1ubj2b1/4gLx8BTpkhJgGJJTKQ" +
            "t3fyEM4kRiQi5BFX63jqdU8ksnPAUwjVaZxHZWy1XYjiAzC1tqdek4QbAoGBANls" +
            "V2hqwpNC2Pc1KPJIIARSbzYfoqnM3RDCCgUfhC8yi1AUFynXIwvTlT7Tp7Zxm6Gd" +
            "9VvghDrtJxNeBjnQbQyFBd0+tGR/GZVBqjfwoaxQjIRzyjuNfhK2aKXFQNCtMTHv" +
            "MAJOrMwJ+5tlczB42oEsd1iqd3ENha7Xsu00Tk+dAoGAbZ4QJjSMSAUM3+776fkX" +
            "5i0bJypBPRMoOJuXL+Qz5K9Jn4JHH2Wj36vgOBqcsjIUHi3xcCX/0cobigANqHGB" +
            "pV37nM/iT9ULCU4EYDAI3LuPx31zYfs10423eQEMoagJji97Lx/qhsVq/zu6u628" +
            "v3O95a0F8DSYxIEyAS0MY7ECgYBSEQvZFNsGvKeqf71J3iF/oCHsGvrJ/tK+fY9M" +
            "qb26Fujwu/SWTWckEqP1x+w4+B7XXQj8uf0PRO6H5+iPr/VJUXiKLx3mBPeCF/wJ" +
            "C2Hq6ahwYkhGPD0HESTk1VSGr6ivAWpspIeiqG35FMzq0eMf+Mm/hPB6krEP8sjN" +
            "sf2RHQKBgDFGtqyQY8v9aeYKzhK5W4mzOgkkMMFfdx36dwiw3y+/Mb9jLM2Yyz4k" +
            "OtNnK6dfoTSFjfIVrkTuVfg1C5KIOEcRwLOcxCslFTqFrkP/ejGf8FQdPW3dAckC" +
            "PMNiN2Bp3oa3gdx0wpLkGK/E/kzhWoDwqTKWy1PsCXzs6o+8HL/8"+
            "-----END RSA PRIVATE KEY-----";
    private final String publicKey = "-----BEGIN PUBLIC KEY-----"+
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwW0dMzmWt6c3kpLzLVc6" +
            "8TKvtO2LlrlIWYEBz2snvEHM453bdHacLh+E6rULpjTRUImpO7GRltoVnn4bOZD+" +
            "YsJAgJHwQfrSMGDO8fqK5TdrmYDxuBLCQdylmm4J6NK1iEdCqWtlfdbjO8I7iWM/" +
            "K7GVxGhHC1qp6bCWVzGIbcXLjIjXugVVU5co5VhA9W5WIrYEBgQkfBCpQ7PdhbI0" +
            "OPfSymA5eiMBFKcESW4OTPuzCf09gXbs/JI3YtkTvpL6zuIgd5CMjkiR6Sq7xgOP" +
            "v9HFMcJ7yAGlN7X2ocijs3rNUJaDPluo7NlwKZ7sm/IpUhyIfzTmg98GHIWbQnZZ" +
            "jwIDAQAB"+
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
} 