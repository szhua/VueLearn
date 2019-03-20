package com.iview.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author szhua
 * @Description:ivew_demo==
 * @Date 2019/3/19
 **/
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {

   List<GoodsInfo> findAllByDescription(String des);
   Page<GoodsInfo> findByDescription(String des , Pageable pageable);
}
