package com.zlanle.proxy.statical.demo2;

public class MiddleCompany implements House {
	
	private HouseMaster houseMaster;

	public MiddleCompany(HouseMaster houseMaster) {
		super();
		this.houseMaster = houseMaster;
	}

	public void rent() {
		System.out.println("中介公司找租客");
		this.houseMaster.rent();
		System.out.println("中介公司找到租客，并出租。");
	}

}
