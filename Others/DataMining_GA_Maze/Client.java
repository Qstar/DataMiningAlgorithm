package Others.DataMining_GA_Maze;

/**
 * �Ŵ��㷨�����Թ���Ϸ��Ӧ��
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        //�Թ���ͼ�ļ����ݵ�ַ
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_GA_Maze/mapData.txt";
        //��ʼ��������
        int initSetsNum = 4;

        GATool tool = new GATool(filePath, initSetsNum);
        tool.goOutMaze();
    }
}
