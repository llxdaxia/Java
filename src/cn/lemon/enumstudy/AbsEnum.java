package cn.alien95.enumstudy;

/**
 * Created by llxal on 2015/11/22.
 */
public enum  AbsEnum {

    APPLE {
        @Override
        String getInfo() {
            return "苹果";
        }
    },
    XIGUA {
        @Override
        String getInfo() {
            return "西瓜";
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        AbsEnum absEnum = AbsEnum.APPLE;
        System.out.println(absEnum.getInfo());
    }

}
