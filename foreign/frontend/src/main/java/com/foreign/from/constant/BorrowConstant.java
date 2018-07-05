package com.foreign.from.constant;

public class BorrowConstant {

	/**
	 * @Description: 分页大小参照
	 */
	public static class LIMIT {

		public static final int DEFAULT_PAGE = 1;

		public static final int DEFAULT_LIMIT = 15;
	}

	/**
	 * @Description:状态 3、代售 4、开始募集 5、已满标 6、放款中 7、计息中 9、已结清 10、流标 11、部分满标 12、退出中
	 *                 13、放款成功
	 */
	public static class STATUS {

		public static final int[] RAISE_SUCCESS = { 5, 7 };

	}

	/**
	 * @Description: 标的进度 只传进度100的标（若是未满截标，需要改为100
	 */
	public static class SCHEDULE {
		public static final String FULL_STANDARD = "100.00";
	}

	/**
	 * @Description: 标的类型 抵押标 ，质押标，信用标
	 */
	public static class TYPE_STANDARD {

		public static final String CREDIT_MARK = "信用标";

		public static final String TRANSFER_CREDITOR = "债权转让标";
	}

	/**
	 * 是否机构借款 0:否,1:是
	 */
	public static class TYPE {

		public static final int ORGANIZATION_BORROW = 0;

		public static final int OTHER_BORROW = 1;
	}

	/**
	 * 投资期限单位，都以天为单位返回给网贷之家
	 */
	public static class UNIT {

		public static final String DAY_UNIT = "天";
	}

	/**
	 * 拼接url到标的详情页
	 */
	public static class LOANURL {

		public static final String URL = "https://hapi.chinazyjr.com/v1/api/product/productDetail?client=2&platform=HLW&platform=";
	}

	/**
	 * 还款方式都是默认给2：每月等额本息
	 */
	public static class RETURNTUPR {

		public static final int REPAYTYPE = 2;
	}
}
