import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[3];
    String selection[] = new String[3];
    public QuestionService() {
        questions[0] = new Question(1,"what are you doing?","Shit","Watch","Rea","learn","learn");
        questions[1] = new Question(2,"What is your name?","seng","zee","Rea","ya","seng");
        questions[2] = new Question(3,"Who do you like?","Me","Mean","Ara","lamo","Me");
    }

    public void playQuiz(){
        int i=0;
        for(Question item :  questions){
            System.out.println("---------------------------");
            System.out.println("Question number : "+item.getId());
            System.out.println(item.getQuestion());
            System.out.println(item.getOpt1());
            System.out.println(item.getOpt2());
            System.out.println(item.getOpt3());
            System.out.println(item.getOpt4());
            Scanner sc = new Scanner(System.in);
            selection[i] = sc.nextLine();
            i++;
        }
        System.out.println("This below your answer");
        System.out.println("---------------------------");
        for(String s:selection){
            System.out.println(s);
        }
    }
}
