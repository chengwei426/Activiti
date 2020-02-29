package com.iwhalecloud.test3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class DeploymentTest {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 部署
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/holiday5.bpmn")
                //.addClasspathResource("diagram/holiday5.png")
                .name("请假流程-流程部署测试")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }
}
