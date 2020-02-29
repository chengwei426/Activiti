package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 实现单个流程实例的挂起与激活
 */
public class SuspendSingleProcessInstance {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("20001").singleResult();

        String processInstanceId = processInstance.getId();

        boolean ifSuspend = processInstance.isSuspended();
        if (ifSuspend) {
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例：" + processInstanceId + "激活");
        } else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例：" + processInstanceId + "挂机");
        }

    }
}
