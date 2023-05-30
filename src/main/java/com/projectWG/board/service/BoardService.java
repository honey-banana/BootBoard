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
    public List<Board> readAllWithKeyword(Criteria cri) throws Exception{
        return boardMapper.selectAllWithKeyword(cri);
    };

    /**
     *
     * @Method getBoardTotal
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public int getBoardTotal(Criteria cri) throws Exception{
        return boardMapper.getBoardTotal(cri);
    };

    /**
     *
     * @Method write
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    public void write(Board board){
        boardMapper.insert(board);
    }

}
