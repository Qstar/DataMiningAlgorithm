package Classification.DataMining_CART;

public class Client {
    public static void main(String[] args){
        String filePath = "/Users/Qstar/Desktop/DataMiningAlgorithm/Classification/DataMining_CART/input.txt";

        CARTTool tool = new CARTTool(filePath);

        tool.startBuildingTree();
    }
}
