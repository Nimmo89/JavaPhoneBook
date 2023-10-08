import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонных номеров
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем телефонные номера в телефонную книгу
        addPhoneNumber(phoneBook, "John Smith", "123456789");
        addPhoneNumber(phoneBook, "Jane Doe", "987654321");
        addPhoneNumber(phoneBook, "John Smith", "555555555");
        addPhoneNumber(phoneBook, "Jane Doe", "111111111");

        // Выводим содержимое телефонной книги
        printPhoneBook(phoneBook);
    }

    // Метод для добавления телефонного номера в телефонную книгу
    public static void addPhoneNumber(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже существует в телефонной книге, то добавляем номер в список
        if (phoneBook.containsKey(name)) {
            List<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        }
        // Иначе создаем новую запись в телефонной книге
        else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }

    // Метод для вывода содержимого телефонной книги
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создаем список записей в телефонной книге
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список записей по убыванию числа телефонных номеров
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Выводим отсортированный список записей
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}