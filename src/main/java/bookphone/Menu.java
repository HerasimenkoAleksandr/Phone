package bookphone;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*Д.З. Створити "телефонний довідник" на базі асоціативних колекцій
Користувачу пропонується меню з вибором дії:
        1 - вивести все
2 - пошук за тлф
3 - пошук за іменем
4 - додати запис
0 - вихід
Програма містить початкові дані (декілька номерів відомі при старті)
решта додається під час роботи.
Додати до проєкту папку з скріншотами, прикласти посилання на репозиторій.
* Переконатись у тому що на ПК встановлено СУБД (MySQL/MariaDB) та сервер Tomcat (все є у XAMPP)*/
public class Menu {

    Map<String, String> subscriber = new HashMap<>();

    public Menu() {
        subscriber.put("0952459687","Максим");
        subscriber.put("0937459687","Дмитро");
        subscriber.put("0502789687","Олена");
    }

    public void runMenu(){
         int selected_from_menu=menuOfPhoneBook();
        switch (selected_from_menu)
        {
            case (1):{
                showFromPhoneBook();
                break;
            }
            case (2):{
                findWithName();
                break;
            }
            case (3):{
                findWithNumber();
                break;
            }
            case (4):{
                addNumber();
                break;
            }
            case (0):{
               return;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("для продовження потрібно нажати будь-яку клавішу ");
        scanner.next();
        clearConsole();
        System.out.print("\n\n");
        runMenu();
    }
    public static void clearConsole() {
        try {

            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void showFromPhoneBook(){
        for (Map.Entry<String, String> entry : subscriber.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Ім'я: " + value + ", Номер телефону: " + key);
        }
    }


    public void findWithNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер телефону, або перші цифри відповідного номеру - ");
        String number_for_find = scanner.nextLine();
        for (Map.Entry<String, String> entry : subscriber.entrySet()) {
            String key = entry.getKey();
            if(key.startsWith(number_for_find))
            {
                String value = entry.getValue();
                System.out.println("Ім'я: " + value + ", Номер телефону: " + key);
            }
        }
    }

    public void findWithName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я абонента, або перші літери відповідного імені - ");
        String name_for_find = scanner.nextLine();
        for (Map.Entry<String, String> entry : subscriber.entrySet()) {
            String value = entry.getValue();
            if(value.startsWith(name_for_find))
            {
                String key = entry.getKey();
                System.out.println("Ім'я: " + value + ", Номер телефону: " + key);
            }
        }
    }

    public int menuOfPhoneBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----МЕНЮ ТЕЛЕФОННОГО ДОВІДНИКА:----");
        System.out.println("- Введіть \"1\" - вивести вcю інформацію на екран" );
        System.out.println("- Введіть \"2\" - пошук імені абонента за номером телефону" );
        System.out.println("- Введіть \"3\" - пошук номеру телефону за іменем абонента" );
        System.out.println("- Введіть \"4\" - додати запис до телефонного довідника" );
        System.out.println("- Введіть \"0\" - вихід" );
        int x =scanner.nextInt();
        if(x!=1 && x!=2 && x!=3 && x!=4){
            return 0;
        }
        return x;
    }

    public void addNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер телефону для запису у довідник - ");
        String number_for_add = scanner.nextLine();
        System.out.println("Введіть ім'я - ");
        String name_for_add = scanner.nextLine();
        subscriber.put(number_for_add,name_for_add);
    }



}
