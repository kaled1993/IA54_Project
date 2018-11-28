package graphics;

public enum ObjectType {

    Mur("M"),
    Porte("P"),
    Agent("A"),
	Sol("S"),
	Objectif("O");
	
    private String type = "";

    ObjectType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
