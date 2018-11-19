
import java.util.Iterator;

public class EnumerableComparer {


    /// <summary>
/// Compare two sequences of T.
/// </summary>
/// <param name="x">First sequence.</param>
/// <param name="y">Second sequence.</param>
    public int Compare(Iterator<Integer> x, Iterator<Integer> y) {
        while (true) {
            if (!(x.hasNext() || y.hasNext()))
                return 0;

            if (!x.hasNext())
                return -1;
            if (!y.hasNext())
                return 1;

            int itemResult = x.next() - y.next();
            if (itemResult != 0)
                return itemResult;
        }
    }
}