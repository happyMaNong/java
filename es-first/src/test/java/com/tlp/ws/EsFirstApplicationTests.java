package com.tlp.ws;

import com.tlp.ws.dao.BlogRepository;
import com.tlp.ws.dao.StudentRepository;
import com.tlp.ws.entity.Blog;
import com.tlp.ws.entity.Student;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.existsQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsFirstApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private  ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void find() {

        //使用queryStringQuery完成单字符串全文查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery("java")).build();

        //查询某个字段中模糊包含目标字符串，使用matchQuery
        SearchQuery searchQuery1 = new NativeSearchQueryBuilder().withQuery(matchQuery("content", "文件流")).build();

        //PhraseMatch查询 短语匹配 类似于数据库里的“%落日熔金%”这种

        //Term查询 ，即不分词匹配，你传来什么值就会拿你传的值去做完全匹配

        //multi_match多个字段匹配某字符串
        SearchQuery searchQuery3 = new NativeSearchQueryBuilder().withQuery(multiMatchQuery("语言网页", "title", "content")).build();

        //之前的查询中，当我们输入“文件流”时，ES会把分词后所有包含“文件”和“流”的都查询出来，如果我们希望必须是包含了两个字的才能被查询出来，那么我们就需要设置一下Operator。
        SearchQuery searchQuery4 = new NativeSearchQueryBuilder().withQuery(matchQuery("content", "文件流").operator(Operator.AND)).build();

        SortBuilder sortBuilderName = SortBuilders.fieldSort("realName.keyword").order(SortOrder.DESC);
        SortBuilder sortBuilderId = SortBuilders.fieldSort("id").order(SortOrder.ASC);
        //withSort的前后顺序决定排序优先级
        SearchQuery searchQuery5 = new NativeSearchQueryBuilder()
                .withQuery(boolQuery().should(rangeQuery("status").lt(1)).must(matchQuery("realName", ""))).withSort(sortBuilderName)
                .withSort(sortBuilderId).build();

        List<Blog> blogs = elasticsearchTemplate.queryForList(searchQuery4, Blog.class);
        System.out.println("1111");
    }

    @Test
    public void add() {
        Blog blog1 = new Blog();
        blog1.setId(201904161554L);
        blog1.setContent(
                "C语言是一门面向过程、抽象化的通用程序设计语言，广泛应用于底层开发。C语言能以简易的方式编译、处理低级存储器。C语言是仅产生少量的机器语言以及不需要任何运行环境支持便能运行的高效率程序设计语言。尽管C语言提供了许多低级处理的功能，但仍然保持着跨平台的特性，以一个标准规格写出的C语言程序可在包括一些类似嵌入式处理器以及超级计算机等作业平台的许多计算机平台上进行编译");
        blog1.setPostdate(new Date());
        blog1.setTitle("C语言基础知识学习");
        blog1.setUrl("www.clang.com");
        blogRepository.save(blog1);
    }

    @Test
    public void add1() {
        Student student = new Student();
        student.setId(2019042202L);
        student.setName("詹姆斯");
        student.setAge(34);
        student.setBirthday("1985-06-21");
        student.setScore(100.0);
        student.setAddress("美国克利夫兰小城镇");
        studentRepository.save(student);

        Student student2 = new Student();
        student2.setId(2019042203L);
        student2.setName("库里");
        student2.setAge(30);
        student2.setBirthday("1988-09-21");
        student2.setScore(100.0);
        student2.setAddress("美国旧金山");
        studentRepository.save(student2);

        Student student3 = new Student();
        student3.setId(2019042204L);
        student3.setName("姚明");
        student3.setAge(35);
        student3.setBirthday("1984-06-21");
        student3.setScore(90.0);
        student3.setAddress("中国上海");
        studentRepository.save(student3);

        Student student4 = new Student();
        student4.setId(2019042205L);
        student4.setName("欧文");
        student4.setAge(28);
        student4.setBirthday("1990-02-21");
        student4.setScore(100.0);
        student4.setAddress("美国克利夫兰");
        studentRepository.save(student4);
    }

    @Test
    public void find1() {
        //查询条件，条件为空查询所有，es中查询默认有分页 pageNum 1 pageSize 10  matchAll
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(new MatchAllQueryBuilder()).build();

        //match
        SearchQuery searchQuery1 = new NativeSearchQueryBuilder().withQuery(matchQuery("address", "美国")).build();

        //multi_match
        SearchQuery searchQuery2 = new NativeSearchQueryBuilder().withQuery(multiMatchQuery("美国", "address", "name")).build();

        //range
        SearchQuery searchQuery3 = new NativeSearchQueryBuilder().withQuery(rangeQuery("age").gt(28).lt(35)).build();

        //term 精准匹配 ，查询不到数据是因为，address的类型为text，使用中文分词器分词了，而term对查询的字符串不分词，所以查询不到。
        SearchQuery searchQuery4 = new NativeSearchQueryBuilder().withQuery(termQuery("address", "美国旧金山")).build();

        //exist
        SearchQuery searchQuery5 = new NativeSearchQueryBuilder().withQuery(existsQuery("address")).build();

        //query_string 全文搜索，默认搜索全部字段，可以指定字段
        SearchQuery searchQuery6 = new NativeSearchQueryBuilder().withQuery(queryStringQuery("美国")).build();

        //bool
        SearchQuery searchQuery7 = new NativeSearchQueryBuilder().withQuery(boolQuery().must(matchQuery("name", "杜小帅"))).build();

        SearchQuery searchQuery8 = new NativeSearchQueryBuilder()
                .withQuery(boolQuery().must(matchQuery("address", "美国")).mustNot(matchQuery("age", 30))).build();

        SearchQuery searchQuery9 = new NativeSearchQueryBuilder()
                .withQuery(boolQuery().filter(boolQuery().should(matchQuery("address", "美国")).should(matchQuery("name", "姚明")))).build();

        //分页,坑爹啊为啥pag 要从0开始
        SearchQuery searchQuery10 = new NativeSearchQueryBuilder().withQuery(matchQuery("address", "美国")).withPageable(new PageRequest(0, 4)).build();

        SearchQuery searchQuery11 = new NativeSearchQueryBuilder().withQuery(matchQuery("address", "美国")).build();
        List<Sort.Order> list = new ArrayList<>();
        //排序
        list.add(Sort.Order.asc("age"));
        list.add(Sort.Order.asc("id"));
        Sort sort = Sort.by(list);
        searchQuery11.addSort(sort);

        //高亮搜索
        SearchQuery searchQuery12 = new NativeSearchQueryBuilder().withQuery(matchQuery("address", "美国"))
                .withHighlightFields(new HighlightBuilder.Field("address")).build();
        // AggregatedPage<Student> students = elasticsearchTemplate.queryForPage(searchQuery10, Student.class);
        // students.getContent().forEach(student -> {
        // System.out.println(student.toString());
        //   });
        List<Student> students = elasticsearchTemplate.queryForList(searchQuery12, Student.class);
        students.forEach(student -> {
            System.out.println(student.toString());
        });
    }

    @Test
    public void update() {
        Student student4 = new Student();
        student4.setId(2019042205L);
        student4.setName("欧文");
        student4.setAge(28);
        student4.setBirthday("1991-02-21");
        student4.setScore(100.0);
        student4.setAddress("美国克利夫兰");
        studentRepository.save(student4);
    }

    @Test
    public void delete() {
        studentRepository.deleteById(2019042204L);
    }

    @Test
    public void search() {
        MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
        SearchQuery searchQuery = new NativeSearchQuery(matchAllQueryBuilder);


        QueryStringQueryBuilder qstr = QueryBuilders.queryStringQuery("美国 旧金山");
       // qstr.defaultOperator(Operator.AND);
        SearchQuery searchQuery1 = new NativeSearchQuery(qstr);


        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("age", 30);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.mustNot(qstr);
        boolQueryBuilder.must(matchQueryBuilder);
        SearchQuery searchQuery2 = new NativeSearchQuery(boolQueryBuilder);

        query(searchQuery1);


    }

    public  void query(SearchQuery searchQuery) {
        List<Student> students = elasticsearchTemplate.queryForList(searchQuery, Student.class);
        students.forEach(student -> {
            System.out.println(student.toString());
        });
    }
}

