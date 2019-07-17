package test;

import lombok.Data;

@Data
public class Student implements Cloneable{
    private String name;
    private String number;
    private String school;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
