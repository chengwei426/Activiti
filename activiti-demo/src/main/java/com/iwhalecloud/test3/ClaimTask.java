package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

public class ClaimTask {
    // 查询候选用户的组任务
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_2")
                .taskCandidateUser("wangwu")  // 设置候选用户
                .singleResult();

        if (task != null) {
            // 拾取任务
            taskService.claim(task.getId(), "wangwu");
            System.out.println("任务拾取完毕");
        }

    }
}
