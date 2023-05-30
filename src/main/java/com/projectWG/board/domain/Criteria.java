package com.projectWG.board.domain;

import lombok.Data;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class Criteria {
    private int pageNum; // 현재 페이지 번호
    private int amount; // 페이지당 표시할 게시글 수
    private int skip; // 건너띌 갯수(offset 수)
    private String searchType; // 검색 타입(제목/내용/작성자)
    private String keyword; // 검색 키워드

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum - 1) * amount;
    }

    public Criteria() {
        this(1, 10); // 페이지 번호 1, 게시물 표시 갯수 10개
    }

    /* 검색 타입 데이터 배열 변환 */
    public String[] getTypeArr() {
        return searchType == null ? new String[]{} : searchType.split("");
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.skip = (pageNum - 1) * this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.skip = (this.pageNum - 1) * amount;
    }

    public String makeQueryString(int pageNum) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("searchType", searchType)
                .queryParam("keyword", keyword)
                .build()
                .encode();

        return uriComponents.toUriString();
    }
}
