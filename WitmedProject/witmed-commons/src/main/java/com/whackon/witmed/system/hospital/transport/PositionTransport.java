package com.whackon.witmed.system.hospital.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.pojo.vo.PositionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 职务信息传输层接口</b>
 *
 * @author zyuan
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
//@RequestMapping("/system/hostpital/position/trans")
public interface PositionTransport {
	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/page")
	PageVO<PositionVO> getPage(@RequestBody QueryPageVO<PositionVO> queryPageVO) throws Exception;

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/list")
	List<PositionVO> getList(@RequestBody PositionVO queryVO) throws Exception;

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/id")
	PositionVO getById(@RequestParam Long id) throws Exception;

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/code")
	PositionVO getByCode(@RequestParam String code) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/save")
	boolean save(@RequestBody PositionVO saveVO) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/hostpital/position/trans/update")
	boolean update(@RequestBody PositionVO updateVO) throws Exception;
}
