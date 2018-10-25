package com.liujl.core.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lombok.Getter;
import lombok.Setter;

/**
 * 应用的核心引导启动类
 *
 * 负责扫描在applicationContext.xml中配置的packages. 获取到CommandExecutors, intercepters, extensions,
 * validators等 交给各个注册器进行注册。 Created by liujl on 2018/8/2.
 */
@Component
public class Bootstrap {
    @Getter
    @Setter
    private List<String> packages;//扫描的包路径
    private ClassPathScanHandler handler;//类扫描

    //    @Autowired
//autowire注入不了，只能通过容器传入进来
    private RegisterFactory registerFactory;

    public void init(RegisterFactory registerFactory) throws Exception {
        this.registerFactory = registerFactory;
        Set<Class<?>> classSet = scanConfiguredPackages();
        registerBeans(classSet);

    }

    /**
     * @param classSet
     */
    private void registerBeans(Set<Class<?>> classSet) {
        for (Class<?> targetClz : classSet) {
            RegisterI register = registerFactory.getRegister(targetClz);
            if (null != register) {
                register.doRegistration(targetClz);
            }
        }
    }

    /**
     * Scan the packages configured in Spring xml
     */
    private Set<Class<?>> scanConfiguredPackages() throws Exception {
        //todo 申明runtimeexception
        if (packages == null) throw new Exception("Command packages is not specified");

        String[] pkgs = new String[packages.size()];
        handler = new ClassPathScanHandler(packages.toArray(pkgs));

        Set<Class<?>> classSet = new TreeSet<>(new ClassNameComparator());
        for (String pakName : packages) {
            classSet.addAll(handler.getPackageAllClasses(pakName, true));
        }
        return classSet;
    }
}
