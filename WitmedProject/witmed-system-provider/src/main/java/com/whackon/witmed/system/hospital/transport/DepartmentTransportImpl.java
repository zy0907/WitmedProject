package com.whackon.witmed.system.hospital.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.pojo.vo.DepartmentVO;
import com.whackon.witmed.system.hospital.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息传输层接口实现类</b>
 *
 * @author zyuan
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@RestController("departmentTransport")
@RequestMapping("/system/hospital/department/trans")
public class DepartmentTransportImpl implements DepartmentTransport {
	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DepartmentVO> getPage(@RequestBody QueryPageVO<DepartmentVO> queryPageVO) throws Exception {
		return departmentService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<DepartmentVO> getList(@RequestBody DepartmentVO queryVO) throws Exception {
		return departmentService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public DepartmentVO getById(@RequestParam Long id) throws Exception {
		return departmentService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public DepartmentVO getByCode(@RequestParam String code) throws Exception {
		return departmentService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody DepartmentVO saveVO) throws Exception {
		return departmentService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody DepartmentVO updateVO) throws Exception {
		return departmentService.update(updateVO);
	}
}
