package com.whackon.witmed.system.tech.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.pojo.vo.TechCategoryVO;
import com.whackon.witmed.system.tech.service.TechCategoryService;
import com.whackon.witmed.system.tech.transport.TechCategoryTransport;
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
@RestController("techCategoryTransport")
@RequestMapping("/system/tech/techCategory/trans")
public class TechCategoryTransportImpl implements TechCategoryTransport {
	@Resource(name = "techCategoryService")
	private TechCategoryService techCategoryService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<TechCategoryVO> getPage(@RequestBody QueryPageVO<TechCategoryVO> queryPageVO) throws Exception {
		return techCategoryService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<TechCategoryVO> getList(@RequestBody TechCategoryVO queryVO) throws Exception {
		return techCategoryService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public TechCategoryVO getById(@RequestParam Long id) throws Exception {
		return techCategoryService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public TechCategoryVO getByCode(@RequestParam String code) throws Exception {
		return techCategoryService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody TechCategoryVO saveVO) throws Exception {
		return techCategoryService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody TechCategoryVO updateVO) throws Exception {
		return techCategoryService.update(updateVO);
	}
}
