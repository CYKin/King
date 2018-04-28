package com.king.testA;

/**
 * 内部类
 *
 * @author wangchangyong
 * @create 2018/01/09 18:19
 */
public class OuterClass {

    private String name;

    public void say() {
        System.out.println("name：" + name);
    }

    //成员内部类
    //成员内部类中不能存在任何static的变量和方法
    //成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类
    public class InnerClass {

        private String ss = "111";

        //获取外部类
        public OuterClass getOuterClass(){
            return OuterClass.this;
        }

        public InnerClass() {
            name = "King";
        }

        public void say(){
            System.out.println("11111");
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        innerClass.say();

        innerClass.getOuterClass().say();


        StringBuffer s = new StringBuffer();
        s.append("111");

        String ss = "111";
        ss.concat(ss);

    }
}
