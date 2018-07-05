package com.foreign.common.constant;

public class WdtyConstant {

	/**
	 * @Description: 平台中文名称 HLW ="好利网"
	 */
	public static class PLATNAME {

		public static final String HLW = "好利网";

	}

	/**
	 * @Description: 拼接标的url地址
	 */
	public static class URLLINK {

		public static final String WDTYURL = "https://hapi.chinazyjr.com/v1/api/product/productDetail?client=2&platform=HLW&platform=";
	}

	
	/**
	 * @Description: 1:信用标-个人信贷 2:信用标-企业信贷
	 */
	public static class NUM {

		public static int PERSONAL = 1;

		public static int COMPANY = 2;
	}

	/**
	 * 
	 * @Description: 期限类型:0 代表天,1 代表月.
	 */
	public static class PTYPE {

		public static int DAY = 0;
	}

	/**
	 * 
	 * @Description: 0 代表其他;1 按月等额本息还款;2按月付息,到期还本; 3
	 *               按天计息,一次性还本付息;4,按月计息,一次性还本付息; 5 按季分期还款;6 为等额本金,按月还本金;7 先息期本;
	 *               8 按季付息,到期还本;9 按半年付息,到期还本; 10 按年付息，到期还本.
	 */
	public static class PAYWAY {

		public static int OTHER = 0;
	}
	/**
	 * 
	 * @Description: 0.1：信用标-个人信贷 PERSON 0.2：信用标-企业信贷 BUSINESS 0.3：信用标-消费金融
	 *               CONSUMER 0.4：信用标-农村金融 RURAL 0.5：信用标-供应链金融 SUPPLYCHAIN
	 */
	public static enum LABLETYPE {
		PERSON(0.1f, NUM.PERSONAL), BUSINESS(0.2f, NUM.COMPANY);
	    // 成员变量  
		private float name;
	    private int index;  
	    // 构造方法  
	    private LABLETYPE(Float name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }  
	    // 普通方法  
		public static Float getName(int index) {
			for (LABLETYPE lableType : LABLETYPE.values()) {
				if (lableType.getIndex() == index) {
					return lableType.getName();
	            }  
	        }  
	        return null;  
	    }  
	    // get set 方法  
	    public Float getName() {  
	        return name;  
	    }  

		public void setName(Float name) {
	        this.name = name;  
	    }  
	    public int getIndex() {  
	        return index;  
	    }  
	    public void setIndex(int index) {  
	        this.index = index;  
	    }  
	} 
	
	/**
	 * @Description: 请求参数index=0，对应我们数据库status=4;index=1，对应我们数据库status=9;
	 */
	public static enum BIDSTATE {
		UNFINISHED(4, 0), ISFINISHED(9, 1);
	    // 成员变量  
		private Integer status;
	    private Integer index;  
	    // 构造方法  
		private BIDSTATE(Integer status, Integer index) {
			this.status = status;
	        this.index = index;  
	    }  
	    // 普通方法  
		public static Integer getStatus(int index) {
			for (BIDSTATE bidState : BIDSTATE.values()) {
				if (bidState.getIndex() == index) {
					return bidState.getStatus();
	            }  
	        }  
	        return null;  
	    }  
	    // get set 方法  
		public Integer getStatus() {
			return status;
	    }  

		public void setName(Integer status) {
			this.status = status;
	    }  
	    public Integer getIndex() {  
	        return index;  
	    }  
	    public void setIndex(Integer index) {  
	        this.index = index;  
	    }  
	} 

}
