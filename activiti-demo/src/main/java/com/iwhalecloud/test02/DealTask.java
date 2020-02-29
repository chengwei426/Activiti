package com.iwhalecloud.test02;

import com.iwhalecloud.entity.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

public class DealTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        String key = "myProcess_1";
        Map<String, Object> map = new HashMap<String, Object>(8);
        Holiday holiday = new Holiday();
        holiday.setDayNum(5f);
        map.put("holiday", holiday);
        Task task = taskService.createTaskQuery().processDefinitionKey(key)
                .taskAssignee("zhangsan").singleResult();
        if (task != null) {
            taskService.complete(task.getId(), map);
            System.out.println("任务执行完毕");
        }
    }
}
