public class QuestionService {
    Question[] questions = new Question[3];
    public void displayQuestions(){
        questions[0] = new Question(1,"what are you doing?","Shit","Watch","Rea","learn","learn");
        questions[1] = new Question(2,"What is your name?","seng","zee","Rea","ya","seng");
        questions[2] = new Question(3,"Who do you like?","Me","Mean","Ara","lamo","Me");
        System.out.println("Hello world");
        for(Question item :  questions){
            System.out.println(item.getQuestion());
        }
    }
}
