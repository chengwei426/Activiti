package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 查询流程定义信息
 */
public class QueryProcessDefine {
    public static void main(String[] args) {
        // 1. 获取processEngin对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 得到ProcessDefinitionQuery对象
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        // 4. 设置条件, 并查询出当前所有的流程定义
        List<ProcessDefinition> processDefinitionList = query.processDefinitionKey("myHoliday")
                .orderByProcessDefinitionVersion()
                .asc().list();


        // 5. 输出流程定义信息
        for (ProcessDefinition processDefinition : processDefinitionList) {
            System.out.println(processDefinition.getDeploymentId());
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getKey());
            System.out.println(processDefinition.getVersion());
        }


    }



}
