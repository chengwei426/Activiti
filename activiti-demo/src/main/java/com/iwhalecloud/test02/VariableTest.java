package com.iwhalecloud.test02;

import com.iwhalecloud.entity.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

public class VariableTest {
    // 启动流程实例, 同时还要设置流程变量
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 流程定义key对的问题 -4
        Map<String, Object> map = new HashMap<String, Object>(8);
        Holiday holiday = new Holiday();
        holiday.setDayNum(5f);
        map.put("holiday", holiday);
        String key = "myProcess_1";

        // 启动流程实例, 并且设置流程变量的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());


    }

}
