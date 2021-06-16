public class Coordinates {

    int x,y;
    Coordinates(int x,int y,byte val){
        this.x=x;
        this.y=y;
        if(val==0)
        this.val=1;
        else this.val=0;
    }

    byte val;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public byte getVal() {
        return val;
    }

    public void setVal(byte val) {
        this.val = val;
    }
}
