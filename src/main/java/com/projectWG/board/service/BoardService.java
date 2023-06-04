package com.projectWG.board.service;

import com.projectWG.board.domain.Criteria;
import com.projectWG.board.mapper.BoardMapper;
import com.projectWG.board.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    /**
     *
     * @Method readAllWithKeyword
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    @Transactional
    public Board readByBoardNo(int boardNo){
        Board board = boardMapper.selectByNo(boardNo).orElseThrow(()->new NullPointerException("해당 게시물이 존재하지 않습니다."));
        boardMapper.increaseRegCount(board.getBoardNo()); // 조회수 +1
        return board;
    }

    /**
     *
     * @Method readAllWithKeyword
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public List<Board> readAllWithKeyword(Criteria cri) throws Exception{
        return boardMapper.selectAllWithKeyword(cri);
    }

    /**
     *
     * @Method getBoardTotal
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public int getBoardTotal(Criteria cri) throws Exception{
        return boardMapper.getBoardTotal(cri);
    }

    /**
     *
     * @Method write
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public void write(Board board){
        boardMapper.insert(board);
    }

    /**
     *
     * @Method deleteByBoardNo
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public void deleteByBoardNo(int boardNo)
    {
        boardMapper.deleteByNo(boardNo);
    }

    /**
     *
     * @Method edit
     * @Author rulethecode9060
     * @Date 2023.06.04
     */
    public void edit(Board board)
    {
        boardMapper.update(board);
    }

}
