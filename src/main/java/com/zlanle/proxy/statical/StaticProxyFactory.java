package com.zlanle.proxy.statical;

import com.zlanle.proxy.statical.demo2.HouseMaster;
import  com.zlanle.proxy.statical.demo2.MiddleCompany;

public class StaticProxyFactory {
	
	public static void main(String[] args) {
		
//		Father father = new Father(new Son());
//		father.findLove();
//		father.buyBooks();
		
		MiddleCompany middleCompany = new MiddleCompany(new HouseMaster());
		middleCompany.rent();
	}
	
}
