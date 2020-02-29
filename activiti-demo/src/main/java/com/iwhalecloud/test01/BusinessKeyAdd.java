package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例: 添加进businessKey
 * 本质: act_ru_execution要存入businessKey
 */
public class BusinessKeyAdd {

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 获取runtimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 启动流程实例, 同时还要指定业务标识businessKey, 它本省就是请假单的id
        // 第一个参数: 流程定义Key
        // 第二个参数: businessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myHoliday", "1001");

        // 输出ProcessInstance相关属性
        System.out.println(processInstance.getBusinessKey());


    }
}
