package graphics;

public enum ObjectType {

    Mur("M"),
    Porte("P"),
    Agent("A");

    private String type = "";

    ObjectType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
