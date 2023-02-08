import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TestService testService = new TestService();
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = testService.getQuestions();
        for (Question q : questions){
            System.out.println(q.id() + ") " + q.text());
            System.out.println("A - " + q.answers()[0]);
            System.out.println("Б - " + q.answers()[1]);
            System.out.println("В - " + q.answers()[2]);
            Pointers pointer;
            while (true) {
                String answer = scanner.next();
                if ("А".equals(answer)) {
                    pointer = Pointers.A;
                    break;
                } else if ("Б".equals(answer)) {
                    pointer = Pointers.B;
                    break;
                } else if ("В".equals(answer)) {
                    pointer = Pointers.C;
                    break;
                } else {
                    System.out.println("Wrong pointer!");
                }
            }
            testService.putAnswer(new Answer(q.id(), pointer));
        }

        Result[] results = testService.getResults();
        for (Result result : results) {
            System.out.println("=====================================================================================");
            System.out.println("Категория " + result.categoryId() + ". \n");
            System.out.println(result.categoryDescription() + "\n");
            System.out.println("Количество баллов: " + result.points());
            System.out.println(result.pointsDescription());
            System.out.println("=====================================================================================");
        }
    }
}
