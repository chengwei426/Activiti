package com.iwhalecloud.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class ActivitiDeployment {

    // 流程定义部署
    public static void main(String[] args) {
        // 1. 创建processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获取repositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 进行部署
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/myHoliady.bpmn")
                .addClasspathResource("diagram/myHoliady.png")
                .name("请假申请单流程")
                .deploy();
        // 4. 输出部署的一些信息
        System.out.println("流程部署ID: " + deploy.getId());
        System.out.println("流程部署Name: " + deploy.getName());

        // -------------------------------------------------------------------------------------------------------
       /* // 1. 创建processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获取repositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 转化出ZipInputStream流对象
        InputStream is = ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/holiday.zip");

        // 将inputStream转化为zipInputStram
        ZipInputStream zipInputStream = new ZipInputStream(is);
        // 3. 进行部署
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请单流程")
                .deploy();
        // 4. 输出部署的一些信息
        System.out.println("流程部署ID: " + deploy.getId());
        System.out.println("流程部署Name: " + deploy.getName());*/

    }

}
