package com.codeup.adlister.dao;


import com.codeup.adlister.models.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Planets planetsDao;
    private static Config config = new Config();

   public static Planets getPlanetsDao(){
       if (planetsDao == null){
           planetsDao = new MySQLPlanetsDao(config);
       }
       return planetsDao;
   }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
