package com.company;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rares on 21.01.2018.
 */
public class Point2D implements  Comparable<Point2D> {
    public int x;
    public int y;

    public  Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double calcDistance(Point2D p){
       int Dx = this.x - p.x;
       int Dy = this.y - p.y;
       return Math.sqrt(Math.pow(Dx,2) + Math.pow(Dy, 2));
    }

    public void sort(List<Point2D> arr){
        Collections.sort(arr);
    }

    @Override
    public int compareTo(Point2D p) {
        Point2D origin = new Point2D(0,0);
       double distThis = this.calcDistance(origin);
       double distP = p.calcDistance(origin);
       if(distThis > distP)
           return 1;
       if (distThis < distP)
           return -1;
       return 0;
    }
}
