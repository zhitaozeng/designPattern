package newversion;

import log.api.LogDBOperate;
import log.api.LogFileOperate;
import log.api.impl.LogDBOperateImpl;
import log.api.impl.LogFileOperateImpl;
import log.model.LogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 新版本的日志使用的客户端
 * 使用的是日志的DB操作的接口
 */
public class Client1 {
    public static void main(String[] args){

        LogModel logModel = new LogModel();
        logModel.setLogId(001);
        logModel.setOperateUser("admin");
        logModel.setLogContent("这是一个测试的日志");
        logModel.setOperateTime("2020-04-07 23:53:20");

        List<LogModel> logModels = new ArrayList<>();
        logModels.add(logModel);

        LogDBOperate logDBOperate = new LogDBOperateImpl();
        //创建日志
        logDBOperate.createLog(logModel);
        //更新日志
        logModel.setLogContent("修改内容");
        logDBOperate.updateLog(logModel);
        //修改日志
        logDBOperate.removeLog(logModel);
        //获取所有的日志文件
        List<LogModel> allLog = logDBOperate.getAllLog();

    }
}
