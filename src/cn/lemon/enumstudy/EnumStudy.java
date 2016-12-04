package cn.alien95.enumstudy;

import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created by llxal on 2015/11/21.
 */
public class EnumStudy {

    enum Person{

        SB("sb"),DASHEN("da shen"),DOUBI("dou bi"),CAONIMA("cao ni ma"),SHENJINGBING;

        private String describe;

        Person(){
            this.describe = "shenjingbing";
        }

        Person(String describe){
            this.describe = describe;
        }
        @Override
        public String toString() {
            return describe;
        }
    }

    public static void main(String[] args) {
        anlyze(Person.class);
        for (Person p : Person.class.getEnumConstants()){   //通过Class的getEnumConstants方法来获取Enum实例
            System.out.println(p);
        }

        for (Person p : Person.values()) {   //通过静态的values（）方法来获取实例，这个方式是编译器编译的时候添加到person中的，person的基类Enum并没有这个方法
            System.out.println(p);
        }

        EnumSet<Person> enumsets = EnumSet.noneOf(Person.class);   //一个空的set
        enumsets.of(Person.CAONIMA);   //返回一个新的enumset，并把enum添加进去
        enumsets.add(Person.DASHEN);
        enumsets.addAll(enumsets.of(Person.CAONIMA,Person.DASHEN,Person.DOUBI,Person.SB));  //这里是一个set，不允许enum元素重复
        System.out.println(enumsets);

        EnumMap<Person,String> map = new EnumMap<Person, String>(Person.class);
        map.put(Person.CAONIMA,"cao ni ma");
        System.out.println(map);
    }


    public static void anlyze(Class enumClass){
        Method[] methods = enumClass.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }

}
