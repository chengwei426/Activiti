package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;

public class AssigneeUEL {

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 获取RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 设置assignee取值, 用户可以在界面上设置流程的执行人
            HashMap<String, Object> map = new HashMap<String, Object>(8);
        map.put("assignee0", "张三");
        map.put("assignee1", "李四");
        map.put("assignee2", "王五");

        // 启动流程实例, 同时还需要设置流程定义的assignee的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myHoliday", map);
        // 输出
        System.out.println(processInstance.getName());

    }
}
