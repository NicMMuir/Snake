import java.awt.*;
import java.util.ArrayList;

public class CalcClosedList {

    ArrayList<Point> mysnake=new ArrayList<Point>();
    ArrayList<ArrayList> othersnakes=new ArrayList<ArrayList>();
    ArrayList<Point> ClosedList = new ArrayList<Point>();
    Point temppoint = new Point();

    public CalcClosedList(ArrayList<Point> mysneke, ArrayList<ArrayList> othersnekes){
        this.mysnake= mysneke;

        this.othersnakes=othersnekes;
        this.othersnakes.add(this.mysnake);



        //this.othersnakes.add(this.mysnake);

    }
    public static void main(String[] args) {

    }

    public void fillsnakes() {


        String moveDirec = "";
        for (int k=0;k<othersnakes.size();k++) {
            ArrayList<Point> temp = new ArrayList<>();
            //temp.clear();
            temp=othersnakes.get(k);
            int ssize=0;

           while(ssize<=(temp.size())-2) {


               Point Point1 = temp.get(ssize) ;
               Point Point2 = temp.get(ssize+1);
               MoveDirec mv = new MoveDirec();
               moveDirec = mv.getDirec(Point1,Point2);

               switch(moveDirec){


                   case "UP":{

                       temppoint=Point1;
                       int count =0;


                       while(temppoint.y<  Point2.y){
                           temppoint = new Point(Point1);
                           temppoint.y = temppoint.y+count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "DOWN":{
                       //Point temppoint = new Point();
                       temppoint=Point1;
                       int count =0;


                       while(temppoint.y>Point2.y) {
                           temppoint = new Point(Point1);
                           temppoint.y = (temppoint.y)-count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "LEFT":{
                      // Point temppoint = new Point();
                       temppoint=Point1;
                       int count =0;



                       while(temppoint.x<Point2.x) {
                           temppoint = new Point(Point1);
                           temppoint.x = (temppoint.x)+count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "RIGHT":{
                       //Point temppoint = new Point();

                       temppoint=Point1;
                       int count =0;



                       while(temppoint.x>Point2.x) {
                           temppoint = new Point(Point1);
                           temppoint.x = (temppoint.x)-count;
                           ClosedList.add(temppoint);
                           count++;


                       }
                       for(int K =0;K<othersnakes.size()-1;K++){

                           Point TempPoint = new Point();
                           ArrayList<Point> Snake = new ArrayList<>();

                           Snake = othersnakes.get(K);
                           if(Snake.size()<1){

                           }else {
                               TempPoint = Snake.get(0);


                               Point Nextpt = new Point(TempPoint);
                               Nextpt.x = Nextpt.x + 1;
                               ClosedList.add(Nextpt);


                               Nextpt = new Point(TempPoint);
                               Nextpt.x = Nextpt.x - 1;
                               ClosedList.add(Nextpt);


                               Nextpt = new Point(TempPoint);
                               Nextpt.y = Nextpt.y + 1;
                               ClosedList.add(Nextpt);


                               Nextpt = new Point(TempPoint);
                               Nextpt.y = Nextpt.y - 1;
                               ClosedList.add(Nextpt);

                           }
                       }


                       break;
                   }





               }

               //temp=othersnakes.get(k);

               ssize++;
           }//While


        }


        return;

    }

    public ArrayList GetCL(){
       // ClosedList.remove(mysnake.get(0));
        return ClosedList;

    }

}
