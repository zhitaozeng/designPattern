package log.api.impl;

import log.api.LogDBOperate;
import log.model.LogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志数据库操作接口的实现类
 * 这里不去做具体的实现，只是测试使用
 */
public class LogDBOperateImpl implements LogDBOperate {
    @Override
    public void createLog(LogModel logModel) {
        System.out.println("增加一个日志文件, " + logModel);
    }

    @Override
    public void updateLog(LogModel logModel) {
        System.out.println("更新一个日志文件, " + logModel);
    }

    @Override
    public void removeLog(LogModel logModel) {
        System.out.println("删除一个日志文件, " + logModel);
    }

    @Override
    public List<LogModel> getAllLog() {
        System.out.println("返回所有的日志文件");
        return new ArrayList<>();
    }
}
