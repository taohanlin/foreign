package com.foreign.common.constant;

public class WdzjConstant {

	/**
	 * @Description: 投标状态*1：全部通过 2：部分通过 注意： 平台没有这个字段的默认为1
	 */
	public static class STATUS {

		public static final int ALL_THROUGH = 1;

		public static final int PART_THROUGH = 2;
	}

	/**
	 * @Description: 标识手动或自动投标 0：手动 1：自动 注意:平台没有这个字段的默认为0
	 */
	public static class BORROW_TYPE {

		public static final int AUTOMATIC_BID = 1;

		public static final int MANUAL_BID = 0;

	}
	
	/**
	 * @Description: borrow_type：标的类型：1:散标 2:预约标 3:计划标
	 */
     public static class BIAOTYPE{

		public static final short SANBIAO = 1;
     }
	
}
