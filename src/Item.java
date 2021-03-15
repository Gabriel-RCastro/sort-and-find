public class Item implements Comparable<Item> {
    private final int id;
    private final String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static Item of(int id, String name) {
        return new Item(id, name);
    }

    @Override
    public int compareTo(Item item) {
        int result = 0;
        if (this.id < item.getId()) {
            result = -1;
        } else if (this.id > item.getId()) {
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Item{id = " + this.id + ", name = " + this.name + "}";
    }
}