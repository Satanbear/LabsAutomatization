package test;

import test.DAO.DAOFoodStuffs;

public class Main {

    public static void main(String [] args){
        DAOFoodStuffs foodStuffs = new DAOFoodStuffs();
        System.out.println(foodStuffs.getAll());
//        System.out.println(foodStuffs.getExpiredProducts());
        //System.out.println(foodStuffs.getExpiredProducts());
    }
}
