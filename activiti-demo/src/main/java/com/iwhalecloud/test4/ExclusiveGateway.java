package com.iwhalecloud.test4;

import com.iwhalecloud.entity.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;

public class ExclusiveGateway {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        Holiday holiday = new Holiday();
        holiday.setDayNum(5F);
        HashMap<String, Object> map = new HashMap<String, Object>(8);
        map.put("holiday", holiday);
        // 创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_3", map);

        System.out.println("流程定义id: " + processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID: " + processInstance.getId());





    }
}
