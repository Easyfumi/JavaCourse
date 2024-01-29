package ru.marinin.geometry;

public class Point3D extends Point {
    public int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z=z;
    }

    public Point3D(Point3D point3d) {
        super(point3d);
        this.z= point3d.z;
    }

    public int length(Object point) {
        int katet1 = ((Point3D)point).x - this.x;
        int katet2 = ((Point3D)point).y - this.y;
        int katet3= ((Point3D)point).z - this.z;
        int length = (int) Math.sqrt(Math.pow(katet1, 2) + Math.pow(katet2, 2) + Math.pow(katet3, 2));
        return length;
    }
    @Override
    public Point3D clone() {
        return (Point3D) super.clone();
    }
    @Override
    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}
