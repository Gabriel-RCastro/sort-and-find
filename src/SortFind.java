import java.util.List;
import java.util.Optional;

public class SortFind {
    public static Optional<Item> sortAndFindFirst(List<Item> items, Predicate<Item> predicate) {
        try {
            insertionSort(items);
            var indexItem = binarySearch(items, predicate);
            return Optional.of(items.get(indexItem));
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Item não encontrado!");
            return Optional.empty();
        }
    }

    private static void insertionSort(List<Item> items) {
        for (int i = 1; i < items.size(); i++) {
            var currentItem = items.get(i);
            var comparedIndex = i;
            while (comparedIndex > 0 && items.get(comparedIndex - 1).compareTo(currentItem) > 0) {
                items.set(comparedIndex, items.get(comparedIndex - 1));
                comparedIndex--;
            }
            items.set(comparedIndex, currentItem);
        }
    }

    private static int binarySearch(List<Item> items, Predicate<Item> predicate) {
        var low = 0;
        var high = items.size() - 1;
        while (low <= high) {
            var mid = (low + high) / 2;
            var comparator = predicate.test(items.get(mid));
            if (comparator < 0) low = mid + 1;
            else if (comparator > 0) high = mid - 1;
            else return mid;
        }
        return -(low + 1);
    }
}
