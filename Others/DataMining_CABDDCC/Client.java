package Others.DataMining_CABDDCC;

/**
 * ������ͨͼ�ķ��Ѿ����㷨
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] agrs){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_CABDDCC/graphData.txt";
        //��ͨ������ֵ
        int length = 3;

        CABDDCCTool tool = new CABDDCCTool(filePath, length);
        tool.splitCluster();
    }
}
