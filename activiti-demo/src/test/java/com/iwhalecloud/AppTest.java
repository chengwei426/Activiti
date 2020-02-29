package com.iwhalecloud;

import static org.junit.Assert.assertTrue;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

/**
 * 测试类: 测试activiti所需要的25张表的生成
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testGenTable()
    {
        //创建ProcessEngineConfiguration
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
        // 执行创建25张表
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);

        HistoryService historyService = processEngine.getHistoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
    }

    @Test
    public void GenTableTest()
    {
        // 前提条件: 1. activiti配置文件的名称必须是activiti.cfg.xml
        //          2. bean的id必须是processEngineConfiguration
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();


    }
}
