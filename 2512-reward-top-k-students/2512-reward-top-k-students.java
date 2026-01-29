class Solution {
    class Student{
        int id;
        int score;
        Student(int id, int score){
            this.id = id;
            this.score = score;
        }
    }
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Student> studentData = new ArrayList<>();
        HashSet<String> pos = new HashSet<>();
        HashSet<String> neg = new HashSet<>();
        for(String s : positive_feedback) pos.add(s);
        for(String n : negative_feedback) neg.add(n);
        for(int i=0; i<student_id.length; i++){
            int id = student_id[i];
            int score = 0;
            String[] reported = report[i].toLowerCase().split("[^a-z]+");
            for(String str : reported){
                if(pos.contains(str)) score+=3;
                else if(neg.contains(str)) score-=1;
            }
            studentData.add(new Student(id,score));
        }
        Collections.sort(studentData, (a,b)->a.score==b.score? a.id-b.id :b.score-a.score);
        List<Integer> topKStudents = new ArrayList<>();
        for(int i=0; i<k; i++){
            topKStudents.add(studentData.get(i).id);
        }
        return topKStudents;
    }
}