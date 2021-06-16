import java.util.Random;

public class RandomizeGridUtil {
    public static void randomizePopulation( byte grid[][],int size) {
   // Random r= new Random();
    int d;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j <size; j++) {
            if((i+j)== size -1){
                lightUpCells(grid,i+j);
            }
        }
    }
    // randomizePopulation(n);
}

    public static void lightUpCells(byte grid[][],int n) {

        if(n<2){
            return;
        }
        int i=n;
        int k=(i+1)%grid.length;
        grid[i][i]=1;
        grid[k][i]=1;
        grid[k][k]=1;
        //grid[i][k]=1;
        // grid[i][i+1]=1;
       // grid[i-1][i-1]=1;
        grid[i-1][i]=1;
        grid[i][i-1]=1;

        lightUpCells(grid ,n-23);
    }


    public static void diagonalPopulation( byte grid[][],int size) {
        // Random r= new Random();
        int d;
        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j <size-1; j++) {
               if((i+j)%3==2){

                   grid[i][j]=1;
                   //  grid[j][j]=1;
                   grid[i+1][j+1]=1;
                   grid[i][j+1]=1;
                   grid[i-1][j-1]=1;
                   grid[i-1][j]=1;
                   grid[i][j-1]=1;
                   grid[i+1][j]=1;
                 /*  grid[i][i]=1;
                   grid[i][j]=1;
                   grid[j][j]=1;
                   //grid[i][k]=1;
                   // grid[i][i+1]=1;
                   // grid[i-1][i-1]=1;
                   grid[i-1][j]=1;
                   grid[i][j-1]=1;*/
               }
            }
        }
    }


    public static void squarePopulation( byte grid[][],int size) {
        // Random r= new Random();
        int d;
        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j <size-1; j++) {
                if((i+j)%8==0 ){

                  /* // grid[i][i]=1;
                    grid[i][j]=1;
                   // grid[j][j]=1;
                    //grid[i][k]=1;
                    // grid[i][i+1]=1;
                    // grid[i-1][i-1]=1;
                    grid[i-1][j]=1;
                    grid[i][j-1]=1;
*/

                    grid[i][j]=1;
                    //  grid[j][j]=1;
                    grid[i+1][j+1]=1;
                    grid[i][j+1]=1;
                    grid[i-1][j-1]=1;
                    grid[i-1][j]=1;
                    grid[i][j-1]=1;
                    grid[i+1][j]=1;
                }
            }
        }
    }
    private static final float X_DIVIDED_BY_Y = 0.5f;
    private static final float THRESHOLD = 0.5f;
    private static final float A = 53;
    private static int sentenceIndex = 0;



    public static void heart(byte grid[][],int size){

        float MAX_Y = size/2;
        float MAX_X = MAX_Y / X_DIVIDED_BY_Y;
            for (int i = 0; i <= MAX_Y; i++) {
                for (int j = 0; j <= MAX_X; j++) {
                    if(func(getY(i,MAX_Y), getX(j,MAX_X))){

                        //grid[i][i]=1;
                        grid[i][j]=1;
                      //  grid[j][j]=1;
                        grid[i+1][j+1]=1;
                        grid[i][j+1]=1;
                        grid[i-1][j-1]=1;
                        grid[i-1][j]=1;
                        grid[i][j-1]=1;
                        grid[i+1][j]=1;

                    }
                 //   System.out.print(func(getY(y,MAX_Y), getX(x,MAX_X)) ? getSentenceChar() : '=');
                }
                //System.out.println();
            }
        }

        public static final float getX(float x,float MAX_X) {
            return (x - MAX_X / 2) * X_DIVIDED_BY_Y;
        }

        public static final float getY(float y,float MAX_Y) {
            return MAX_Y / 7f - y;
        }

        public static boolean func(float x, float y) {
            return (Math.pow(x, 2) + Math.pow(y, 2) +
                    A * x - A * Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))) < THRESHOLD;
        }

}

