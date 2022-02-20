package com.whackon.witmed.system.dictionary.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.dictionary.pojo.vo.IdentityVO;
import com.whackon.witmed.system.dictionary.service.IdentityService;
import com.whackon.witmed.system.dictionary.transport.IdentityTransport;
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
@RestController("identityTransport")
@RequestMapping("/system/dictionary/identity/trans")
public class IdentityTransportImpl implements IdentityTransport {
	@Resource(name = "identityService")
	private IdentityService identityService;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<IdentityVO> getPage(@RequestBody QueryPageVO<IdentityVO> queryPageVO) throws Exception {
		return identityService.getPage(queryPageVO);
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<IdentityVO> getList(@RequestBody IdentityVO queryVO) throws Exception {
		return identityService.getList(queryVO);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public IdentityVO getById(@RequestParam Long id) throws Exception {
		return identityService.getById(id);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public IdentityVO getByCode(@RequestParam String code) throws Exception {
		return identityService.getByCode(code);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody IdentityVO saveVO) throws Exception {
		return identityService.save(saveVO);
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody IdentityVO updateVO) throws Exception {
		return identityService.update(updateVO);
	}
}
