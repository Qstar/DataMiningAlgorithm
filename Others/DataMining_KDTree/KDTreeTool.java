package Others.DataMining_KDTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * KD树-k维空间关键数据检索算法工具类
 *
 * @author Qstar
 */
class KDTreeTool {
    // 空间平面的方向
    static final int DIRECTION_X = 0;
    private static final int DIRECTION_Y = 1;

    // 输入的测试数据坐标点文件
    private String filePath;
    // 原始所有数据点数据
    private ArrayList<Point> totalDatas;
    // KD树根节点
    private TreeNode rootNode;

    KDTreeTool(String filePath){
        this.filePath = filePath;

        readDataFile();
    }

    /**
     * 从文件中读取数据
     */
    private void readDataFile(){
        File file = new File(filePath);
        ArrayList<String[]> dataArray = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            String[] tempArray;
            while ((str = in.readLine()) != null) {
                tempArray = str.split(" ");
                dataArray.add(tempArray);
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

        Point p;
        totalDatas = new ArrayList<>();
        for (String[] array : dataArray) {
            p = new Point(array[0], array[1]);
            totalDatas.add(p);
        }
    }

    /**
     * 创建KD树
     */
    TreeNode createKDTree(){
        ArrayList<Point> copyDatas;

        rootNode = new TreeNode();
        // 根据节点开始时所表示的空间时无限大的
        rootNode.range = new Range();
        copyDatas = (ArrayList<Point>) totalDatas.clone();
        recursiveConstructNode(rootNode, copyDatas);

        return rootNode;
    }

    /**
     * 递归进行KD树的构造
     *
     * @param node 当前正在构造的节点
     * @param data 该节点对应的正在处理的数据
     */
    private void recursiveConstructNode(TreeNode node, ArrayList<Point> data){
        int direction;
        ArrayList<Point> leftSideData;
        ArrayList<Point> rightSideData;
        Point p;
        TreeNode leftNode;
        TreeNode rightNode;
        Range range;
        Range range2;

        // 如果划分的数据点集合只有1个数据，则不再划分
        if (data.size() == 1) {
            node.nodeData = data.get(0);
            return;
        }

        // 首先在当前的数据点集合中进行分割方向的选择
        direction = selectSplitDrc(data);
        // 根据方向取出中位数点作为数据矢量
        p = getMiddlePoint(data, direction);

        node.spilt = direction;
        node.nodeData = p;

        leftSideData = getLeftSideData(data, p, direction);
        data.removeAll(leftSideData);
        // 还要去掉自身
        data.remove(p);
        rightSideData = data;

        if (leftSideData.size() > 0) {
            leftNode = new TreeNode();
            leftNode.parentNode = node;
            range2 = Range.initLeftRange(p, direction);
            // 获取父节点的空间矢量，进行交集运算做范围拆分
            range = node.range.crossOperation(range2);
            leftNode.range = range;

            node.leftNode = leftNode;
            recursiveConstructNode(leftNode, leftSideData);
        }

        if (rightSideData.size() > 0) {
            rightNode = new TreeNode();
            rightNode.parentNode = node;
            range2 = Range.initRightRange(p, direction);
            // 获取父节点的空间矢量，进行交集运算做范围拆分
            range = node.range.crossOperation(range2);
            rightNode.range = range;

            node.rightNode = rightNode;
            recursiveConstructNode(rightNode, rightSideData);
        }
    }

    /**
     * 搜索出给定数据点的最近点
     *
     * @param p 待比较坐标点
     */
    Point searchNearestData(Point p){
        // 节点距离给定数据点的距离
        TreeNode nearestNode;
        // 用栈记录遍历过的节点
        Stack<TreeNode> stackNodes;

        stackNodes = new Stack<>();
        findedNearestLeafNode(p, rootNode, stackNodes);

        // 取出叶子节点，作为当前找到的最近节点
        nearestNode = stackNodes.pop();
        nearestNode = dfsSearchNodes(stackNodes, p, nearestNode);

        return nearestNode.nodeData;
    }

    /**
     * 深度优先的方式进行最近点的查找
     *
     * @param stack       KD树节点栈
     * @param desPoint    给定的数据点
     * @param nearestNode 当前找到的最近节点
     */
    private TreeNode dfsSearchNodes(Stack<TreeNode> stack, Point desPoint,
                                    TreeNode nearestNode){
        // 是否碰到父节点边界
        boolean isCollision;
        double minDis;
        double dis;
        TreeNode parentNode;

        // 如果栈内节点已经全部弹出，则遍历结束
        if (stack.isEmpty()) {
            return nearestNode;
        }

        // 获取父节点
        parentNode = stack.pop();

        minDis = desPoint.ouDistance(nearestNode.nodeData);
        dis = desPoint.ouDistance(parentNode.nodeData);

        // 如果与当前回溯到的父节点距离更短，则搜索到的节点进行更新
        if (dis < minDis) {
            minDis = dis;
            nearestNode = parentNode;
        }

        // 默认没有碰撞到
        isCollision = false;
        // 判断是否触碰到了父节点的空间分割线
        if (parentNode.spilt == DIRECTION_X) {
            if (parentNode.nodeData.x > desPoint.x - minDis
                    && parentNode.nodeData.x < desPoint.x + minDis) {
                isCollision = true;
            }
        } else {
            if (parentNode.nodeData.y > desPoint.y - minDis
                    && parentNode.nodeData.y < desPoint.y + minDis) {
                isCollision = true;
            }
        }

        // 如果触碰到父边界了，并且此节点的孩子节点还未完全遍历完，则可以继续遍历
        if (isCollision
                && (!parentNode.leftNode.isVisited || !parentNode.rightNode.isVisited)) {
            TreeNode newNode;
            // 新建当前的小局部节点栈
            Stack<TreeNode> otherStack = new Stack<>();
            // 从parentNode的树以下继续寻找
            findedNearestLeafNode(desPoint, parentNode, otherStack);
            newNode = dfsSearchNodes(otherStack, desPoint, otherStack.pop());

            dis = newNode.nodeData.ouDistance(desPoint);
            if (dis < minDis) {
                nearestNode = newNode;
            }
        }

        // 继续往上回溯
        nearestNode = dfsSearchNodes(stack, desPoint, nearestNode);

        return nearestNode;
    }

    /**
     * 找到与所给定节点的最近的叶子节点
     *
     * @param p     待比较节点
     * @param node  当前搜索到的节点
     * @param stack 遍历过的节点栈
     */
    private void findedNearestLeafNode(Point p, TreeNode node,
                                       Stack<TreeNode> stack){
        // 分割方向
        int splitDic;

        // 将遍历过的节点加入栈中
        stack.push(node);
        // 标记为访问过
        node.isVisited = true;
        // 如果此节点没有左右孩子节点说明已经是叶子节点了
        if (node.leftNode == null && node.rightNode == null) {
            return;
        }

        splitDic = node.spilt;
        // 选择一个符合分割范围的节点继续递归搜寻
        if ((splitDic == DIRECTION_X && p.x < node.nodeData.x)
                || (splitDic == DIRECTION_Y && p.y < node.nodeData.y)) {
            if (node.leftNode != null) {
                if (!node.leftNode.isVisited) {
                    findedNearestLeafNode(p, node.leftNode, stack);
                } else {
                    // 如果左孩子节点已经访问过，则访问另一边
                    findedNearestLeafNode(p, node.rightNode, stack);
                }
            }
        } else if ((splitDic == DIRECTION_X && p.x > node.nodeData.x)
                || (splitDic == DIRECTION_Y && p.y > node.nodeData.y)) {
            if (!node.rightNode.isVisited) {
                findedNearestLeafNode(p, node.rightNode, stack);
            } else {
                // 如果右孩子节点已经访问过，则访问另一边
                findedNearestLeafNode(p, node.leftNode, stack);
            }
        }
    }

    /**
     * 根据给定的数据点通过计算反差选择的分割点
     *
     * @param data 部分的集合点集合
     */
    private int selectSplitDrc(ArrayList<Point> data){
        int direction;
        double avgX = 0;
        double avgY = 0;
        double varianceX = 0;
        double varianceY = 0;

        for (Point p : data) {
            avgX += p.x;
            avgY += p.y;
        }

        avgX /= data.size();
        avgY /= data.size();

        for (Point p : data) {
            varianceX += (p.x - avgX) * (p.x - avgX);
            varianceY += (p.y - avgY) * (p.y - avgY);
        }

        // 求最后的方差
        varianceX /= data.size();
        varianceY /= data.size();

        // 通过比较方差的大小决定分割方向，选择波动较大的进行划分
        direction = varianceX > varianceY ? DIRECTION_X : DIRECTION_Y;

        return direction;
    }

    /**
     * 根据坐标点方位进行排序，选出中间点的坐标数据
     *
     * @param datas 数据点集合
     * @param dir   排序的坐标方向
     */
    private Point getMiddlePoint(ArrayList<Point> datas, int dir){
        int index;
        Point middlePoint;

        index = datas.size() / 2;
        if (dir == DIRECTION_X) {
            Collections.sort(datas, (o1, o2) -> o1.x.compareTo(o2.x));
        } else {
            Collections.sort(datas, (o1, o2) -> o2.y.compareTo(o1.y));
        }

        // 取出中位数
        middlePoint = datas.get(index);

        return middlePoint;
    }

    /**
     * 根据方向得到原部分节点集合左侧的数据点
     *
     * @param data     原始数据点集合
     * @param nodeData 数据矢量
     * @param dir      分割方向
     */
    private ArrayList<Point> getLeftSideData(ArrayList<Point> data,
                                             Point nodeData, int dir){
        ArrayList<Point> leftSideDatas = new ArrayList<>();

        for (Point p : data) {
            if (dir == DIRECTION_X && p.x < nodeData.x) {
                leftSideDatas.add(p);
            } else if (dir == DIRECTION_Y && p.y < nodeData.y) {
                leftSideDatas.add(p);
            }
        }

        return leftSideDatas;
    }
}
