import java.util.ArrayList;
import java.util.List;

public class GridCalculator {

    int size = 0;

    public byte[][] getGrid() {
        return grid;
    }

    byte grid[][];
    private List<Coordinates> futureState;

    GridCalculator(int size) {
        grid = new byte[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                grid[i][j] = 0;
            }
        }
        this.size = size;
    }




    /**
     * -Any live cell with fewer than two live neighbors dies, as if caused by under population.
     * -Any live cell with two or three live neighbors lives on to the next generation.
     * -Any live cell with more than three live neighbors dies, as if by overpopulation.
     * -Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     *
     * @return
     */
    public List<Coordinates> applyConwaysRuleToGrid() {

        List<Coordinates> listOfCoordsThatChanged = new ArrayList<>();
        boolean flip = false;
        byte sum;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum= sumOfAlive(i, j);
                if (grid[i][j] == 1) {
                    if (checkUnderPopualtionRule(sum) || checkOverPopulationRule(sum)) {
                        flip = true;
                    }
                } else {
                    if (checkReproductionRule(sum)) {
                        flip = true;
                    }
                }

                if (flip) {
                    listOfCoordsThatChanged.add(new Coordinates(i, j, grid[i][j]));
                    flip=false;
                }
            }
        }
        futureState=listOfCoordsThatChanged;
        return listOfCoordsThatChanged;
    }

    private boolean checkOverPopulationRule(byte sum) {
        return sum>3;
    }

    private boolean checkReproductionRule(byte sum) {
        return sum==3;
    }

    private boolean checkUnderPopualtionRule(byte sum) {
       return sum <2;
    }

    private byte sumOfAlive(int i, int j) {
        byte sum = 0;
        int start_i= i-1>=0?i-1:0;
        int start_j= j-1>=0?j-1:0;
        int end_i= i+1< size -1?i+1: size -1;
        int end_j= j+1< size -1?j+1: size -1;

for(int k=start_i;k<=end_i;k++)
    for(int l=start_j;l<=end_j;l++){
        if(k==i&&l==j){
            continue;
        }
        sum+=grid[k][l];
    }
       // System.out.println("Sum of {"+i+"} and {"+j+"} = {"+sum+"}");
        return sum;
    }

    public void moveGridToNextGeneration() {
        for(Coordinates c:futureState){
            grid[c.getX()][c.getY()] =c.val;
        }
    }


    public void displayGrid(){
        for (int i = 0; i < this.getGrid().length; i++) {
            for (int j = 0; j < this.getGrid().length; j++) {
                if(this.getGrid()[i][j]==1){
                    System.out.print('+');
                }else {
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }

    public byte[][] playWithGrid(){
      //  this=new GridCalculator(n);
       // RandomizeGridUtil.diagonalPopulation(grid, size);
        //RandomizeGridUtil.randomizePopulation(grid, size);
       // transposeGrid();
        RandomizeGridUtil.squarePopulation(grid, size);
       // RandomizeGridUtil.heart(grid,size);
        transposeGrid();
       RandomizeGridUtil.squarePopulation(grid, size);
//        transposeGrid();
       // RandomizeGridUtil.diagonalPopulation(grid, size);
       // RandomizeGridUtil.randomizePopulation(grid, size);
       // RandomizeGridUtil.heart(grid,size);
        System.out.println("Initial Grid");
       // this.displayGrid();
        //transposeGrid();
        System.out.println("transposed Grid");
       // this.displayGrid();
        List<Coordinates> futureState= applyConwaysRuleToGrid();
        moveGridToNextGeneration();
        System.out.println("Manipulated Grid");

       // this.displayGrid();
        return getGrid();
    }

    private void transposeGrid(){
        byte temp;
        for (int i = 1; i < this.getGrid().length; i++) {
            for (int j = 1; j < this.grid.length; j++) {
               temp= grid[i][j];
               grid[i][j]=grid[i][size-j];
                grid[i][size-j]=temp;
            }
        }
    }

    /*writeListOfCoordsToQueue()

    readListOfCoordsFromQueue()

    RefreshTheScreenWithInputFromQueue()*/
}
