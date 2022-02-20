package com.whackon.witmed.base.exception;

import com.whackon.witmed.base.pojo.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

/**
 * <b>项目基础框架 - 项目全局异常处理类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/14
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	// 获得 Logger 对象，用于记录日志
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * <b>全局异常信息处理</b>
	 * @param exception
	 * @return
	 */
	@ExceptionHandler
	public ResponseVO globalExceptionHandle(Exception exception) {
		// 记录日志信息
		logger.error(exception.getMessage() + " : " + new Date(), exception);
		// 返回错误异常信息
		return ResponseVO.exceptionResponseVO(exception);
	}
}
