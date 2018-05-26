package com.company;

/**
 * Created by Rares on 21.01.2018.
 */
public class GeometricUtilities {

    private double twiceSignedArea(Point2D a, Point2D b, Point2D c){
        return (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
    }

    public boolean isAntiClockWiseTurn(Point2D a, Point2D b, Point2D c){
        return twiceSignedArea(a,b,c) > 0;
    }

    public boolean areCollinear(Point2D a, Point2D b, Point2D c){
        return twiceSignedArea(a,b,c) == 0;
    }

    public boolean intersect(Point2D a, Point2D b, Point2D c, Point2D d){
        /*
        possible orientations are clockwise, anticlockwise and collinear
        if abc , abd and cda, cdb have different orientations than the two line segments intersect
        Special case when the 3 points of the 4 triplets are collinear, but then just the projections intersect
         */
       boolean c1 = isAntiClockWiseTurn(a,b,c) != isAntiClockWiseTurn(a,b,d);
       boolean c2 = isAntiClockWiseTurn(c,d,a) != isAntiClockWiseTurn(c,d,b);
       if((c1 && c2) == false)
           return areCollinear(a,b,c) && areCollinear(a,b,d) && areCollinear(c,d,a) && areCollinear(c,d,b);
       return true;
    }
    /*
        If a line formed by p, and a point with x bigger than any x of the polygon, same y, intersects a number of odd times the lines of the polygon
        than p is inside. Also p is inside if point is on a line of the polygon
     */
    public boolean insidePolygon(Point2D [] poly, Point2D p){
        //at least 3 vertices in the polygon
        if(poly.length < 3)
            return false;

        //find the most right x, + O(n) complexity, or we could assume that the max x in the right is Integer.MAX_VALUE;
        Point2D extreme = new Point2D(Integer.MAX_VALUE, p.y);
        int i = 0, next = 0, inter = 0;
        while(i < poly.length){
            //special case at the last element
            next = (i + 1)%poly.length;
            if(intersect(poly[i],poly[next],p,extreme))
                inter++;
            if(areCollinear(poly[i],poly[next], p)) {
                // check to see if p is between poly[i] and poly[next]
                if(p.x <= Math.max(poly[i].x, poly[next].x) && p.x >= Math.min(poly[i].x, poly[next].x)
                        && p.y <= Math.max(poly[i].y, poly[next].y) && p.y >= Math.min(poly[i].y, poly[next].y))
                return true;
            }
            i++;
        }
        if(inter % 2 != 0)
            return true;
        return false;
    }

}
