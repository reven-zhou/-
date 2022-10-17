package demo3;

public class Main {
    public static void main(String[] args) {
        //��������
        KWICSubject kwicSubject = new KWICSubject();
        //�����۲���
        Input input = new Input("src\\otherfile\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "src\\otherfile\\output.txt");

        // ���۲��߼�������
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // �𲽵��ø����۲���
        kwicSubject.startKWIC();
    }
}
