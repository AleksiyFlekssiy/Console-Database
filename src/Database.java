import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<DataElement> list;
    Scanner input = new Scanner(System.in);
    static boolean trigger = true;
    public static void main(String[] args) {
        Database DB = new Database();

        while (trigger){
            DB.getCommand();
        }
    }

    void getCommand(){
        System.out.println("Введите команду");
        String command = input.nextLine();
        switch (command) {
            case "Создать базу данных" -> createDatabase();
            case "Удалить базу данных" -> deleteDatabase();
            case "Добавить элемент" -> addElement();
            case "Удалить элемент" -> deleteElement();
            case "Дополнить элемент" -> addData();
            case "Изменить элемент" -> changeData();
            case "Удалить информацию элемента" -> deleteData();
            case "Найти элемент" -> findData();
            case "Отобразить элемент" -> showElement();
            case "Выход" -> trigger = false;
        }
    }



    void createDatabase(){
        list = new ArrayList<>();
    }
    void deleteDatabase(){
        list.clear();
    }

    void addElement(){
        System.out.println("Добавить информацию новому элементу?");
        if (input.nextLine().equals("Да")) {
            try {
                var person = new DataElement();
                list.add(person);
                person.addData();
            } catch (NullPointerException NPE) {
                createDatabase();
                var person = new DataElement();
                list.add(person);
                person.addData();
            }

        }
        else if (input.nextLine().equals("Нет")){
            try {
                list.add(new DataElement());
            } catch (NullPointerException NPE) {
                createDatabase();
                list.add(new DataElement());
            }
        }
        else System.out.println("Неверная команда");

    }
    public void deleteElement(){
        list.remove(getDataElement());
    }

    void addData(){
        getDataElement().addData();
    }
    void changeData(){
        getDataElement().changeData();
    }
    void deleteData() {
        getDataElement().deleteData();
    }
    void findData(){
        getDataElement().findData();
    }
    void showElement(){
        getDataElement().showData();
    }
    public DataElement getDataElement(){
        byte number;
        System.out.println("Введите номер участника");
        number = Byte.parseByte(input.nextLine());
        return list.get(number-1);
    }

}
