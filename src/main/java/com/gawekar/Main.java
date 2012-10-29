package com.gawekar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String args[]) {
        EntityManagerFactory emfdb = Persistence.createEntityManagerFactory("testPerson");
        emfdb.close();
    }
}
