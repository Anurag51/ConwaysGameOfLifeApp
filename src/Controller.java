/*
import java.util.List;

public class Controller {

    GridCalculator grCalc;

    public void displayGrid(){
        for (int i = 0; i < grCalc.getGrid().length; i++) {
            for (int j = 0; j < grCalc.getGrid().length; j++) {
                if(grCalc.getGrid()[i][j]==1){
                    System.out.print('+');
                }else {
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }

    public byte[][] playWithGrid(int n){
        grCalc=new GridCalculator(n);
        grCalc.randomizePopulation();
        System.out.println("Initial Grid");
        this.displayGrid();

        grCalc.applyConwaysRuleToGrid();
        grCalc.moveGridToNextGeneration();
        System.out.println("Manipulated Grid");

        this.displayGrid();
        return grCalc.getGrid();
    }
}
*/
