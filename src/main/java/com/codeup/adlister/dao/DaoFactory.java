package com.codeup.adlister.dao;



public class DaoFactory {
    private static Users usersDao;
    private static Planets planetsDao;

    private static Config config = new Config();

   public static Planets getPlanetsDao(){
       if (planetsDao == null){
           planetsDao = new MySQLPlanetsDao(config);
       }
       return planetsDao;
   }

//    public static Users getUsersDao() {
//        if (usersDao == null) {
//            usersDao = new MySQLUsersDao(config);
//        }
//        return usersDao;
//    }
}
