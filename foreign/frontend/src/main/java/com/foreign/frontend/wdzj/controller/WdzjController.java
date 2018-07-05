package com.foreign.frontend.wdzj.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foreign.business.service.BorrowService;
import com.foreign.business.service.OrderInvestService;
import com.foreign.common.constant.WdzjConstant;
import com.foreign.common.util.DateUtil;
import com.foreign.common.util.JSONUtil;
import com.foreign.common.util.ListUtil;
import com.foreign.common.util.StringUtil;
import com.foreign.common.wdzj.bean.LoanMarkModel;
import com.foreign.common.wdzj.bean.SingleLabel;
import com.foreign.from.constant.BorrowConstant;

@RestController
@RequestMapping("api/wdzj/")
public class WdzjController {

	private static final Logger LOG = LoggerFactory.getLogger(WdzjController.class);

	@Autowired
	private BorrowService borrowService;

	@Autowired
	private OrderInvestService orderInvestService;

	@RequestMapping(value = "listBorrow", method = RequestMethod.GET)
	public String getBorrowList(String date, Integer page, Integer pageSize) {
		LOG.info("网贷之家调用请求携带参数date{},page{},pageSize{}", date, page, pageSize);

		if (StringUtil.isEmpty(date)) {
			date = DateUtil.toString(new Date(), DateUtil.ymdDash.get());
		}

		if (page == null) {
			page = BorrowConstant.LIMIT.DEFAULT_PAGE;
		}

		if (pageSize == null) {
			pageSize = BorrowConstant.LIMIT.DEFAULT_LIMIT;
		}

		// 总金额
		BigDecimal sumAmount = borrowService.getSumAmount(date, WdzjConstant.BIAOTYPE.SANBIAO);

		// 当日借款标信息处理
		List<LoanMarkModel> loanBorrowInfos = borrowService.getLoanBorrowInfos(WdzjConstant.BIAOTYPE.SANBIAO, date, (page - 1) * pageSize, pageSize);
		Iterator<LoanMarkModel> infos = loanBorrowInfos.iterator();
		Date successDate = DateUtil.toDate(date + " 00:00:00", DateUtil.ymdHmsDash.get());
		while (infos.hasNext()) {
			LoanMarkModel info = infos.next();
			List<SingleLabel> investerInfos = orderInvestService.getInvesterInfos(info.getBorrowNo());
			if (!ListUtil.isEmpty(investerInfos)) {
				Date addDate = DateUtil.toDate(investerInfos.get(0).getAddDate(), DateUtil.ymdHmsDash.get());
				if (successDate.before(addDate)) {
					info.setType(BorrowConstant.TYPE_STANDARD.TRANSFER_CREDITOR);
				}
				info.setSubscribes(investerInfos);
			} else {
				// 过滤掉没有投资人信息的合同金额
				sumAmount = sumAmount.subtract(new BigDecimal(info.getAmount()));
				infos.remove();
			}

		}
		Map<String, Object> wdzjMap = new HashMap<String, Object>();

		// 计算总页数
		int totalPage = (loanBorrowInfos.size() + pageSize - 1) / pageSize;

		wdzjMap.put("totalAmount", sumAmount);
		wdzjMap.put("totalPage", totalPage + "");
		wdzjMap.put("currentPage", page + "");
		wdzjMap.put("totalCount", loanBorrowInfos.size());
		wdzjMap.put("borrowList", loanBorrowInfos);

		LOG.info("网贷之家请求成功：", JSONUtil.toJSONString(wdzjMap));
		return JSONUtil.toJSONString(wdzjMap);

	}

}
