package main.java.animals;

public class Mammal extends Animal {
    String furColor;

    public Mammal(String name, String sound, String furColor) {
        super(name, sound);
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                ", furColor='" + furColor + '\'' +
                '}';
    }

    @Override
    public String getSound(){
        return "Mamal sound intensifies";
    }
}
