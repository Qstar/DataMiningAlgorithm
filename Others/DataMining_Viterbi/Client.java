package Others.DataMining_Viterbi;

/**
 * ά�ر��㷨
 *
 * @author Qstar
 */
public class Client {
    public static void main(String[] args){
        // ״̬ת�Ƹ��ʾ���·��
        String stmFilePath;
        // ��������·��
        String cfFilePath;
        // �۲쵽��״̬
        String[] observeStates;
        // ��ʼ״̬
        double[] initStatePro;
        ViterbiTool tool;

        stmFilePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_Viterbi/stmatrix.txt";
        cfFilePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Others/DataMining_Viterbi/humidity-matrix.txt";

        initStatePro = new double[]{0.63, 0.17, 0.20};
        observeStates = new String[]{"Dry", "Damp", "Soggy"};

        tool = new ViterbiTool(stmFilePath, cfFilePath, initStatePro,
                observeStates);
        tool.calHMMObserve();
    }
}
