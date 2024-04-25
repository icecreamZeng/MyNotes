package zh.xyz.tools.log.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import zh.xyz.tools.log.LogInfo;
import zh.xyz.tools.log.OperatorInfo;
import zh.xyz.tools.log.annotation.OperationLog;

/**
 * @Author iccry.zeng
 * @Description 日志切面，记录 IP、时间、操作者、参数、行为、结果
 * @Date Create in 2024/3/31 15:04
 */
@Aspect
@Component
public class OperationLogAspect {

    @Pointcut(value = "@annotation(zh.xyz.tools.log.annotation.OperationLog)")
    public void pointcut() {}

    @Around(value = "pointcut()&&@annotation(operationLog)")
    public Object around(ProceedingJoinPoint joinPoint, OperationLog operationLog){
        Object result = null;
        LogInfo logInfo = new LogInfo();
        OperatorInfo operatorInfo = getOperatorInfo(joinPoint);
        logInfo.setOperator(operatorInfo);
        logInfo.setRequestTime(DateTime.now());
        logInfo.setDescription(operationLog.description());

        try {
            result = joinPoint.proceed();

            logInfo.setResponseTime(DateTime.now());
            logInfo.setStatus("success");
            logInfo.setResponseMsg(JSON.toJSONString(result));
        } catch (Throwable e) {
            logInfo.setStatus("failed");
            logInfo.setResponseTime(DateTime.now());
            logInfo.setErrorMsg(e.getMessage());
            throw new RuntimeException(e);
        }
        saveLogInfo(logInfo);
        return result;
    }

    private OperatorInfo getOperatorInfo(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        OperatorInfo operatorInfo = new OperatorInfo();
        operatorInfo.setName(signature.getName());
        return operatorInfo;
    }

    /**
     * @description
     * @param logInfo 需要实例化的操作日志
     * 注意耗时，不要阻塞请求
     * @author iccry
     * @date 2024/3/31 15:34
     */
    private void saveLogInfo(LogInfo logInfo) {
    }
}
