public class Sport {

    int id;
    String name;
    int requiredParticipants;

    public Sport(int id, String name, int requiredParticipants) {
        this.id = id;
        this.name = name;
        this.requiredParticipants = requiredParticipants;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRequiredParticipants() {
        return requiredParticipants;
    }

    public String toString() {
        return "Sport [id=" + id + ", name=" + name + ", requiredParticipants=" + requiredParticipants + "]";
    }
    
}
