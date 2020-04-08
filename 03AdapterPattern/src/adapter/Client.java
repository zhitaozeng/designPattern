package adapter;

import log.api.LogDBOperate;
import log.api.LogFileOperate;
import log.api.impl.LogDBOperateImpl;
import log.api.impl.LogFileOperateImpl;
import log.model.LogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 双向适配器的简单使用demo
 */
public class Client {
    public static void main(String[] args){
        //首先准备要测试的数据
        LogModel logModel = new LogModel();
        logModel.setLogId(001);
        logModel.setOperateUser("admin");
        logModel.setLogContent("这是一个测试的日志");
        logModel.setOperateTime("2020-04-07 23:53:20");

        List<LogModel> logModels = new ArrayList<>();
        logModels.add(logModel);

        //准备需要适配的两个对象
        LogFileOperate logFileOperate = new LogFileOperateImpl();
        LogDBOperate logDBOperate = new LogDBOperateImpl();

        //创建经过适配后的接口对象
        LogFileOperate fileOperate = new TwoDirectAdapter(logDBOperate, logFileOperate);
        LogDBOperate dbOperate = new TwoDirectAdapter(logDBOperate, logFileOperate);

        //首先测试使用被适配过的日志文件操作接口
        fileOperate.writeLogFile(logModels);

        List<LogModel> logModelList = fileOperate.readLogFile();
        for (LogModel log : logModelList){
            System.out.println(log);
        }

        //再测试使用被适配过的日志数据库操作接口
        //创建日志
        dbOperate.createLog(logModel);
        //更新日志
        logModel.setLogContent("修改内容");
        dbOperate.updateLog(logModel);
        //修改日志
        dbOperate.removeLog(logModel);
        //获取所有的日志文件
        List<LogModel> allLog = dbOperate.getAllLog();
    }
}
