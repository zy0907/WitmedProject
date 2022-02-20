package com.whackon.witmed.system.tech.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.pojo.vo.TechTitleVO;
import com.whackon.witmed.system.tech.service.TechTitleService;
import com.whackon.witmed.system.tech.transport.TechTitleTransport;
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
@RestController("techTitleTransport")
@RequestMapping("/system/hospital/techTitle/trans")
public class TechTitleTransportImpl implements TechTitleTransport {
	@Resource(name = "techTitleService")
	private TechTitleService techTitleService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<TechTitleVO> getPage(@RequestBody QueryPageVO<TechTitleVO> queryPageVO) throws Exception {
		return techTitleService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<TechTitleVO> getList(@RequestBody TechTitleVO queryVO) throws Exception {
		return techTitleService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public TechTitleVO getById(@RequestParam Long id) throws Exception {
		return techTitleService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public TechTitleVO getByCode(@RequestParam String code) throws Exception {
		return techTitleService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody TechTitleVO saveVO) throws Exception {
		return techTitleService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody TechTitleVO updateVO) throws Exception {
		return techTitleService.update(updateVO);
	}
}
