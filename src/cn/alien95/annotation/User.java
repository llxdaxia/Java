package cn.alien95.annotation;

/**
 * Created by llxal on 2015/11/23.
 */
public class User {

    @Column(name = "id" )
    private int id;
    @Column(name = "gender")
    private int gender;
    @SQLstring(name = "name")
    private String name;
    @SQLstring(name = "intro",constraints = @Constraints(primaryKey = false,allowNull = false,unique = false))
    private String intro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
