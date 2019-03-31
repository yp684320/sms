package cn.itheima.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
   public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
   public static EntityManagerFactory getFactory(){
       return factory;
   }
   public static EntityManager getEntityManager(){
       return factory.createEntityManager();
   }
}
