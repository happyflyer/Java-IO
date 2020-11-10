package org.example.java_io.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author lifei
 */
public class Student implements Serializable {
    private String stuNo;
    private transient String stuName;
    private transient int stuAge;

    public Student() {
    }

    Student(String stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    private void writeObject(ObjectOutputStream s)
            throws IOException {
        // 把 JVM 默认能序列化的元素进行序列化
        s.defaultWriteObject();
        // 自己完成其他元素的序列化
        s.writeObject(stuName);
        s.writeInt(stuAge);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.stuName = (String) s.readObject();
        this.stuAge = s.readInt();
    }
}

