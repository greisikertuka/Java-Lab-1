package main.java.animals;

public class Bird extends Mammal {
    int wingSpan;


    public Bird(String name, String sound, String furColor, int wingSpan) {
        super(name, sound, furColor);
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                ", wingSpan=" + wingSpan +
                ", furColor='" + furColor + '\'' +
                '}';
    }

    @Override
    public String getSound() {
        return "Bird sound intensifies";
    }
}
