package zh.xyz.tools.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

/**
 * @Author iccry
 * @Description
 * @date 2024/3/31 15:27
 */
@Getter
@Setter
@ToString
public class LogInfo {

    /**
     * 操作者
     */
    private OperatorInfo operator;

    /**
     * 请求IP
     */
    private String requestIp;

    /**
     * 触发时间
     */
    private DateTime requestTime;

    /**
     * 请求描述
     */
    private String description;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 请求路径
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 响应IP
     */
    private String responseIp;
    /**
     * 响应时间
     */
    private DateTime responseTime;

    /**
     * 响应信息
     */
    private String responseMsg;

    private String status;

    private String errorMsg;
}
