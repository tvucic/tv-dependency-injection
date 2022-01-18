package com.tomo.tvdependencyinjection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("app")
public class ProdConstructorConfig
{
    private final String username;
    private final String password;
    private final String jdbcurl;

    public ProdConstructorConfig(String username, String password, String jdbcurl)
    {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getJdbcurl()
    {
        return jdbcurl;
    }
}
