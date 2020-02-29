package com.iwhalecloud.test01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1. 从activiti的act_ge_bytearray表读取两个资源文件
 * 2. 保存到一个指定的文件夹
 * 真实应用场景: 用户想查看这个请假流程有哪些步骤想走
 * IO流转换: 使用commons-io包可以轻松解决IO操作
 */
public class QueryBpmnFile {
    public static void main(String[] args) throws IOException {
        // 1. 获取ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获取RepositoryService对象
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        // 3. 得到查询器: ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 4. 设置查询条件
        processDefinitionQuery.processDefinitionKey("myHoliday");
        // 5. 就可以执行查询操作
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        // 6. 通过流程定义信息, 得到部署Id
        String deploymentId = processDefinition.getDeploymentId();
        // 7. 通过repositoryService的方法, 实现读取图片信息以及bpmn文件信息- 输入流
        // getResourceAsStream方法的第一个参数是部署ID, 第二个参数是代表资源名称
        // processDefinition.getDiagramResourceName() - 获取png图片名称
        // processDefinition.getResourceName() - 获取bpmn文件的名称
        InputStream diagramIS = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIS = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        // 8. 构造输出流
        FileOutputStream diagramOS = new FileOutputStream("D:/activiti/" + processDefinition.getDiagramResourceName());
        FileOutputStream bpmnOS = new FileOutputStream("D:/activiti/" + processDefinition.getResourceName());
        // 9. 输入流 输出流的转换 commons-io
        IOUtils.copy(diagramIS, diagramOS);
        IOUtils.copy(bpmnIS, bpmnOS);

        // 10. 关闭流
        IOUtils.closeQuietly(diagramOS);
        IOUtils.closeQuietly(bpmnOS);
        IOUtils.closeQuietly(diagramIS);
        IOUtils.closeQuietly(bpmnIS);



    }

}
