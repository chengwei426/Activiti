package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

public class CandidateUser {
    // 查询候选用户的组任务
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_2")
                //.taskCandidateUser("wangwu")  // 设置候选用户
                .taskAssignee("wangwu")
                .list();

        for (Task task : list) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getProcessDefinitionId());
            System.out.println(task.getAssignee());
        }

    }
}
