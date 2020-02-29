package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 删除流程定义信息
 *  涉及到的表: act_ge_bytearray act_re_deployment act_re_procdef
 */
public class DeleteProcessDefine {
    /**
     * 注意事项:
     *  1. 当我们正在执行的这一套流程没有完全审批结束时候, 此时如果要删除流程定义信息就会失败
     *  2. 如果需要强制删除, 通过级联删除操作repositoryService.deleteDeployment("12501", true);
     *      true会先删除没有完成的流程节点, 最后就可以删除流程定义信息
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取processEngin对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 执行删除流程定义, 参数代表流程部署的id
        repositoryService.deleteDeployment("12501", true);

    }



}
