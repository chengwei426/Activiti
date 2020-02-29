package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

/**
 * 实现全部流程实例的挂起与激活
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 获取repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 获取流程定义对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myHoliday").singleResult();
        // 当前流程定义的实例是否都为暂停状态
        boolean ifSuspended = processDefinition.isSuspended();
        if (ifSuspended) {
            // 是暂停, 就可以进行激活操作
            // repositoryService.activateProcessDefinitionByKey("myHoliday");
            repositoryService.activateProcessDefinitionById(processDefinition.getId(), true, null);
            System.out.println("流程定义：" + processDefinition.getId() + "激活");
        } else {
            // 是激活, 就可以进行暂停操作
            // repositoryService.suspendProcessDefinitionByKey("myHoliday");
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(), true, null);
            System.out.println("流程定义：" + processDefinition.getId() + "挂起");

        }

    }
}
