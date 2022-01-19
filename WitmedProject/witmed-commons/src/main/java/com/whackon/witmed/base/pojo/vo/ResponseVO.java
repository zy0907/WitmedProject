package com.whackon.witmed.base.pojo.vo;

import com.whackon.witmed.base.pojo.enums.ResponseCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * <b>项目基础框架 - 系统响应视图信息</b>
 * <p>
 *     系统响应视图信息设置了如下属性：
 *     1、code：系统响应编码<br/>
 *     2、message：系统响应信息<br/>
 *     3、data：系统响应数据<br/>
 *     <p>所有返回前端数据都必须以该系统响应视图信息返回</p>
 * </p>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ResponseVO implements Serializable {
	private static final long serialVersionUID = -1243700449847575050L;
	private Integer code;                       // 系统响应编码
	private String message;                     // 系统响应信息
	private Object data;                        // 系统响应数据

	public ResponseVO(ResponseCodeEnum responseCodeEnum, String message, Object data) {
		this.code = responseCodeEnum.getCode();
		this.message = message;
		this.data = data;
	}

	/**
	 * <b>获得系统业务处理成功，系统响应成功视图信息</b>
	 * @param message
	 * @return
	 */
	public static ResponseVO successResponseVO(String message) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS, message, "");
	}

	/**
	 * <b>获得系统业务处理成功，系统响应成功视图信息</b>
	 * @param message
	 * @param data
	 * @return
	 */
	public static ResponseVO successResponseVO(String message, Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS, message, data);
	}

	/**
	 * <b>获得用户未进行系统认证视图信息</b>
	 * @return
	 */
	public static ResponseVO unAuthResponseVO() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_UNAUTH, ResponseCodeEnum.RESPONSE_CODE_UNAUTH.getRemark(), "");
	}

	/**
	 * <b>获得系统业务处理错误，系统响应成功视图信息</b>
	 * @param errorMessage
	 * @return
	 */
	public static ResponseVO errorResponseVO(String errorMessage) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_ERROR, errorMessage, "");
	}

	/**
	 * <b>获得系统响应异常视图信息</b>
	 * @param exception
	 * @return
	 */
	public static ResponseVO exceptionResponseVO(Exception exception) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION, exception.getMessage(), exception);
	}
}
