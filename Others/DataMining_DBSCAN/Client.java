package Others.DataMining_DBSCAN;

/**
 * Dbscan�����ܶȵľ����㷨������
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_DBSCAN/input.txt";
        //��ɨ��뾶
        double eps = 3;
        //��С����������ֵ
        int minPts = 3;

        DBSCANTool tool = new DBSCANTool(filePath, eps, minPts);
        tool.dbScanCluster();
    }
}
