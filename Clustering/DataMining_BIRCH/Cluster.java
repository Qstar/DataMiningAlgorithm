package Clustering.DataMining_BIRCH;

import java.util.ArrayList;

/**
 * Ҷ�ӽڵ��е�С��Ⱥ
 *
 * @author lyq
 */
class Cluster extends ClusteringFeature {
    //��Ⱥ�е����ݵ�
    private ArrayList<double[]> data;
    //���׽ڵ�
    private LeafNode parentNode;

    Cluster(String[] record){
        double[] d = new double[record.length];
        data = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            d[i] = Double.parseDouble(record[i]);
        }
        data.add(d);
        //����CF��������
        this.setLS(data);
        this.setSS(data);
        this.setN(data);
    }

    ArrayList<double[]> getData(){
        return data;
    }

    @Override
    protected void directAddCluster(ClusteringFeature node){
        //����Ǿ���������ݼ�¼������ϲ����ݼ�¼
        Cluster c = (Cluster) node;
        ArrayList<double[]> dataRecords = c.getData();
        this.data.addAll(dataRecords);

        super.directAddCluster(node);
    }

    LeafNode getParentNode(){
        return parentNode;
    }

    void setParentNode(LeafNode parentNode){
        this.parentNode = parentNode;
    }

    @Override
    public void addingCluster(ClusteringFeature clusteringFeature){
        // TODO Auto-generated method stub

    }
}
