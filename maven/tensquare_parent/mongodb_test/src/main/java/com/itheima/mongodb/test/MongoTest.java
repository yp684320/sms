package com.itheima.mongodb.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MongoTest {


    @Test
    public void test1() {
        //命令行操作:
        //1. 打开mongodb的客户端
        //2. 执行use spitdb
        //3. 执行 db.spit.find()


        //代码操作:
        //1. 创建mongodb的客户端对象
        MongoClient mongoClient = new MongoClient("192.168.72.129", 27017);

        //2. 使用客户端对象获取数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");

        //3. 使用数据库获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //4. 使用集合进行数据查询
        //查询所有数据db.spit.find()
        //FindIterable<Document> documents = spit.find();
        //条件查询db.spit.find({"_id" : "2"})
        BasicDBObject bsonObject = new BasicDBObject("_id", "2");
        FindIterable<Document> documents = spit.find(bsonObject);

        //5. 解析查询结果
        for (Document document : documents) {
            System.out.println("---------------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("nickname:" + document.get("nickname"));
            System.out.println("visits:" + document.getInteger("visits"));
        }
    }


    @Test
    public void test2() {
        //命令行操作:
        //1. 打开mongodb的客户端
        //2. 执行use spitdb
        //3. 执行 db.spit.find()


        //代码操作:
        //1. 创建mongodb的客户端对象
        MongoClient mongoClient = new MongoClient("192.168.72.128", 27017);

        //2. 使用客户端对象获取数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");

        //3. 使用数据库获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        Map map = new HashMap();
        map.put("_id", "5566");
        map.put("content", "mongodb driver 测试");
        map.put("userid", "6677");
        map.put("nickname", "王五");
        map.put("visits", 10000);
        //4. 使用集合进行数据插入
        Document document = new Document(map);


        spit.insertOne(document);

    }
}
