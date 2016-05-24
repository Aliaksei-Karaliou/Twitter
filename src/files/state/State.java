package files.state;

import defaultPackage.Coordinate;
import files.IParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class State{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	private Coordinate[] points;
	public Coordinate[] getCoordinates(){
		return points;
	}
	public State(String name){
		this.name=name;
		points=new Coordinate[0];
	}

	public void AddCoordinate(Coordinate newCoordinate){
		ArrayList<Coordinate> buf=new ArrayList<Coordinate>(Arrays.asList(points));
		buf.add(newCoordinate);
		points=buf.toArray(points);
	}

	public static class StateParser implements IParser<List<State>> {

        @Override
        public List<State> parse(String line) {
            Vector<State> result=new Vector<State>();
            String[] allStates=line.split("\"");
            for (int i=1;i<allStates.length;i+=2){
                String stateName=allStates[i];
                String stringCoor=allStates[i+1];
                stringCoor=stringCoor.replaceAll("\\[(\\[)*", "(");
                stringCoor=stringCoor.replaceAll("\\](\\])*((,)|(\\}))", ")");
                stringCoor=stringCoor.replaceAll("\\) \\(", "\\)#\\(");
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
}
