package org.example.java_io.serial;

import java.io.Serializable;

class Foo implements Serializable {
    Foo() {
        System.out.println("Foo ... ");
    }

    @Override
    public String toString() {
        return "Foo{}";
    }
}

class Foo1 extends Foo {
    Foo1() {
        System.out.println("Foo1 ... ");
    }

    @Override
    public String toString() {
        return "Foo1{}";
    }
}

class Foo2 extends Foo1 {
    Foo2() {
        System.out.println("Foo2 ... ");
    }

    @Override
    public String toString() {
        return "Foo2{}";
    }
}
