import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Person {

    private final Scanner input = new Scanner(System.in);
    private final LinkedHashMap<String, Object> data;

    

    public Person(){
        data = new LinkedHashMap<>();
    }
    public void addData(){
        boolean exit = false;
        String key;
        Object value;
        while (!exit) {
            System.out.println("������� ��� ���������");
            key = input.nextLine();
            if (key.equals("Exit")) return;
            System.out.println("������� �������� ���������");
            value = input.nextLine();
            data.put(key, value);
        }
    }

    public void changeData(){
        System.out.println("��� �� ������ ��������?");
        System.out.println("��������  ��������  ���");
        switch (input.nextLine()) {
            case "��������" -> { //TODO ��� ��������� ���������, ������ ��������� � ������������� �� ��������� �����, ������ ������.
                System.out.println("������� ��� ���������");
                String oldKey = input.nextLine();
                if (data.containsKey(oldKey)) {
                    Object value = data.get(oldKey);
                    data.remove(oldKey);
                    System.out.println("������� ����� ��� ���������");
                    String newKey = input.nextLine();
                    data.put(newKey, value);
                    System.out.println("��� ��������� ���� �������� � " + oldKey + " �� " + newKey);
                }
                else System.out.println("������ ��������� �� ����������");
            }
            case "��������" -> {
                System.out.println("������� ��� ���������");
                String key = input.nextLine();
                if (data.containsKey(key)) {
                    System.out.println("������� ����� �������� ���������");
                    String newValue = input.nextLine();
                    data.replace(key, newValue);
                }
                else System.out.println("������ ��������� �� ����������");
            }
            case "���" -> {
                System.out.println("������� ��� ���������");
            }
        }
    }

    public void deleteData(){
        System.out.println("������� �������� ���������");
        String key = input.nextLine();
        data.remove(key);
    }
    public void showData(){
        for(HashMap.Entry<String, Object> iterator : data.entrySet()){
            System.out.println(iterator.getKey()+": "+iterator.getValue());
        }
    }
}
