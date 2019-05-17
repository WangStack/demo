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
//     * �������ݿ����ӵ�ַ 
//     */  
//    private final String CONN_HOST = "127.0.0.1";  
//      
//    /** 
//     * �������ݿ����Ӷ˿ں� 
//     */  
//    private final int CONN_PORT = 27017;  
//      
//    /** 
//     * MongoDB����ʵ�� 
//     */  
//    public MongoClient mongoClient = null;  
//      
//    /** 
//     * MongoDB���ݿ�ʵ�� 
//     */  
//    public MongoDatabase mongoDatabase= null;  
//      
//    
//    /** 
//     * ���췽�� 
//     * ��ȡ���ݿ�ʵ�� 
//     * @param DB_Name 
//     */  
//    public MongoDbUtil(String DB_Name){  
//        this.mongoClient = new MongoClient(CONN_HOST, CONN_PORT);  
//        this.mongoDatabase = this.mongoClient.getDatabase(DB_Name);  
//    }  
//  
//    /** 
//     * �������ݿ⼯�� 
//     * @param collName ���ݿ���� 
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
//     * ��ȡ���ݿ⼯�� 
//     * @param collName 
//     * @return 
//     */  
//    public MongoCollection<Document> getCollection(String collName){  
//        return this.mongoDatabase.getCollection(collName);  
//    }        
//    /** 
//     * ���뵥���ĵ� 
//     * @param doc Bson�ĵ� 
//     * @param collName �������� 
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
//     * ������Ƶ��ͼƬ��������·������
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
//     * ���������ĵ� 
//     * @param list List�����ĵ� 
//     * @param collName �������� 
//     */  
//    public void insert(List<Document> list, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.insertMany(list);  
//    }  
//  
//    /** 
//     * ���Ҽ���������Document 
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
//     * ָ���������� 
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
//     * ָ����������ָ���ֶ� 
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
//     * ����һ�� 
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
//     * ɾ�������е��������� 
//     * @param collName 
//     */  
//    public void deleteAll(String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        BasicDBObject delDbo=new BasicDBObject();  
//        delDbo.append("_id", -1);  
//        coll.deleteMany(Filters.not(delDbo));  
//    } 
//    /** 
//     * ɾ��ָ������������ 
//     * @param b 
//     * @param collName 
//     */  
//    public void deleteAll(Bson b, String collName){  
//        MongoCollection<Document> coll = this.mongoDatabase.getCollection(collName);  
//        coll.deleteMany(b);  
//    }        
//    /** 
//     * ɾ��ָ����һ������ 
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
//     * ����ѯ���������޸� 
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
//        //����  
//       /* if(mongo.createCollection(collName)){  
//            System.out.println("hello create success");  
//        }  
//        else{  
//            System.out.println("create fail");  
//        }  */
//      //��������  
//       Document docA = new Document();  
//       docA.append("key1", "val1");  
//       docA.append("key2", "val2");  
//       docA.append("key3", "val3");  
//       mongo.insert(docA, collName);
////      //��������  
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
////      //��ѯ����  
////      List<Document> findAll = mongo.findAll(collName);  
////      System.out.println(findAll.size());  
////      for(Document doc : findAll){  
////          System.out.println(doc.get("key3"));  
////      }  
//          
//          
////      //ָ����������ȫ��  
////      BasicDBObject query =  new BasicDBObject();  
////      query.append("key3", "val99");  
////      List<Document> findAllB = mongo.findAll(query, collName);  
////      System.out.println(findAllB.size());  
////      for(Document doc : findAllB){  
////          System.out.println(doc.toString());  
////      }  
//          
//          
////      //ָ����������ȫ��,����ָ���ֶ�  
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
////      //ָ����������һ��  
////      BasicDBObject queryOne = new BasicDBObject();  
////      queryOne.append("key3", "val99");  
////      Document docOne = mongo.findOne(queryOne, collName);  
////      System.out.println(docOne);  
//          
////      //ɾ�������е���������  
////      mongo.deleteAll(collName);  
//          
//          
////      //ɾ��������ָ������������  
////      Bson b = Filters.eq("key1", "val1");  
////      mongo.deleteAll(b,collName);  
//          
////      //ɾ��ָ����һ������  
////      Bson b = Filters.eq("key1", "val1");  
////      mongo.deleteOne(b,collName);  
//          
//          
////      //����ѯ������������  
////      Bson b = Filters.eq("key1", "val1");  
////      Document doc = new Document();  
////      doc.append("key1", "val100");  
////      Document docT = new Document("$set", doc);  
////      mongo.updateAll(b, docT, collName);  
//          
//    }    
//}  