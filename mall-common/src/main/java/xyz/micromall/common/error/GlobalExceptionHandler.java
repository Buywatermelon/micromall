package xyz.micromall.common.error;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.micromall.common.api.ApiBaseResponse;
import xyz.micromall.common.api.ResultCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Log log = LogFactory.get();

    @ExceptionHandler(BlockException.class)
    public String processBlockException(BlockException e) {
        log.error("触发服务熔断：{}", Level.ERROR);
        return "111111";
    }

    @ExceptionHandler(InternalApiException.class)
    public ApiBaseResponse processMicroServiceException(InternalApiException e) {
        log.error("微服务间调用异常: {}", Level.ERROR);
        return ApiBaseResponse
                .builder()
                .code(ResultCode.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(ApiException.class)
    public ApiBaseResponse handleError(Throwable e) {
        log.error("聚合服务对外异常: {}", Level.ERROR);
        return ApiBaseResponse
                .builder()
                .code(ResultCode.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
    }
}
