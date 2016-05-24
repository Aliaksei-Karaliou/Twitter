package files.state;

import files.IListParser;
import files.IParser;
import defaultPackage.Coordinate;

import java.util.List;
import java.util.Vector;

public class StateParser implements IParser<List<State>> {

	@Override
	public List<State> parse(String line) {
		Vector<State> result=new Vector<State>();
		String[] allStates=line.split("\"");
		for (int i=1;i<allStates.length;i+=2){
			String stateName=allStates[i];
			String stringCoor=allStates[i+1];
			stringCoor=stringCoor.replaceAll("\\[(\\[)*", "[");
			stringCoor=stringCoor.replaceAll("\\](\\])*((,)|(\\}))", "]");
			stringCoor=stringCoor.replaceAll("\\] \\[", "\\]#\\[");
			stringCoor=stringCoor.substring(2);
			String[] allCoor=stringCoor.split("#");
			State newState=new State(stateName);			
			for (int j=0;j<allCoor.length;j++)
				newState.AddCoordinate(new Coordinate(allCoor[j]));
			result.add(newState);
		}
		return result;
	}

}