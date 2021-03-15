import java.util.ArrayList;
import java.util.List;

public class SortFindService {
    public static void main(String[] args) {
        var item1 = Item.of(1, "item1");
        var item2 = Item.of(2, "item2");
        var item3 = Item.of(3, "item3");
        var item4 = Item.of(4, "item4");
        var item5 = Item.of(5, "item5");
        var itemTeste = Item.of(10, "item10");
        var listOfItems = new ArrayList<>(List.of(item3, item1, item5, item2, item4));
        var foundItem = SortFind.sortAndFindFirst(listOfItems, item -> item.compareTo(itemTeste));
        if (foundItem.isPresent()) System.out.println(foundItem);
    }
}
