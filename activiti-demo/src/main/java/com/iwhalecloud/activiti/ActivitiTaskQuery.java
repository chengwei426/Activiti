package com.iwhalecloud.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 查询当前用户的任务列表
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        // 1. 得到processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

//        // 3. 根据流程定义的key, 负责人assignee来实现当前用户的任务列表查询
//        List<Task> taskList = taskService.createTaskQuery()
//                .processDefinitionKey("myHoliday")
//                .taskAssignee("张三").list();
//        // 4. 任务列表的展示
//        for (Task task : taskList) {
//            System.out.println(task.getId());
//            System.out.println(task.getProcessDefinitionId());
//            System.out.println(task.getAssignee());
//            System.out.println(task.getName());
//        }

        // 3. 根据流程定义的key, 负责人assignee来实现当前用户的任务列表查询
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myHoliday")
                .taskAssignee("王五").singleResult();
        // 4. 任务列表的展示
        System.out.println(task.getId());
        System.out.println(task.getProcessDefinitionId());
        System.out.println(task.getAssignee());
        System.out.println(task.getName());








    }




}
