package GraphMining.DataMining_GSpan;

import java.util.ArrayList;

/**
 * ͼ������
 *
 * @author Qstar
 */
class GraphCode {
    //�ߵļ��ϣ��ߵ���������űߵ���Ӵ���
    ArrayList<Edge> edgeSeq;
    //ӵ����Щ�ߵ�ͼ��id
    ArrayList<Integer> gs;

    GraphCode(){
        this.edgeSeq = new ArrayList<>();
        this.gs = new ArrayList<>();
    }

    ArrayList<Edge> getEdgeSeq(){
        return edgeSeq;
    }

    ArrayList<Integer> getGs(){
        return gs;
    }

}
