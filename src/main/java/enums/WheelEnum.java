package enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление, описывающие направления прокрутки колеса мыши
 * @author asugrobov
 */
public enum WheelEnum {
    UP(-1, "Вверх"),
    DOWN(1, "Вниз");

    private static Map<Integer, WheelEnum> map = new HashMap();

    static {
        for(WheelEnum wheelEnum:WheelEnum.values()){
            map.put(wheelEnum.getDirection(), wheelEnum);
        }
    }

    public static String getDirectionTitle(Integer direction){
        return map.get(direction).getTitle();
    }

    private Integer direction;
    private String title;

    WheelEnum(Integer direction, String title){
        this.direction = direction;
        this.title = title;
    }

    public Integer getDirection() {
        return direction;
    }

    public String getTitle() {
        return title;
    }
}
