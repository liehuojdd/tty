package reflect.model;

import java.io.Serializable;

/**
 * 超级英雄类
 */
public class SuperHero implements Serializable {

    public static final String ADDRESS = "earth";

    private String id;

    private String name;

    private Integer age;

    private String skill;

    public SuperHero() {
    }

    public SuperHero(String id, String name, Integer age, String skill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void print(){
        System.out.println("超级英雄：" + this.name);
    }
}
