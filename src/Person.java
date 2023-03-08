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
            System.out.println("Введите имя параметра");
            key = input.nextLine();
            if (key.equals("Exit")) return;
            System.out.println("Введите значение параметра");
            value = input.nextLine();
            data.put(key, value);
        }
    }

    public void changeData(){
        System.out.println("Что вы хотите изменить?");
        System.out.println("Параметр  Значение  Оба");
        switch (input.nextLine()) {
            case "Параметр" -> { //TODO При изменении параметра, старый удаляется и пересоздается на последнем слоте, вместо своего.
                System.out.println("Введите имя параметра");
                String oldKey = input.nextLine();
                if (data.containsKey(oldKey)) {
                    System.out.println("Введите новое имя параметра");
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
                    System.out.println("Имя параметра было изменено с " + oldKey + " на " + newKey);
                }
                else System.out.println("Такого параметра не существует");
            }
            case "Значение" -> {
                System.out.println("Введите имя параметра");
                String key = input.nextLine();
                if (data.containsKey(key)) {
                    System.out.println("Введите новое значение параметра");
                    String newValue = input.nextLine();
                    data.replace(key, newValue);
                }
                else System.out.println("Такого параметра не существует");
            }
            case "Оба" -> System.out.println("Введите имя параметра");
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
