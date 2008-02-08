package org.mule.transformers.xml.castor;

public class Entity {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof Entity)) {
            return false;
        }
        return age == ((Entity) obj).getAge() && name.equals(((Entity) obj).getName());
    }

    public String toString() {
        return "<" + getClass().getName() + ">" + name + ";" + age + "<" + getClass().getName() + ">";
    }
    

    
}
