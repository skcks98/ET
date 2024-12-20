package edu.kh.project.common.util;

/*
 * Pagination 뜻 : 목록을 일정 페이지로 분할 해서
 * 				   원하는 페이지를 볼 수 있게 하는 것
 * 				   == 페이징 처리
 * 
 * Pagination 객체 : 페이징 처리에 필요한 값을 모아두고, 계산하는 객체
 * 
 * */

public class Pagination {

	private int currentPage;		// 현재 페이지 번호
	private int listCount;			// 전체 게시글 수
	
	private int limit = 10;			// 한 페이지 목록에 보여지는 게시글 수
	private int pageSize = 10;		// 보여질 페이지 번호 개수
	
	// 가장 첫페이지는 당연히 1페이지 -> 그래서 minPage 는 따로 없음
	private int maxPage;			// 마지막 페이지 번호
	private int startPage;			// 보여지는 맨 앞 페이지 번호 
	private int endPage;			// 보여지는 맨 뒤 페이지 번호
	
	private int prevPage;			// 이전 페이지 모음의 마지막 번호 
	private int nextPage;			// 다음 페이지 모음의 시작 번호
	
	// 기본 생성자 X (필요없음) -> 페이지네이션 계산 X
	
	// 매개변수 생성자
	public Pagination(int currentPage, int listCount) {
		this.currentPage = currentPage;
		this.listCount = listCount;
		
		calculate();
	}
	

	public Pagination(int currentPage, int listCount, int limit, int pageSize) {
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.pageSize = pageSize;
		
		calculate();
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		
		calculate();
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
		
		calculate();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		
		calculate();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		calculate();
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}


	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	
	
	/** 페이징 처리에 필요한 값을 계산해서
	 *  필드에 대입하는 메서드
	 *  (maxPage, startPage, endPage, prevPage, nextPage)
	 */
	private void calculate() {
		
		// maxPage : 최대 페이지 == 마지막 페이지 == 총 페이지 수
		
		// 한 페이지에 게시글이 10개씩 보여질 경우
		// 게시글 수 95 개 -> 10 page
		// 게시글 수 100개 -> 10 page
		// 게시글 수 101개 -> 11 page
		maxPage = (int)Math.ceil( (double)listCount / limit );
		
		// startPage : 페이지 번호 목록의 시작 번호
		
		// 페이지 번호 목록이 10개 (pageSize) 씩 보여질 경우
		
		// 현재 페이지가  1 ~ 10 : 1page
		// 현재 페이지가 11 ~ 20 : 11page
		startPage = (currentPage - 1) / pageSize * pageSize + 1;
		
		// endPage : 페이지 번호 목록의 끝 번호
		// 현재 페이지가  1 ~ 10 : 10page
		// 현재 페이지가 11 ~ 20 : 20page
		// 현재 페이지가 21 ~ 30 : 30page
		endPage = pageSize - 1 + startPage;
		
		// 페이지 끝 번호가 최대 페이지 수를 초과한 경우
		if(endPage > maxPage) endPage = maxPage;
		
		// prevPage : "<" 클릭 시 이동할 페이지 번호
		//            (이전 페이지 번호 목록 중 끝 번호)
		
		// 더 이상 이전으로 갈 페이지가 없을 경우
		if(currentPage <= pageSize) {
			prevPage = 1;
			
		} else {
			prevPage = startPage - 1;
			
		}
		
		// nextPage : ">" 클릭 시 이동할 페이지 번호
		//            (다음 페이지 번호 목록 중 시작 번호)
		
		// 더 이상 다음으로 넘어갈 페이지가 없을 경우
		if(endPage == maxPage) {
			nextPage = maxPage;
			
		} else {
			nextPage = endPage + 1;
			
		}
		
	}
	
}
