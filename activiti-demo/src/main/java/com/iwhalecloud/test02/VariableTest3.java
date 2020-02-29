package com.iwhalecloud.test02;

import com.iwhalecloud.entity.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

public class VariableTest3 {
    // 启动流程实例, 同时还要设置流程变量 act_ge_bytearray act_ru_variable
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 流程定义key对的问题 -4
        Holiday holiday = new Holiday();
        holiday.setDayNum(5f);
        String key = "myProcess_1";

        // 通过实例id, 来设置流程变量
        // 第一个参数是流程实例ID; 第二参数是流程变量; 第三个参数是流程变量对应的值
        runtimeService.setVariable("2501", "holiday", holiday);
        // runtimeService.setVariables();



    }

}
