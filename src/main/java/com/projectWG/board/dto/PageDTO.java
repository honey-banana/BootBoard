package com.projectWG.board.dto;

import com.projectWG.board.domain.Criteria;
import lombok.Data;

@Data
public class PageDTO {

    private int pageStart; // 페이지 시작 번호
    private int pageEnd; // 페이지 끝 번호
    private boolean next, prev; // 이전, 다음 버튼 존재 여부
    private int total; // 행 전체 개수
    private Criteria cri; // 현재페이지 번호(pageNum), 행 표시 수(amount), 검색 키워드(keyword), 검색 종류(type)

    public PageDTO(Criteria cri, int total) {

        this.cri = cri;
        this.total = total;
        this.pageEnd = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; // 기본 10개
        this.pageStart = this.pageEnd - 9; // 페이지 끝번호(10) - x가 1이 되어야 하므로 - 9
        int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

        /* 페이지 끝 번호 유효성 체크 */
        if (realEnd < pageEnd) {
            this.pageEnd = realEnd;
        }

        /* 이전 버튼 값 초기화 */
        this.prev = this.pageStart > 1;

        /* 다음 버튼 값 초기화 */
        this.next = this.pageEnd < realEnd;
    }

}