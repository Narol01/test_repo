package homework.archive;

import homework.archive.dao.Archive;
import homework.archive.dao.ArchiveImpl;
import homework.archive.model.Documents;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
public class ArchiveAppl {
    public static void main(String[] args) {
        Archive archive;
        archive = new ArchiveImpl(5);
        Documents[] documents;
        documents = new Documents[4];
        Scanner scanner = new Scanner(System.in);
        Random random=new Random();
        System.out.println("Welcome to ToDoList Menu");
        while (true) {
            MenuArchive.printMenu();
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    while (true) {
                        System.out.print("Ввод дaнных");
                        System.out.print(" \nВведите номер папки в которую желаете добавить документ:");
                        int FolderId = scanner.nextInt();
                        System.out.print(" \nВведите номер документа:");
                        int documentId = scanner.nextInt();
                        System.out.print(" \nВведите name:");
                        String name = scanner.next();
                        String url = String.valueOf(random.nextInt());
                        System.out.print("Ваш url:"+ url+"\n");
                        LocalDateTime LokalNow = LocalDateTime.now();
                        Documents documents1 = new Documents(FolderId, documentId, name, url, LokalNow);
                        archive.addDocument(documents1);
                        archive.printArray();
                        System.out.println("Дополнить ещё \n yes-продожить \n no-закончить");
                        String a = scanner.next();
                        if (a.equals("no")) {
                            break;
                        }
                    }
                }
                case 2->{
                    System.out.println("Your documents: ");
                    archive.printArray();
                }
                case 3->{
                    System.out.println("У вас есть  " + archive.size() + " документов.");
                }
                case 4->{
                    System.out.println("Выход из приложения.");
                    System.exit(0);
                }
                //раскопировать cases;
                default-> {
                    System.out.println("Неверный выбор");
                }
            }
        }
    }
}
