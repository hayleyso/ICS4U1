public class SuperAnimal extends Animal {
    private boolean hasWings;
    private boolean canTeleport;
    private boolean canSwim;

    public SuperAnimal(String name, String species, int age, boolean isDomesticated, boolean hasWings, boolean canTeleport, boolean canSwim) {
        super("SuperAnimal", species, name, age, isDomesticated);  
        this.hasWings = hasWings;
        this.canTeleport = canTeleport;
        this.canSwim = canSwim;
    }

    public String fly() {
        if (hasWings) {
            return name + " is flying";
        } else {
            return name + " cannot fly";
        }
    }

    public String teleport(String toPlace) {
        if (canTeleport) {
            return name + " is teleporting to " + toPlace;
        } else {
            return name + " cannot teleport";
        }
    }

    public String swim() {
        if (canSwim) {
            return name + " is swimming";
        } else {
            return name + " cannot swim";
        }
    }
}
