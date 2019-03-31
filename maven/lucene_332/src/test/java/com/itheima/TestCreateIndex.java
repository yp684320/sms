package com.itheima;

import com.itheima.domain.Book;
import com.itheima.domain.dao.BookDao;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestCreateIndex {
    @Test
    public void test() throws Exception{
    //1 创建分词器对象   这是Lucene分词器对中文不友好
      // Analyzer analyzer = new StandardAnalyzer();
        //创建中文IK分词器
        Analyzer analyzer = new IKAnalyzer();
        //2, 准备数据
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.findAll();
        //3, 创建文档列表对象---一个book对应一个文档
       List<Document> documentList = new ArrayList<Document>();
        for (Book book : bookList) {
            Document document = new Document();
            //创建域对象   一个文档对象 包含多个域对象
            //三个参数  参数1:域名  一般是列的名称   参数2: 域中的值   参数3, :是否存储
            TextField idField = new TextField("id",String.valueOf(book.getId()), Field.Store.YES);
            TextField nameField = new TextField("name",book.getName(), Field.Store.YES);
            TextField picField = new TextField("pic",book.getPic(), Field.Store.YES);
            TextField priceField = new TextField("price",String.valueOf(book.getPrice()), Field.Store.YES);
            TextField descriptionField = new TextField("description",book.getDescription(), Field.Store.YES);
            //把域对象添加到文档中
            document.add(idField);
            document.add(nameField);
            document.add(picField);
            document.add(priceField);
            document.add(descriptionField);
            //添加到文件集中
            documentList.add(document);
        }
       //4, 指定索引库位置
           FSDirectory directory = FSDirectory.open(new File("d:/dic"));
        //5, 创建索引输出流配置对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        //6, 创建索引输出流对象
        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
        //7, 把文档对象写入索引库中
        for (Document document : documentList) {
            indexWriter.addDocument(document);
        }
        //8, 提交
        indexWriter.commit();
        //9, 释放资源
        indexWriter.close();

    }
}
