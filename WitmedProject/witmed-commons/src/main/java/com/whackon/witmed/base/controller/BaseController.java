package com.whackon.witmed.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>项目基础框架 - 基础控制层类</b>
 * <p>
 *     基础控制层类依赖注入了如下属性：
 *     1、HttpServletRequest<br/>
 *     2、HttpServletResponse<br/>
 *     3、HttpSession<br/>
 *     <b>所有项目功能控制层类都必须继承于本基础控制层类</b>
 * </p>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}
