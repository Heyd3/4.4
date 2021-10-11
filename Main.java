package Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Merchandise> merchandiseList = new ArrayList<>();
        Merchandise apple = new Food("Яблоки", 100, 1000, 10);
        Merchandise milk = new Food("Молоко", 50, 400, 5);
        Merchandise napkins = new HouseholdProducts("Салфетки", 10, 600);
        Merchandise sponges = new HouseholdProducts("Губки", 20, 200);
        merchandiseList.add(apple);
        merchandiseList.add(milk);
        merchandiseList.add(napkins);
        merchandiseList.add(sponges);
        Scanner scanner = new Scanner(System.in);
        int productNumber = 0;
        int productCount = 0;
        int currentPrice = 0;
        int sumProducts = 0;

        while (true) {
            int[] food = new int[merchandiseList.size()];
            Logger logger = Logger.getInstance();
            logger.log();
            System.out.println("Список возможных товаров для покупки: ");
            for (int i = 0; i < merchandiseList.size(); i++) {
                if (merchandiseList.get(i).availabilitySale(merchandiseList.get(i).getAmount()) == true && merchandiseList.get(i).getAmount() != 0) {
                    System.out.println((i + 1) + "." + merchandiseList.get(i).getName());
                }
            }
            System.out.println("для завершения программы введите 'end' для продолжения нажмите любую клавишу");
            String str = scanner.nextLine();
            if (!str.equals("end")) {
                while (true) {
                    System.out.println("Введите номер товара и количество или `завершить покупки`: ");
                    String input = scanner.nextLine();
                    if ("завершить покупки".equals(input)) break;
                    String[] parts = input.split(" ");
                    try {
                    productNumber = Integer.parseInt(parts[0]) - 1;
                    productCount = Integer.parseInt(parts[1]);

                        if (merchandiseList.get(productNumber).availabilitySale(productCount) == true) {
                            currentPrice = merchandiseList.get(productNumber).getPrice();
                            sumProducts = sumProducts + (productCount * currentPrice);
                            food[productNumber] = food[productNumber] + productCount;
                            merchandiseList.get(productNumber).amount = merchandiseList.get(productNumber).amount  - productCount;
                        } else {
                            System.out.println("Нельзя купить этот товар");
                        }
                    } catch (IndexOutOfBoundsException | NumberFormatException ex){
                        System.out.println("Вы ввели неверный номер товара");
                        continue;
                    }
                }

                for (int i = 0; i < merchandiseList.size(); i++) {
                    output(food[i], merchandiseList.get(i).getName(), merchandiseList.get(i).getPrice());
                }
                if (sumProducts != 0) {
                    System.out.println("итог: " + sumProducts);
                }
                sumProducts = 0;
            }
            else break;

        }
    }

    public static void output(int quantity, String name, int price) {
        int sumProducts = quantity * price;
        if (quantity > 0) {
            System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
            System.out.println(name + "         " + quantity + "        " + price + "       " + sumProducts);
        }
    }
}
