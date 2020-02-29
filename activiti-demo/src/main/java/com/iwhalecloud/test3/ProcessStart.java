package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class ProcessStart {
    // 启动流程实例, 同时还要设置流程变量 act_ge_bytearray act_ru_variable
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 流程定义key对的问题
        String key = "myProcess_2";

        // 启动流程实例, 并且设置流程变量的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());


    }

}
