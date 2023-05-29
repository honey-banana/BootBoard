package com.projectWG.board.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Board {
    private int boardNo; // 게시글 번호(pk)
    private String register; // 작성자
    private String password; // 패스워드
    private String boardTitle; // 게시글 제목
    private String contents; // 게시글 내용
    private int regCnt; // 조회수
    private Timestamp regDate; // 작성 일자
    private Timestamp modiDate; // 수정 일자
    private String delYn; // 게시글 삭제 여부("Y"/"N")
    private Timestamp delDate; // 게시글 삭제 일자
}

