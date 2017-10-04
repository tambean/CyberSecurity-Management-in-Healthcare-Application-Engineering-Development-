/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import Business.DB4OUtil.DB4OUtil;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author CUTIE
 */
public class DataGenerator {

    public static Boolean checkDuplicateUserName(String name) {
        ArrayList<String> UsernameList = DB4OUtil.retrieveUserNameList();
        for (String s : UsernameList) {
            if (s.equalsIgnoreCase(name)) {
                return Boolean.FALSE;
            }
        }
        UsernameList.add(name);
        DB4OUtil.storeUserNameList(UsernameList);
        return Boolean.TRUE;
    }

    public static int getRandomNumberBetweenRange(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }

    public static String randomMACAddress() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        macAddr[0] = (byte) (macAddr[0] & (byte) 254);

        StringBuilder sb = new StringBuilder(18);
        for (byte b : macAddr) {

            if (sb.length() > 0) {
                sb.append(":");
            }

            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
