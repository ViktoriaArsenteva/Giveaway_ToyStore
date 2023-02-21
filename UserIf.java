import java.util.ArrayList;
import java.util.Scanner;
import Toys.*;


public class UserIf {
    public void menu() {
        Scanner write = new Scanner(System.in);
        System.out.println("Выберите действие: ");
        System.out.println("1.Посмотреть список игрушек \n 2. Добавить игрушку \n 3.Задать вес для игрушек(после этого действия нельзя будет изменить список игрушек)");
        int num = write.nextInt();
        if (num == 1) ListOfToys();
        else if (num == 2) AddToys();
        else if (num == 3) ToyFrequency();
        
    }

    public void ListOfToys() {
        Scanner write = new Scanner(System.in);
        AddToy add = new AddToy();
        ArrayList<String> Toyslist = add.ToyList();
        for (int i = 0; i<Toyslist.size();i++){System.out.println(Toyslist.get(i));}
        System.out.println("1.Вернуться в меню \n 2. Закрыть программу");
        int num = write.nextInt();
        if (num == 1) menu();
        else if (num == 2) System.exit(0);
        



    }

    public  void AddToys() {
        AddToy add = new AddToy();
        add.CreateFile();
        ListOfToys();
        
    }

    public void ToyFrequency(){
        AddToy add = new AddToy();
        ArrayList<String> Toyslist = add.ToyList();
        ArrayList<String> GiveAway = new ArrayList<>();
        for(int j = 0;j<Toyslist.size();j++){
            System.out.print("Введите вес игрушки " + Toyslist.get(j) + ": ");
            Scanner write = new Scanner(System.in);
            int frequency = write.nextInt();
            for (int l = 0;l<frequency;l++){
                GiveAway.add(Toyslist.get(j));
            }

        }
        double num = Math.random()*GiveAway.size();
        int number = (int) num;
        System.out.println(GiveAway.get(number));

    }
}
