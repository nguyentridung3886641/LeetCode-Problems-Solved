class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int topRec, bottomRec, leftRec, rightRec;
        topRec = y2;
        bottomRec = y1;
        leftRec = x1;
        rightRec = x2;

        int closestX, closestY;
        if (xCenter >= leftRec && xCenter <= rightRec) {
            closestX = xCenter;
        } else if (xCenter < leftRec) {
            closestX = leftRec;
        } else {
            closestX = rightRec;
        }

        if (yCenter >= bottomRec && yCenter <= topRec) {
            closestY = yCenter;
        } else if (yCenter < bottomRec) {
            closestY = bottomRec;
        } else {
            closestY = topRec;
        }

        double minDist = Math.sqrt(Math.pow((closestX - xCenter), 2) + Math.pow((closestY - yCenter), 2));

        return (minDist <= radius) ? true : false;
    }
}