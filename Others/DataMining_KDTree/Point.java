package Others.DataMining_KDTree;

import java.util.Objects;

/**
 * �������
 *
 * @author Qstar
 */
public class Point {
    // ����������
    Double x;
    // �����������
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
     * ���㵱ǰ�����ƶ���֮���ŷʽ����
     *
     * @param p ����������p��
     */
    double ouDistance(Point p){
        double distance;

        distance = (this.x - p.x) * (this.x - p.x) + (this.y - p.y)
                * (this.y - p.y);
        distance = Math.sqrt(distance);

        return distance;
    }

    /**
     * �ж�2��������Ƿ�Ϊ�ø������
     *
     * @param p ���Ƚ������
     */
    public boolean isTheSame(Point p){
        boolean isSame = false;

        if (Objects.equals(this.x, p.x) && Objects.equals(this.y, p.y)) {
            isSame = true;
        }

        return isSame;
    }
}
