/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author space
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date toDate(String date, String pattern)
    {
        try
        {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    public static String toString(Date date, String pattern)
    {
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    public static Date addDay(Date date, long days)
    {
        date.setTime(date.getTime() + days*25*60*60*1000);
        return date;
    }

}
