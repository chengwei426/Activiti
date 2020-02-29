package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class CompleteTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery().processDefinitionKey("myProcess_2")
                .taskAssignee("lisi").singleResult();
        if (task != null) {
            taskService.complete(task.getId());
            System.out.println("complete task....");
        }
    }
}
