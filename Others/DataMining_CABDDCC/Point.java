package Others.DataMining_CABDDCC;

import java.util.Objects;

/**
 * �������
 *
 * @author Qstar
 */
public class Point implements Comparable<Point> {
    //�����id��,id��Ψһ
    int id;
    //���������
    Integer x;
    //����������
    Integer y;
    //������Ƿ��Ѿ�������(����)������������ͨ��ͼ��ʱ���õ�
    boolean isVisited;

    public Point(String id, String x, String y){
        this.id = Integer.parseInt(id);
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
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
        boolean isSamed = false;

        if (Objects.equals(this.x, p.x) && Objects.equals(this.y, p.y)) {
            isSamed = true;
        }

        return isSamed;
    }

    @Override
    public int compareTo(Point p){
        if (this.x.compareTo(p.x) != 0) {
            return this.x.compareTo(p.x);
        } else {
            //�����x������ȵ�����±Ƚ�y����
            return this.y.compareTo(p.y);
        }
    }
}
