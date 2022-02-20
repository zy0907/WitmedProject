package com.whackon.witmed.system.hospital.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.pojo.vo.PositionVO;
import com.whackon.witmed.system.hospital.service.PositionService;
import com.whackon.witmed.system.hospital.transport.PositionTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@RestController("positionTransport")
@RequestMapping("/system/hospital/position/trans")
public class PositionTransportImpl implements PositionTransport {
	@Resource(name = "positionService")
	private PositionService positionService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<PositionVO> getPage(@RequestBody QueryPageVO<PositionVO> queryPageVO) throws Exception {
		return positionService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<PositionVO> getList(@RequestBody PositionVO queryVO) throws Exception {
		return positionService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public PositionVO getById(@RequestParam Long id) throws Exception {
		return positionService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public PositionVO getByCode(@RequestParam String code) throws Exception {
		return positionService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody PositionVO saveVO) throws Exception {
		return positionService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody PositionVO updateVO) throws Exception {
		return positionService.update(updateVO);
	}
}
