package org.example.java_io.serial;

import java.io.Serializable;

class Bar {
    Bar() {
        System.out.println("Bar ... ");
    }

    @Override
    public String toString() {
        return "Bar{}";
    }
}

class Bar1 extends Bar implements Serializable {
    Bar1() {
        System.out.println("Bar1 ... ");
    }

    @Override
    public String toString() {
        return "Bar1{}";
    }
}

class Bar2 extends Bar1 {
    Bar2() {
        System.out.println("Bar2 ... ");
    }

    @Override
    public String toString() {
        return "Bar2{}";
    }
}
