package com.tsystems.jschool20.srvengine.application;


/**
 * Created by ruslbard on 27.03.2017.
 */
public class app {



    public static void main(String[] args) throws Exception {



        System.out.println("Application is running");

        AlaController alaController = new AlaController();

        alaController.setUp();
        alaController.insertTariff();
        alaController.tearDown();

   }
}
