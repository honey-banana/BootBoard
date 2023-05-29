package com.projectWG.board.mapper;

import com.projectWG.board.domain.Criteria;
import com.projectWG.board.vo.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    /**
     *
     * @Method selectAll
     * @Author rulethecode9060
     * @Date 2023.05.28
     */
    List<Board> selectAll();

}

