package Demo;

public class InterviewBit {
    public void method1(int num1, float num2) {
        System.out.println("int-float method");
    }

    public void method1(float num1, int num2) {
        System.out.println("float-int method");
    }

    public static void main(String[] args) {
        InterviewBit interviewBit = new InterviewBit();
        interviewBit.method1(40, (float) 20);
    }
}
