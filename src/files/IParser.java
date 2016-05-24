package files;

public interface IParser<Type> {
	Type parse(String line);
}
