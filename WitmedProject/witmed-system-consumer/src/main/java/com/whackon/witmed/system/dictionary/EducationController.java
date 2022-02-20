package com.whackon.witmed.system.dictionary;

import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.dictionary.pojo.vo.EducationVO;
import com.whackon.witmed.system.dictionary.transport.EducationTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历控制层类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@RestController("educationController")
@RequestMapping("/system/dictionary/education")
public class EducationController extends BaseController {
	@Autowired
	private EducationTransport educationTransport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>分页查询信息</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                            @RequestBody EducationVO queryVO) throws Exception {
		// 根据查询视图、分页信息创建查询分页视图 QueryPageVO
		QueryPageVO<EducationVO> queryPageVO = new QueryPageVO<>(queryVO, pageNum, pageSize);
		// 进行分页查询获得 PageVO 对象
		PageVO<EducationVO> pageVO = educationTransport.getPage(queryPageVO);
		return ResponseVO.successResponseVO("分页查询成功", pageVO);
	}

	/**
	 * <b>列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody EducationVO queryVO) throws Exception {
		// 进行列表查询，获得视图列表
		List<EducationVO> voList = educationTransport.getList(queryVO);
		return ResponseVO.successResponseVO("列表查询成功", voList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		// 查询获得结果
		EducationVO resultVO = educationTransport.getById(id);
		return ResponseVO.successResponseVO("查询成功", resultVO);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		// 查询获得结果
		EducationVO resultVO = educationTransport.getByCode(code);
		return ResponseVO.successResponseVO("结果查询成功", resultVO);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @param token
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save/{token}")
	public ResponseVO save(@RequestBody@Validated EducationVO saveVO, @PathVariable("token") String token,
	                       BindingResult bindingResult) throws Exception {
		// 校验此时用户是否进行登录，首先根据用户所提交的 Token，从 Redis 中获得用户信息
		AdminVO loginAdmin = (AdminVO) redisUtil.findFromRedis(token, AdminVO.class);
		if (loginAdmin != null) {
			// 判断保存信息是否提交有效
			if (!bindingResult.hasErrors()) {
				// 校验通过，校验编码的唯一性
				// 通过编码查询信息
				if (educationTransport.getByCode(saveVO.getCode()) == null) {
					// 该编码未被占用，则可以进行保存
					if (educationTransport.save(saveVO)) {
						// 保存成功
						return ResponseVO.successResponseVO("保存成功");
					}
					return ResponseVO.errorResponseVO("保存失败");
				}
			}
			return ResponseVO.errorResponseVO("未填写有效信息");
		}
		return ResponseVO.unAuthResponseVO();
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @param token
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public ResponseVO update(@RequestBody@Validated EducationVO updateVO, @PathVariable("token") String token,
	                         BindingResult bindingResult) throws Exception {
		// 校验此时用户是否进行登录，首先根据用户所提交的 Token，从 Redis 中获得用户信息
		AdminVO loginAdmin = (AdminVO) redisUtil.findFromRedis(token, AdminVO.class);
		if (loginAdmin != null) {
			// 判断保存信息是否提交有效
			if (!bindingResult.hasErrors()) {
				// 校验通过，校验编码的唯一性
				// 通过编码查询信息
				EducationVO validationVO = educationTransport.getByCode(updateVO.getCode());
				if (validationVO == null || validationVO.getId().equals(updateVO.getId())) {
					// 该编码未被占用，则可以进行保存
					if (educationTransport.update(updateVO)) {
						// 保存成功
						return ResponseVO.successResponseVO("保存成功");
					}
					return ResponseVO.errorResponseVO("保存失败");
				}
			}
			return ResponseVO.errorResponseVO("未填写有效信息");
		}
		return ResponseVO.unAuthResponseVO();
	}
}
