package com.tlp.lucene;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @className: LuceneApi
 * @description:
 * @author: tianlingpeng
 * @create: 2019-10-30 10:38
 */
@Slf4j
public class LuceneApi {

    //https://blog.csdn.net/weixin_42633131/article/details/82873731
        //1 创建文档对象
        //2 创建存储目录
        //3 创建分词器
        //4 创建索引写入器的配置对象
        //5 创建索引写入器对象
        //6 将文档交给索引写入器
        //7 提交
        //8 关闭

    @Test
    public void createIndex() throws Exception{
        //创建文档对象
        Document document = new Document();
        document.add(new StringField("id", "2", Field.Store.YES));
        document.add(new TextField("title", "谷歌地图", Field.Store.YES));

        FSDirectory directory = null;
        //创建存储目录
        try {
            directory = FSDirectory.open(new File("e:\\indexDir"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建分词器
       // Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer(false);

        //创建索引写入器的配置对象
        IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);

        //创建索引写入器对象
        IndexWriter writer = null;
        try {
            writer = new IndexWriter(directory, conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.addDocument(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.commit();
        writer.close();
    }

    //1 创建读取目录对象
    //2 创建索引读取工具
    //3 创建索引搜索工具
    //4 创建查询解析器
    //5 创建查询对象
    //6 搜索数据
    //7 各种操作



    public void search(Query query) throws Exception{
        FSDirectory directory = null;
        //索引目录对象
        try {
            directory = FSDirectory.open(new File("e:\\indexDir"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);

        //QueryParser parser = new QueryParser("title",new IKAnalyzer());
        //Query query = parser.parse("facebook");

        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("一共搜索到:"+topDocs.totalHits+"条数据");
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId = scoreDoc.doc;
            Document document = reader.document(docId);
            log.info("id:{}", document.get("id"));
            log.info("title:{}", document.get("title"));
            log.info("得分:{}", scoreDoc.score);
        }
    }

    @Test
    public void query() throws Exception {
        //词条查询
        Query query = new TermQuery(new Term("title", "谷歌地图"));
        search(query);

        //通配符查询
        Query query1 = new WildcardQuery(new Term("title", "*地*"));
        search(query1);
    }
}
