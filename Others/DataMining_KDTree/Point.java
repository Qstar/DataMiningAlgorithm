package Others.DataMining_KDTree;

import java.util.Objects;

/**
 * 坐标点类
 *
 * @author Qstar
 */
public class Point {
    // 坐标点横坐标
    Double x;
    // 坐标点纵坐标
    Double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y){
        this.x = (Double.parseDouble(x));
        this.y = (Double.parseDouble(y));
    }

    /**
     * 计算当前点与制定点之间的欧式距离
     *
     * @param p 待计算聚类的p点
     */
    double ouDistance(Point p){
        double distance;

        distance = (this.x - p.x) * (this.x - p.x) + (this.y - p.y)
                * (this.y - p.y);
        distance = Math.sqrt(distance);

        return distance;
    }

    /**
     * 判断2个坐标点是否为用个坐标点
     *
     * @param p 待比较坐标点
     */
    public boolean isTheSame(Point p){
        boolean isSame = false;

        if (Objects.equals(this.x, p.x) && Objects.equals(this.y, p.y)) {
            isSame = true;
        }

        return isSame;
    }
}
