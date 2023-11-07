package homework.archive;

import homework.archive.MenuArchive;

public enum MenuArchive {
    ADD_DOCUMENTS("Добавить запись"),
    VIEW_DOCUMENTS("Посмотреть все записи"),
    QUANTITY_DOCUMENTS("Узнать количевство записей"),
    EXIT("Выйти");

    private String type;

    MenuArchive(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public static void printMenu(){
        MenuArchive[] menu = MenuArchive.values();
        for (MenuArchive task1 : MenuArchive.values()) {
            System.out.println(task1.ordinal() + 1 + ". " + task1.getType());
        }
    }
}
