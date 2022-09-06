import java.util.Comparator;
import java.util.List;

/**
 *
 * Your task is to process a sequence of integer numbers to determine the following statistics:
 *
 *     o) minimum value
 *     o) maximum value
 *     o) number of elements in the sequence
 *     o) average value
 *     o) number of elements in the sequence == 6 && average value >= 20
 *
 * For example: [6, 9, 15, -2, 92, 11]
 *
 *     o) minimum value = -2
 *     o) maximum value = 92
 *     o) number of elements in the sequence = 6
 *     o) average value = 21.833333
 *     o) true
 *
 * EXTRA CHALLENGE:
 * Get the list of numbers from an API (check EmailApi for examples)
 */

class ListApi{
    public List<Integer> fetchList() {
        throw new RuntimeException("DON'T IMPLEMENT NOR REMOVE IT");
    }
}

public class ListHelper {
    final ListApi listApi;

    public ListHelper(ListApi listApi) {
        this.listApi = listApi;
    }

    private List<Integer> list() {
        List<Integer> listElemments = listApi.fetchList();
        if (listElemments == null || listElemments.isEmpty() ){
            throw new RuntimeException("Elemments not found!");
        }
        return listElemments;
    }

    public Integer minValue(){
        return list().stream().min(Comparator.comparing(el -> el)).get();
    }

    public Integer maxValue(){
        return list().stream().max(Comparator.comparing(el -> el)).get();
    }

    public Integer size(){
        return list().size();
    }

    public Double average(){
        return list().stream().mapToDouble(d -> d)
                .average().getAsDouble();
    } //    qdo é double tem um get só dele... um get só pra DOUBLE pq ele é chique meu amor!

}
