package com.liujl.app.config;

import com.liujl.core.boot.Bootstrap;
import com.liujl.core.boot.RegisterFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujl on 2018/8/3.
 */
@Configuration
public class FrameworkConfig {

    @Autowired
    private RegisterFactory registerFactory;

    @Bean
    public com.liujl.core.boot.Bootstrap bootstrap() throws Exception {
        List<String> packages = new ArrayList<>();
        packages.add("com.liujl.app");
        Bootstrap b = new Bootstrap();
        b.setPackages(packages);
        b.init(registerFactory);
        return b;
    }
}
