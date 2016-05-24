package defaultPackage;

import files.FileLines;
import files.IParser;
import files.state.State;
import files.state.StateParser;
import graphics.StatesScreen;

import java.awt.*;
import java.awt.List;
import java.util.*;
import javax.swing.*;

public class Task7 implements ITask {
    @Override
    public void task(String[] args) {
        IParser<java.util.List<State>> statesParser=new StateParser();
        java.util.List<String> listy= FileLines.fileInputLines("D:\\trends\\data\\states.json");
        java.util.List<State> allStates=statesParser.parse(listy.get(0));
        StatesScreen window=new StatesScreen(allStates);
    }
}