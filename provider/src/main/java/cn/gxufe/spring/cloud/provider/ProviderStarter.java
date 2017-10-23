package cn.gxufe.spring.cloud.provider;


import cn.gxufe.spring.cloud.provider.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import javax.sql.DataSource;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@Controller("/")
@MapperScan("cn.gxufe.spring.cloud.provider.mapper")
@EnableEurekaClient
public class ProviderStarter {

    @Bean
    public MapperHelper mapperHelper(SqlSession sqlSession){
        MapperHelper mapperHelper = new MapperHelper();
        Config config = new Config();
        mapperHelper.setConfig(config);
        // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
        mapperHelper.registerMapper(UserMapper.class);
        //配置完成后，执行下面的操作
        mapperHelper.processConfiguration(sqlSession.getConfiguration());
        return mapperHelper;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }


    public static void main(String[] args){
        SpringApplication.run(ProviderStarter.class,args);
    }


}
