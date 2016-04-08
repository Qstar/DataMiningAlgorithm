package GraphMining.DataMining_GSpan;

import java.util.ArrayList;

/**
 * 图编码类
 *
 * @author Qstar
 */
class GraphCode {
    //边的集合，边的排序代表着边的添加次序
    ArrayList<Edge> edgeSeq;
    //拥有这些边的图的id
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
