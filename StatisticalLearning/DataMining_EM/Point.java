package StatisticalLearning.DataMining_EM;

/**
 * �������
 *
 * @author Qstar
 */
public class Point {
    // ����������
    private double x;
    // �����������
    private double y;
    // ��������P1��������
    private double memberShip1;
    // ��������P2��������
    private double memberShip2;

    public Point(double d, double e){
        this.x = d;
        this.y = e;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    double getMemberShip1(){
        return memberShip1;
    }

    void setMemberShip1(double memberShip1){
        this.memberShip1 = memberShip1;
    }

    double getMemberShip2(){
        return memberShip2;
    }

    void setMemberShip2(double memberShip2){
        this.memberShip2 = memberShip2;
    }

}
