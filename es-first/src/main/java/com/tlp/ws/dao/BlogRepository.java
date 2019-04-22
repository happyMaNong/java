package com.tlp.ws.dao;

import com.tlp.ws.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @className: BlogRepository
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-15 15:33
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, Long> {

}
