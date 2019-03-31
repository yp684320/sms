package 课后习题;

import java.util.Objects;

public class Car {
    private String name;
    private String coler;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(coler, car.coler);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, coler);
    }

    public Car(String name, String coler) {
        this.name = name;
        this.coler = coler;

    }

    @Override
    public String toString() {
        return
                name + '\t' +
                '\t' +coler
              ;
    }
}
