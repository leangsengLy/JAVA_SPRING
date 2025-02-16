package exception;

class LyZeeException extends Exception {
    public LyZeeException(String string){
        super(string);
    }
    
}
public class exception {
    public static void main(String[] args) {
            int i =3; 
            int j=0;
            int[] a = new int[10];
            String Me = null;
            try{
                // j= 20/i;
                // System.out.println(a[0]);
                // System.out.println(a[10]);
                // System.out.println(Me.length());
                if(j==0) throw new LyZeeException("I don't want you pass data like this! ");

            }catch(LyZeeException e){
                System.out.println("Something when wrong..."+e);
            }
            System.out.println("Bye");
    }
}
