import java.net.ServerSocket;

public class RecursionImpl {

    public static int fibonacci(int number ){
        if(number == 1 || number ==2){
            return 1;
        }

        return fibonacci(number -1) + fibonacci(number -2);
    }

    public static int factorial(int number){
        if(number ==0){
            return 1;
        }

        return number* factorial(number -1);
    }

    public static String reverse(String msg){
        if(msg.length() < 2){
            return msg;
        }
        return reverse(msg.substring(1)) + msg.charAt(0);
    }

    public static void main(String args[]){
        System.out.println(fibonacci(6));

        System.out.println(factorial(9));

        System.out.println(reverse("I love you"));
    }
}
