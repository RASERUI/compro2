class GradeStatus {
    public static void main(String[] args) {
        String studentName = "RUSSELL ROY M. IGNACIO";
        String course = "BSIT-1";

        String[][] subjects = {
                {"CFVE-1"},
                {"DISTRUC1"},
                {"PURCOM"},
                {"ART APP"},
                {"STS"},
                {"NSTP"},
                {"PATHFIT"}
        };

        double[][] grades = {
                {80.38, 80.97, 89.83},
                {87.22, 82.84, 67.60},
                {74.17, 81.27, 83.98},
                {86.35, 80.83, 63.79},
                {80.56, 72.78, 73.78},
                {73.03, 74.24, 89.70},
                {92.67, 84.41, 92.93}
        };

        System.out.println(studentName + " from " + course + "\n");

        System.out.println("Grade Report:");
        System.out.println(String.format("%-12s %-12s %-12s %-12s", "SUBJECT", "PRELIM", "MID TERM", "FINALS"));

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(String.format("%-12s %-12.2f %-12.2f %-12.2f", subjects[i][0], grades[i][0], grades[i][1], grades[i][2]));
        }
    }
}
