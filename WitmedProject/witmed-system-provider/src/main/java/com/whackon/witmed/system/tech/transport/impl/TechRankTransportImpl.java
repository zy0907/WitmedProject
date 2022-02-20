package com.whackon.witmed.system.tech.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.pojo.vo.TechRankVO;
import com.whackon.witmed.system.tech.service.TechRankService;
import com.whackon.witmed.system.tech.transport.TechRankTransport;
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
@RestController("techRankTransport")
@RequestMapping("/system/tech/techRank/trans")
public class TechRankTransportImpl implements TechRankTransport {
	@Resource(name = "techRankService")
	private TechRankService techRankService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<TechRankVO> getPage(@RequestBody QueryPageVO<TechRankVO> queryPageVO) throws Exception {
		return techRankService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<TechRankVO> getList(@RequestBody TechRankVO queryVO) throws Exception {
		return techRankService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public TechRankVO getById(@RequestParam Long id) throws Exception {
		return techRankService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public TechRankVO getByCode(@RequestParam String code) throws Exception {
		return techRankService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody TechRankVO saveVO) throws Exception {
		return techRankService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody TechRankVO updateVO) throws Exception {
		return techRankService.update(updateVO);
	}
}
