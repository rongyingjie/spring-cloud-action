package cn.gxufe.spring.cloud.config;

import com.netflix.loadbalancer.RoundRobinRule;

public class MyRoundRobinRule extends RoundRobinRule {

    public MyRoundRobinRule(){
        System.out.println("==============MyRoundRobinRule===============");
    }

}
