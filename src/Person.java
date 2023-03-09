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
        String key;
        Object value;
        while (true) {
            System.out.println("Введите название параметра");
            key = input.nextLine();
            if (key.equals("Exit")) return;
            System.out.println("Введите значение параметра");
            value = input.nextLine();
            data.put(key, value);
        }
    }

    public void changeData(){
        System.out.println("Что требуется изменить?");
        System.out.println("Параметр  Значение  Оба");
        switch (input.nextLine()) {
            case "Параметр" -> {
                System.out.println("Введите название параметра");
                String oldKey = input.nextLine();
                if (data.containsKey(oldKey)) {
                    System.out.println("Введите новое название параметра");
                    String newKey = input.nextLine();
                    int size = data.size();
                    String[] keys = data.keySet().toArray(new String[size]);
                    Object[] values = data.values().toArray(new Object[size]);
                    data.clear();
                    for (int i = 0; i < size; i++){
                        if(keys[i].equals(oldKey)){
                            keys[i] = newKey;
                            data.put(keys[i], values[i]);
                        }
                        else data.put(keys[i], values[i]);

                    }
                    System.out.println("Название сменено с  " + oldKey + " на " + newKey);
                }
                else System.out.println("Параметр не найден");
            }
            case "Значение" -> {
                System.out.println("Введите название параметра");
                String key = input.nextLine();
                if (data.containsKey(key)) {
                    System.out.println("Введите новое значение параметра");
                    String newValue = input.nextLine();
                    data.replace(key, newValue);
                }
                else System.out.println("Параметр не найден");
            }
            case "Оба" -> System.out.println("ФУНКЦИЯ НЕДОСТУПНА");
        }
    }

    public void deleteData(){
        System.out.println("Введите название параметра");
        String key = input.nextLine();
        data.remove(key);
    }
    public void showData(){
        for(HashMap.Entry<String, Object> iterator : data.entrySet()){
            System.out.println(iterator.getKey()+": "+iterator.getValue());
        }
    }
}
