package log.model;

import java.io.Serializable;

/**
 * 日志模板文件
 */
public class LogModel implements Serializable {
    /**
     * 日志编号
     */
    private long logId;

    /**
     * 操作人员
     */
    private String OperateUser;

    /**
     * 操作时间，以yyyy-MM-dd HH:mm:ss的形式记录
     */
    private String OperateTime;

    /**
     * 日志内容
     */
    private String logContent;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getOperateUser() {
        return OperateUser;
    }

    public void setOperateUser(String operateUser) {
        OperateUser = operateUser;
    }

    public String getOperateTime() {
        return OperateTime;
    }

    public void setOperateTime(String operateTime) {
        OperateTime = operateTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "logId=" + logId +
                ", OperateUser='" + OperateUser + '\'' +
                ", OperateTime='" + OperateTime + '\'' +
                ", logContent='" + logContent + '\'' +
                '}';
    }
}
