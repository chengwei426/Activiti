package com.iwhalecloud.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 处理当前用户的任务列表
 * act_hi_actinst
 * act_hi_identitylink
 * act_hi_taskinst
 * act_ru_execution (未变化)
 * act_ru_identitylink
 * act_ru_task
 */
public class ActivitiTaskComplete {
    public static void main(String[] args) {
        // 1. 得到processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 查询当前用户的任务
        Task task = taskService.createTaskQuery().processDefinitionKey("myHoliday")
                .taskAssignee("王五")
                .singleResult();

        // 4. 处理任务, 结合当前用户任务列表的查询操作的话, 任务id: 2505
        //taskService.complete("7502");
        taskService.complete(task.getId());
        // 5. 输出任务的id
        System.out.println(task.getId());








    }




}
