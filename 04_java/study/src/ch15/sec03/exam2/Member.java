package ch15.sec03.exam2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member {
    public String name;
    public int age;

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member target) {
            return name.equals(target.name) && (age == target.age);
        } else {
            return false;
        }
    }
}
