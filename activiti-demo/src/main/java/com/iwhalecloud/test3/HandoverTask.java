package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

// 交接任务
public class HandoverTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().processDefinitionKey("myProcess_2")
                .taskAssignee("wangwu").singleResult();
        if (task != null) {
            taskService.setAssignee(task.getId(), "lili");
            System.out.println("交接任务完成");
        }

    }
}
