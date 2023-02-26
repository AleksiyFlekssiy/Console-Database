import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<Person> list;
    Scanner input = new Scanner(System.in);
    static boolean trigger = true;
    public static void main(String[] args) {
        Database DB = new Database();

        while (trigger){
            DB.getCommand();
        }
    }

    void getCommand(){
        System.out.println("������� �������");
        String command = input.nextLine();
        switch (command){
            case "Create database":createDatabase(); break;
            case "Delete database":deleteDatabase(); break;
            case "Add person":addPerson(); break;
            case "Delete person":deletePerson(); break;
            case "Add data to person":addData(); break;
            case "Change person data":changeData(); break;
            case "Delete person data":deleteData(); break;
            case "Show person data":showPerson(); break;
            case "Exit": trigger = false; break;
        }
    }



    void createDatabase(){
        list = new ArrayList<>();
    }
    void deleteDatabase(){
        list.clear();
    }

    void addPerson(){
        System.out.println("�������� �� ������ ��������� ����������?");
        if (input.nextLine().equals("��")) {
            try {
                var person = new Person();
                list.add(person);
                person.addData();
            } catch (NullPointerException NPE) {
                createDatabase();
                var person = new Person();
                list.add(person);
                person.addData();
            }

        }
        else if (input.nextLine().equals("���")){
            try {
                list.add(new Person());
            } catch (NullPointerException NPE) {
                createDatabase();
                list.add(new Person());
            }
        }
        else System.out.println("�������� �������");

    }
    void deletePerson(){
        list.remove(getPerson());
    }

    void addData(){
        getPerson().addData();
    }
    void changeData(){
        getPerson().changeData();
    }
    void deleteData() {
        getPerson().deleteData();
    }
    void showPerson(){
        getPerson().showData();
    }
    public Person getPerson(){
        byte number;
        System.out.println("������� ����� ���������");
        number = Byte.parseByte(input.nextLine());
        return list.get(number-1);
    }

}
