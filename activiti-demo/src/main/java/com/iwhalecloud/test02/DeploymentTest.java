package com.iwhalecloud.test02;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class DeploymentTest {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 部署
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/holiday4.bpmn")
                .addClasspathResource("diagram/holiday4.png")
                .name("请假流程-流程部署")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }
}
