/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Admin;
import domain.User;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ejer
 */
public class UserMapperTest {

    public UserMapperTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserData method, of class UserMapper.
     */
    @Test
    public void testGetUserData() throws Exception {
        System.out.println("getUserData");
        String username = "test";
        UserMapper instance = new UserMapper();
        int expResult = 1;
        int result = instance.getUserData(username).getUser_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addUser method, of class UserMapper.
     */
//    @Test
//    public void testAddUser() throws SQLException {
//        System.out.println("addUser");
//        UserMapper instance = new UserMapper();
//        String mail = "tr@tr.tr";
//        String password = "password";
//        String name = "tr";
//        User u = new User(name, password, mail);
//        instance.addUser(u);
//        System.out.println("getUserData");
//       
//        double expResult = 100;
//        double result = instance.getUserData("tr").getBalance();
//        assertEquals(expResult, result, 0);
//
//        // TODO review the generated test code and remove the default call to fail.
//    }
//    
     
    /**
     * Test of godkendBruger method, of class UserMapper.
     */
    @Test
    public void testGodkendBruger() {
        System.out.println("godkendBruger");
        String name = ("test");
        String password = ("test");
        User u = new User(name, password);
        UserMapper instance = new UserMapper();
        boolean expResult = false;
        boolean result = instance.godkendBruger(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAdminData method, of class UserMapper.
     */
    @Test
    public void testGetAdminData() throws Exception {
        System.out.println("getAdminData");
        String adminUsername = "Admin";
        UserMapper instance = new UserMapper();
        boolean expResult = true;
        boolean result = instance.getUserData(adminUsername).isAdminStatus();
        assertEquals(expResult, result);

    }

    /**
     * Test of changeUserBalance method, of class UserMapper.
     */
    @Test
    public void testChangeUserBalance() throws SQLException, NumberFormatException {
        System.out.println("changeUserBalance");
        String username = "test";
        double b = 300;
        UserMapper instance = new UserMapper();
        instance.changeUserBalance(username, b);
        double result = instance.getUserData(username).getBalance();
        double expResult = 300;

        assertEquals(expResult, result, 0);

    }
    
    @Test
    public void testChangeUserBalanceBack() throws SQLException, NumberFormatException {
        System.out.println("changeUserBalance");
        String username = "test";
        double b = 100;
        UserMapper instance = new UserMapper();
        instance.changeUserBalance(username, b);
        double result = instance.getUserData(username).getBalance();
        double expResult = 100;

        assertEquals(expResult, result, 0);

    }

    /**
     * Test of main method, of class UserMapper.
     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = null;
//        UserMapper.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }

}
