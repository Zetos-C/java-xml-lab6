public class Student {
    private String id;
    private String name;
    private String className;
    private double score;

    public Student(String id, String name, String className, double score) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public double getScore() {
        return score;
    }
}
