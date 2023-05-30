package com.projectWG.board.controller;

import com.projectWG.board.service.BoardService;
import com.projectWG.board.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

//    @GetMapping("/board/{boardNo}")
//    public String readByBoardNo(@PathVariable int boardNo, Model model){
//        Board board = boardService.readByBoardNo(boardNo);
//        model.addAttribute("board", board);
//        return "board/read";
//    }

    @GetMapping("/board/list")
    public String readAll(Model model){
        List<Board> boards = boardService.readAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }


}
