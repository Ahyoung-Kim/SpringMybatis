package com.dev.springmybatis.dao;

import com.dev.springmybatis.dto.PostDto;
import com.dev.springmybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    ) {
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto) {
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }

        //        데이터베이스와 소통하기 위해 세션 유지
//        SqlSession session = sessionFactory.openSession();
//        PostMapper mapper = session.getMapper(PostMapper.class);
//        int rowAffected = mapper.createPost(dto);
////        한번 통신하고 세션 닫아주기
//        session.close();
//
//        return rowAffected;
    }

    public PostDto readPost(int id) {
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll() {
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }

    public int updatePost(PostDto dto) {
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }

    public int deletePost(int id) {
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
