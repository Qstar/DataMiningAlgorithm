package GraphMining.DataMining_GSpan;

/**
 * gSpanƵ����ͼ�ھ��㷨
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        //���������ļ���ַ
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/GraphMining/DataMining_GSpan/input.txt";
        //��С֧�ֶ���
        double minSupportRate = 0.2;

        GSpanTool tool = new GSpanTool(filePath, minSupportRate);
        tool.freqGraphMining();
    }
}
