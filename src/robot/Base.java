package robot;

public class Base {
    private int water;
    private int food;
    private int mineral;

    public Base() {
        this.water = 0;
        this.food = 0;
        this.mineral = 0;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getMineral() {
        return mineral;
    }

    public void setMineral(int mineral) {
        this.mineral = mineral;
    }
}
