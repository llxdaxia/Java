package cn.alien95.annotation;

/**
 * Created by llxal on 2015/11/22.
 */
public class Test {

    public static void main(String[] args) {
        User user = new User();
        java.lang.reflect.Field[] fields = user.getClass().getDeclaredFields();

        for(java.lang.reflect.Field field : fields){

            Column field1 = field.getAnnotation(Column.class);  //没有注解的时候就返回null
            SQLstring sqLstring = field.getAnnotation(SQLstring.class);
            if(field1 != null){
                System.out.println(field1.name());
            }
            if(sqLstring != null){
                System.out.println("----------------------");
                System.out.println(sqLstring.name());
                System.out.println(sqLstring.value());
                System.out.println(sqLstring.constraints().primaryKey());
                System.out.println(sqLstring.constraints().allowNull());
                System.out.println(sqLstring.constraints().unique());
            }


        }
    }
}
