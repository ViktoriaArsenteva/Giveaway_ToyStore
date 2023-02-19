package Toys;


public abstract class Toy implements ToyInterface{
    public int id;
    public String name;
    public int frequency;


    public Toy (int id, String name, int frequency){
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    


    public String getInfo() {
        return name + Integer.toString(id);
        

    }
}