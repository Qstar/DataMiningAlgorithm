package Classification.DataMining_KNN;

/**
 * k������㷨��������
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] args){
        String trainDataPath = "C:\\Users\\lyq\\Desktop\\icon\\trainInput.txt";
        String testDataPath = "C:\\Users\\lyq\\Desktop\\icon\\testinput.txt";

        KNNTool tool = new KNNTool(trainDataPath, testDataPath);
        tool.knnCompute(3);
    }
}
