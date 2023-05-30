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
     * @Method selectAllWithKeyword
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    List<Board> selectAllWithKeyword(Criteria cri);

    /**
     *
     * @Method getBoardTotal
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    int getBoardTotal(Criteria cri);

    /**
     *
     * @Method insert
     * @Author rulethecode9060
     * @Date 2023.05.30
     */
    void insert(Board board);


}

