package com.whackon.witmed.system.hospital;

import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.hospital.pojo.vo.HospitalVO;
import com.whackon.witmed.system.hospital.transport.HospitalTransport;
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
@RestController("hospitalController")
@RequestMapping("/system/hospital/hospital")
public class HospitalController extends BaseController {
	@Autowired
	private HospitalTransport hospitalTransport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>分页查询信息</b>
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                            @RequestBody HospitalVO queryVO) throws Exception {
		// 根据查询视图、分页信息创建查询分页视图 QueryPageVO
		QueryPageVO<HospitalVO> queryPageVO = new QueryPageVO<>(queryVO, pageNum, pageSize);
		// 进行分页查询获得 PageVO 对象
		PageVO<HospitalVO> pageVO = hospitalTransport.getPage(queryPageVO);
		return ResponseVO.successResponseVO("分页查询成功", pageVO);
	}

	/**
	 * <b>列表查询</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody HospitalVO queryVO) throws Exception {
		// 进行列表查询，获得视图列表
		List<HospitalVO> voList = hospitalTransport.getList(queryVO);
		return ResponseVO.successResponseVO("列表查询成功", voList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		// 查询获得结果
		HospitalVO resultVO = hospitalTransport.getById(id);
		return ResponseVO.successResponseVO("查询成功", resultVO);
	}
}

