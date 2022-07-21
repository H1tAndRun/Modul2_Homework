package home_work3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public class UserBroken {
   private int age;
   private String name;

    public UserBroken(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBroken that = (UserBroken) o;
        that.name=this.name;
        that.age= this.age;
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "UserBroken{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
