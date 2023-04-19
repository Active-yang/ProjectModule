package com.zhku.acl;

import com.zhku.acl.schedule.GetToken;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        //获取当前日期
        Date date = new Date();
        String s = date.toString();
        System.out.println(s);
        System.out.println("===========");
        System.out.println(date);


    }
}
