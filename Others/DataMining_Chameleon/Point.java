package Others.DataMining_Chameleon;


import java.util.Objects;

/**
 * �������
 *
 * @author lyq
 */
public class Point {
    //�����id��,id��Ψһ
    int id;
    //���������
    Integer x;
    //����������
    Integer y;
    //�Ƿ��Ѿ������ʹ�
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
}
