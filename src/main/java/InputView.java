import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputCarCount(){
        System.out.println("자동차 대수는 몇대인가요?");
        return scanner.nextInt();
    }

    public int inputGameCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public String inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

}
