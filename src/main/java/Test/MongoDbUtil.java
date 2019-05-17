//package Test;
//
//import java.util.ArrayList;  
//import java.util.List;  
//import org.bson.Document;  
//import org.bson.conversions.Bson;   
//
//import com.lql.pojo.SinaSite;
//import com.lql.pojo.VideoAndImg;
//import com.mongodb.BasicDBObject;  
//import com.mongodb.MongoClient;  
//import com.mongodb.client.FindIterable;  
//import com.mongodb.client.MongoCollection;  
//import com.mongodb.client.MongoCursor;  
//import com.mongodb.client.MongoDatabase;  
//import com.mongodb.client.model.Filters;    
//public class MongoDbUtil {       
//    /** 
//     * 设置数据库连接地址 
//     */  
//    private final String CONN_HOST = "127.0.0.1";  
//      
//    /** 
//     * 设置数据库连接端口号 
//     */  
//    private final int CONN_PORT = 27017;  
//      
//    /** 
//     * MongoDB连接实例 
//     */  
//    public MongoClient mongoClient = null;  
//      
//    /** 
//     * MongoDB数据库实例 
//     */  
//    public MongoDatabase mongoDatabase= null;  
//      
//    
//    /** 
//     * 构造方法 
//     * 获取数据库实例 
//     * @param DB_Name 
//     */  
//    public MongoDbUtil(String DB_Name){  
//        this.mongoClient = new MongoClient(CONN_HOST, CONN_PORT);  
//        this.mongoDatabase = this.mongoClient.getDatabase(DB_Name);  
//    }  
//  
//    /** 
//     * 创建数据库集合 
//     * @param collName 数据库表名 
//     */  
//    public boolean createCollection(String collName){  
//        try  
//        {  
//            this.mongoDatabase.createCollection(collName);  
//        }  
//        catch(Exception e)  
//        {  
//            System.out.println(e.getMessage());  
//            return false;  
//        }  
//        return true;  
//    }        
//    /** 
//     * 获取数据库集合 
//     * @param collName 
//     * @return 
//     */  
//    public MongoCollection<Document> getCollection(String collName){  
//        return this.mongoDatabase.getCollection(collName);  
//    }        
//    /** 
//     * 插入单个文档 
//     * @param doc Bson文档 
//     * @param collName 集合名称 
//     */  
//    public void insert(Document doc, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);          
//        coll.insertOne(doc);  
//    }  
//     
//    
//    public void insertMongoDb(SinaSite site, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        Document docA = new Document();  
//        docA.append("author", site.getAuthor());  
//        docA.append("publisthTime", site.getPublisthTime());  
//        docA.append("content",site.getContent());  
//        docA.append("commentNumber",site.getCommentNumber());  
//        docA.append("relayNumber",site.getRelayNumber());  
//        docA.append("praiseNumber",site.getPraiseNumber());  
//        coll.insertOne(docA);  
//    }  
//    /**
//     * 插入视频和图片，仅保留路径即可
//     * @param site
//     * @param collName
//     */
//    public void insertVideoMongoDb(VideoAndImg vi, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);   	 
//        Document docA = new Document();  
//        docA.append("title", vi.getTitle());  
//        docA.append("hitNumber", vi.getHitNumber());  
//        docA.append("commentNumber",vi.getCommentNumber());  
//        docA.append("publishTime",vi.getPublishTime()); 
//        docA.append("videoPlayUrl",vi.getVideoPlayUrl());  
//        docA.append("realVideoUrl",vi.getRealVideoUrl());  
//        docA.append("videoFilePath",vi.getVideoFilePath());  
//        docA.append("imgFilePath",vi.getImgFilePath());  
//        coll.insertOne(docA);  
//    }  
//    
//    /** 
//     * 批量插入文档 
//     * @param list List类型文档 
//     * @param collName 集合名称 
//     */  
//    public void insert(List<Document> list, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.insertMany(list);  
//    }  
//  
//    /** 
//     * 查找集合内所有Document 
//     * @param collName 
//     * @return 
//     */  
//    public List<Document> findAll(String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        List<Document> result = new ArrayList<Document>();  
//        FindIterable<Document> findIterable = coll.find();  
//        MongoCursor<Document> mongoCursor = findIterable.iterator();  
//        while(mongoCursor.hasNext()){  
//            result.add(mongoCursor.next());  
//        }  
//        return result;  
//    }  
//      
//    /** 
//     * 指定条件查找 
//     * @param query 
//     * @param collName 
//     * @return 
//     */  
//    public List<Document> findAll(BasicDBObject query, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        List<Document> result = new ArrayList<Document>();  
//        FindIterable<Document> findIterable = coll.find(query);  
//        MongoCursor<Document> mongoCursor = findIterable.iterator();  
//        while(mongoCursor.hasNext()){  
//            result.add(mongoCursor.next());  
//        }  
//        return result;  
//    }  
//    /** 
//     * 指定条件查找指定字段 
//     * @param query 
//     * @param collName 
//     * @return 
//     */  
//    public List<Document> findAll(BasicDBObject query, BasicDBObject key, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        List<Document> result = new ArrayList<Document>();  
//        FindIterable<Document> findIterable = coll.find(query).projection(key);  
//        MongoCursor<Document> mongoCursor = findIterable.iterator();  
//        while(mongoCursor.hasNext()){  
//            result.add(mongoCursor.next());  
//        }  
//        return result;  
//    } 
//    /** 
//     * 查找一个 
//     * @param query 
//     * @param collName 
//     * @return 
//     */  
//    public Document findOne(BasicDBObject query,String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        Document result = new Document();  
//        FindIterable<Document> findIterable = coll.find(query).limit(1);  
//        result = findIterable.iterator().next();  
//        return result;  
//    } 
//    /** 
//     * 删除集合中的所有数据 
//     * @param collName 
//     */  
//    public void deleteAll(String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        BasicDBObject delDbo=new BasicDBObject();  
//        delDbo.append("_id", -1);  
//        coll.deleteMany(Filters.not(delDbo));  
//    } 
//    /** 
//     * 删除指定的所有数据 
//     * @param b 
//     * @param collName 
//     */  
//    public void deleteAll(Bson b, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.deleteMany(b);  
//    }        
//    /** 
//     * 删除指定的一条数据 
//     * @param b 
//     * @param collName 
//     */  
//    public void deleteOne(Bson b, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.deleteOne(b);  
//    }  
//      
//      
//    //collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes",200)) );    
//      
//    /** 
//     * 按查询条件批量修改 
//     * @param b 
//     * @param doc 
//     * @param collName 
//     */  
//    public void updateAll(Bson b, Document doc, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.updateMany(b, doc);  
//    }  
//    public static void main(String[] args) {    
//    	  
//        String collName = "hello";  
//        MongoDbUtil mongo = new MongoDbUtil("blyang");  
//          
//        //创建  
//       /* if(mongo.createCollection(collName)){  
//            System.out.println("hello create success");  
//        }  
//        else{  
//            System.out.println("create fail");  
//        }  */
//      //单个插入  
//       Document docA = new Document();  
//       docA.append("key1", "val1");  
//       docA.append("key2", "val2");  
//       docA.append("key3", "val3");  
//       mongo.insert(docA, collName);
////      //批量插入  
////      List<Document> list = new ArrayList<Document>();  
////      for(int i=0; i<10; i++){  
////          Document doc = new Document();  
////          doc.append("key1", "val" + i);  
////          doc.append("key2", "val" + i);  
////          doc.append("key3", "val" + i);  
////          list.add(doc);  
////      }  
////      mongo.insert(list, collName);  
//          
//          
////      //查询所有  
////      List<Document> findAll = mongo.findAll(collName);  
////      System.out.println(findAll.size());  
////      for(Document doc : findAll){  
////          System.out.println(doc.get("key3"));  
////      }  
//          
//          
////      //指定条件查找全部  
////      BasicDBObject query =  new BasicDBObject();  
////      query.append("key3", "val99");  
////      List<Document> findAllB = mongo.findAll(query, collName);  
////      System.out.println(findAllB.size());  
////      for(Document doc : findAllB){  
////          System.out.println(doc.toString());  
////      }  
//          
//          
////      //指定条件查找全部,返回指定字段  
////      BasicDBObject query =  new BasicDBObject();  
////      query.append("key3", "val99");  
////      BasicDBObject key = new BasicDBObject();  
////      key.append("key2",1);  
////      key.append("_id", 0);  
////      List<Document> findAllB = mongo.findAll(query,key, collName);  
////      System.out.println(findAllB.size());  
////      for(Document doc : findAllB){  
////          System.out.println(doc.toString());  
////      }  
//          
//          
////      //指定条件查找一个  
////      BasicDBObject queryOne = new BasicDBObject();  
////      queryOne.append("key3", "val99");  
////      Document docOne = mongo.findOne(queryOne, collName);  
////      System.out.println(docOne);  
//          
////      //删除集合中的所有数据  
////      mongo.deleteAll(collName);  
//          
//          
////      //删除集合中指定的所有数据  
////      Bson b = Filters.eq("key1", "val1");  
////      mongo.deleteAll(b,collName);  
//          
////      //删除指定的一个数据  
////      Bson b = Filters.eq("key1", "val1");  
////      mongo.deleteOne(b,collName);  
//          
//          
////      //按查询条件批量更新  
////      Bson b = Filters.eq("key1", "val1");  
////      Document doc = new Document();  
////      doc.append("key1", "val100");  
////      Document docT = new Document("$set", doc);  
////      mongo.updateAll(b, docT, collName);  
//          
//    }    
//}  