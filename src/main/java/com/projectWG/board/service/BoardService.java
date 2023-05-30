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
     * @Method readAll
     * @Author rulethecode9060
     * @Date 2023.05.28
     */
    public List<Board> readAll(){
        return boardMapper.selectAll();
    }

}
