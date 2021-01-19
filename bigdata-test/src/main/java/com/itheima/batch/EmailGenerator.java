package com.itheima.batch;

import java.util.Random;

public class EmailGenerator {
    private static final Random RANDOM=new Random();
    private static final String emailSuffix[]={"qq.com","163.com","sina.com","gmail.com","yahoo.com","263.net"};
    private static final String LETTERS[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","_","$"};




    public static String generate(){
        String suffix=emailSuffix[RANDOM.nextInt(emailSuffix.length)];
        //String suffix="qq.com";
        String emailName="";
        if ("qq.com".equals(suffix)){
            //qq的邮箱特殊 都是纯数字的
            //qq邮箱的数字 不允许为0
            //至少为5位以上 且目前应该不超过12位(有待考证)
            //总共多少位qq号
            int num=RANDOM.nextInt(12-5)+5-1;
            //第一位不能为0
            emailName+=RANDOM.nextInt(9)+1;
            for (int i=0;i<num;i++){
                emailName+=RANDOM.nextInt(10);
            }

        }else{
            //其他邮箱可以由数字和字母组成 一般字母都在前 最多不超过12位(有待考证)
            int num=RANDOM.nextInt(12);
            emailName+=LETTERS[RANDOM.nextInt(LETTERS.length)];
            for (int i=0;i<num;i++){
                //可以是数字可以是字母

                emailName+=RANDOM.nextInt(2)==0?LETTERS[RANDOM.nextInt(LETTERS.length)]:RANDOM.nextInt(10);
            }

        }


        return emailName+"@"+suffix;
    }
    public static void main(String[] args) {
        while (true){
            System.out.println(generate());
           // System.out.println(RANDOM.nextInt(7)+5);
        }
    }
}
