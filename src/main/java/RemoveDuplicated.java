import java.util.List;

/**
 * Define a function RemoveDuplicate(nlist) to remove duplicate elements from list.
        Here are some examples:
        [] -> []
        [1,2] -> [1,2]
        [1,1,2,2,3,3] -> [1,2,3]
 **/
public class RemoveDuplicated {

    private Api api;

    public RemoveDuplicated(Api api) {
        this.api = api;
    }

    public List<String> call() {
        return api.getResult();
    }
}
