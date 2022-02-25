package com.google.s1.util;

public class Pager {

	private Long perPage;
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;
	
	public void makeRow() {
	this.startRow=(this.getPage()-1)*this.getPerPage()+1;
	this.lastRow= this.getPerPage()*this.getPage();
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage= totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
			
		Long perBlock=10L;
		
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		Long curBlock=this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		}
		
		
	}
	
	
	
	
	public Long getPerPage() {
		if(this.perPage==null||this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
