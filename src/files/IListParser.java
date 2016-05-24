package files;

import java.util.List;

/**
 * Created by korol on 27.04.16.
 */
public interface IListParser<Type> {
    List<Type> parse (List<String> line);
}
