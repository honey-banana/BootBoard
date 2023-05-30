package com.projectWG.board.controller;

import com.projectWG.board.domain.Criteria;
import com.projectWG.board.dto.PageDTO;
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

    /**
     *
     * @Method readAllWithKeyword
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @GetMapping("/board/list")
    public void readAllWithKeyword(Criteria cri, Model model) throws Exception {

        List<Board> boards = boardService.readAllWithKeyword(cri);
        model.addAttribute("boards", boards);

        /* 페이지 이동 인터페이스 데이터 */
        int total = boardService.getBoardTotal(cri);
        PageDTO pageMaker = new PageDTO(cri, total);
        model.addAttribute("pageMaker", pageMaker);
    }

    /**
     *
     * @Method writeForm
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @GetMapping("/board/write")
    public String writeForm(Model model){
        Board board = new Board();
        model.addAttribute("board", board);
        return "/board/write";
    }

    /**
     *
     * @Method write
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @PostMapping("/board/write")
    public String write(Model model, Board board){
        boardService.write(board);
        return "redirect:/board/list";
    }


}
