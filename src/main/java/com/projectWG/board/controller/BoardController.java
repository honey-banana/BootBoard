package com.projectWG.board.controller;

import com.projectWG.board.domain.Criteria;
import com.projectWG.board.dto.PageDTO;
import com.projectWG.board.service.BoardService;
import com.projectWG.board.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    /**
     *
     * @Method readByBoardNo
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @GetMapping("/board/{boardNo}")
    public String readByBoardNo(@PathVariable int boardNo, Model model){
        Board board = boardService.readByBoardNo(boardNo);
        model.addAttribute("board", board);
        return "board/read";
    }

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

    /**
     *
     * @Method readByBoardNo
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @GetMapping("/board/delete/{boardNo}")
    public String deleteForm(@PathVariable int boardNo, Model model){
        Board board = new Board();
        board.setBoardNo(boardNo);
//        System.out.println(board);
        model.addAttribute("board", board);
        return "board/delete";
    }

    /**
     *
     * @Method readByBoardNo
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @PostMapping("/board/delete")
    public String deleteByBoardNo(Board board, HttpServletResponse response){
        Board data = boardService.readByBoardNo(board.getBoardNo());
        String dataRegister = data.getRegister();
        String dataPassword = data.getPassword();
        String inputRegister = board.getRegister();
        String inputPassword = board.getPassword();
        if(dataRegister.equals(inputRegister) && dataPassword.equals(inputPassword)){
            boardService.deleteByBoardNo(board.getBoardNo());
        } else {
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                w.write("<script>alert('"+"작성자명 혹은 패스워드가 잘못되었습니다."+"');history.go(-1);</script>");
                w.flush();
                w.close();
                return null;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return "board/list";
    }


}
