class Course {
    String name;
    String code;
    String prefix;
    double note;
    Teacher teacher;
    double verbalNotePercentage;

    Course(String name, String code, String prefix, double note, Teacher teacher, double verbalNotePercentage) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = note;
        this.teacher = teacher;
        this.verbalNotePercentage = verbalNotePercentage;
    }

    void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    void printTeacher() {
        System.out.println("Teacher: " + teacher.name);
    }
}

class Teacher {
    String name;
    String mpno;
    String branch;

    Teacher(String name, String mpno, String branch) {
        this.name = name;
        this.mpno = mpno;
        this.branch = branch;
    }
}

class Student {
    String name;
    String stuNo;
    Course[] courses;
    double[] examNotes;
    double average;
    boolean isPass;

    Student(String name, String stuNo, Course[] courses) {
        this.name = name;
        this.stuNo = stuNo;
        this.courses = courses;
        this.examNotes = new double[courses.length];
    }

    void addExamNote(int courseIndex, double note) {
        examNotes[courseIndex] = note;
    }

    void calcAverage() {
        double totalWeightedNote = 0;
        double totalWeight = 0;

        for (int i = 0; i < courses.length; i++) {
            double verbalNote = examNotes[i] * courses[i].verbalNotePercentage / 100;
            double weightedNote = (examNotes[i] - verbalNote) * (100 - courses[i].verbalNotePercentage) / 100;

            totalWeightedNote += weightedNote;
            totalWeight += (100 - courses[i].verbalNotePercentage);
        }

        average = totalWeightedNote / totalWeight;
    }

    void isPass() {
        if (average > 60) {
            isPass = true;
        } else {
            isPass = false;
        }
    }

    void printNote() {
        for (int i = 0; i < courses.length; i++) {
            System.out.println("Course: " + courses[i].name);
            System.out.println("Exam Note: " + examNotes[i]);
            System.out.println("Verbal Note Percentage: " + courses[i].verbalNotePercentage);
        }

        System.out.println("Average: " + average);
        System.out.println("Pass: " + isPass);
    }
}

public class Main {
    public static void main(String[] args) {
        Teacher ozan = new Teacher("Ozan", "123456", "Mathematics");
        Teacher sinan = new Teacher("Sinan", "654321", "Physics");
        Teacher süleyman = new Teacher("Süleyman", "987654", "Chemistry");

        Course mathCourse = new Course("Mathematics", "101", "MAT", 80, ozan, 30);
        Course physicsCourse = new Course("Physics", "202", "PHY", 75, sinan, 30);
        Course chemistryCourse = new Course("Chemistry", "303", "CHE", 85, süleyman, 30);

        Course[] courses = {mathCourse, physicsCourse, chemistryCourse};

        Student dogukan = new Student("Doğukan", "001", courses);
        Student zafer = new Student("Zafer", "002", courses);
        Student sinanaga = new Student("Sinanaga", "003", courses);

        dogukan.addExamNote(0, 70);
        dogukan.addExamNote(1, 85);
        dogukan.addExamNote(2, 90);

        zafer.addExamNote(0, 75);
        zafer.addExamNote(1, 80);
        zafer.addExamNote(2, 70);

        sinanaga.addExamNote(0, 90);
        sinanaga.addExamNote(1, 65);
        sinanaga.addExamNote(2, 80);

        dogukan.calcAverage();
        dogukan.isPass();
        dogukan.printNote();

        zafer.calcAverage();
        zafer.isPass();
        zafer.printNote();

        sinanaga.calcAverage();
        sinanaga.isPass();
        sinanaga.printNote();
    }
}
