package com.iwhalecloud.test01;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 历史数据的查询
 */
public class HistoryQuery {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        // 获取historicActivityInstanceQuery对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        // 设置流程实例的ID
        historicActivityInstanceQuery.processInstanceId("2501");

        // 执行查询
        List<HistoricActivityInstance> list = historicActivityInstanceQuery
                .orderByHistoricActivityInstanceStartTime().asc()
                .list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getProcessInstanceId());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println("..................................");
        }

    }
}
