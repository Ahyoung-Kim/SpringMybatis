package com.dev.springmybatis.mapper;

import com.dev.springmybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
