package com.zlanle.proxy.statical.demo1;

public class Father implements Person {
	
	private Son son;
	
	public Father(Son son) {
		this.son = son;
	}

	public void findLove() {
		System.out.println("父亲为儿子物色对象");
		this.son.findLove();
		System.out.println("双方父母同意并确立关系");
	}

	public void buyBooks() {
		System.out.println("父亲帮助儿子寻找需要的书");
		this.son.buyBooks();
		System.out.println("父亲找到并买给儿子");
	}

}
