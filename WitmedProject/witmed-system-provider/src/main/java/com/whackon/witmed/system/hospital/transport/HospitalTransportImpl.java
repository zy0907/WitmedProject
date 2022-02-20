package com.whackon.witmed.system.hospital.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.pojo.vo.HospitalVO;
import com.whackon.witmed.system.hospital.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@RestController("hospitalTransport")
@RequestMapping("/system/hospital/hospital/trans")
public class HospitalTransportImpl implements HospitalTransport {
	@Resource(name = "hospitalService")
	private HospitalService hospitalService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<HospitalVO> getPage(@RequestBody QueryPageVO<HospitalVO> queryPageVO) throws Exception {
		return hospitalService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<HospitalVO> getList(@RequestBody HospitalVO queryVO) throws Exception {
		return hospitalService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public HospitalVO getById(@RequestParam Long id) throws Exception {
		return hospitalService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public HospitalVO getByCode(@RequestParam String code) throws Exception {
		return hospitalService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody HospitalVO saveVO) throws Exception {
		return hospitalService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody HospitalVO updateVO) throws Exception {
		return hospitalService.update(updateVO);
	}
}
